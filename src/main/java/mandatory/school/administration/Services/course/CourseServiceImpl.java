package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.LocalCourse;
import mandatory.school.administration.Model.StudentCourse;
import mandatory.school.administration.Model.TeacherCourse;
import mandatory.school.administration.Repositories.course.CourseRepository;
import mandatory.school.administration.Utilities.CourseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository repository;
    @Autowired
    private CourseUtilities courseUtilities;

    private List<Course> courses = new ArrayList<>();


    @Override
    public void createLocalCourse(LocalCourse course)
    {
        repository.save(course);
    }

    @Override
    public Course createCourseLegacy(Course course)
    {
        return repository.postCourseLegacy(course);
    }

    @Override
    public LocalCourse findCourseById(int id)
    {
        return repository.getOne(id);
    }

    @Override
    public void editCourse(LocalCourse course)
    {
        repository.save(course);
    }

    @Override
    public void deleteCourse(LocalCourse course)
    {
        repository.delete(course);
    }

    @Override
    public void deleteCourseById(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public List<LocalCourse> getAllCourses()
    {
        return repository.findAll();
    }

    @Override
    public List<Course> getAllCoursesLegacy()
    {
        return new ArrayList<>(Arrays.asList(repository.getCoursesLegacy()));
    }

    @Override
    public List<LocalCourse> getAllCoursesStudentHasApplied(int studentId)
    {
        return new ArrayList<>(repository.findAllByApplications_studentId(studentId));
    }

    @Override
    public List<LocalCourse> getAllCoursesStudentHasEnrolled(int studentId)
    {
        return repository.findAllByStudentCourses_studentId(studentId);
    }

    @Override
    public List<LocalCourse> getAllCoursesTeacherAreTeaching(int teacherId)
    {
        return repository.findAllByTeacherCourses_teacherId(teacherId);
    }

    @Override
    public List<Course> convertToFullCourses(List<LocalCourse> localCourses)
    {
        List<Course> value = new ArrayList<>();

        for (LocalCourse lc: localCourses)
        {
            value.add(getFullCourseById(lc.getId()));
        }

        return value;
    }

    @Override
    public void removeTeacherFromCourse(int courseId, int teacherId)
    {
        LocalCourse course = findCourseById(courseId);

        TeacherCourse teacherCourse = courseUtilities.getTeacherCourseByTeacherIdAndCourseId(teacherId, courseId, course.getTeacherCourses());
        course.getTeacherCourses().remove(teacherCourse);
        editCourse(course);
    }

    @Override
    public void removeStudentFromCourse(int courseId, int studentId)
    {
        LocalCourse course = findCourseById(courseId);

        StudentCourse studentCourse = courseUtilities.getStudentCourseByStudentIdAndCourseId(studentId, courseId, course.getStudentCourses());
        course.getStudentCourses().remove(studentCourse);
        editCourse(course);
    }

    @Scheduled(fixedRate = 3600 * 1000)
    @Override
    public void updateCourses()
    {
        courses = getAllCoursesLegacy();
        List<LocalCourse> localCourses = getAllCourses();

        if (localCourses.size() < courses.size())
        {
            for (int i = localCourses.size(); i < courses.size(); i++)
            {
                LocalCourse lc = new LocalCourse (i + 1);
                localCourses.add(lc);
                createLocalCourse(lc);
            }
        }

        for (Course c: courses)
        {
            c.setLocalCourse(localCourses.get(c.getId() -1));
        }
    }

    @Override
    public List<Course> getFullCourses()
    {
        return courses;
    }

    @Override
    public Course getFullCourseById(int id)
    {
        return courses.get(id - 1);
    }

    @Override
    public boolean getIsTeacherOrAdmin()
    {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        for (SimpleGrantedAuthority a: authorities)
        {
            if(a.getAuthority().equals("admin") || a.getAuthority().equals("teacher"))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getIsAdmin()
    {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        for (SimpleGrantedAuthority a: authorities)
        {
            if(a.getAuthority().equals("admin"))
            {
                return true;
            }
        }
        return false;
    }
}
