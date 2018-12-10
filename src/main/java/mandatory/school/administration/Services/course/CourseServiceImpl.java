package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.LocalCourse;
import mandatory.school.administration.Model.StudentCourse;
import mandatory.school.administration.Model.TeacherCourse;
import mandatory.school.administration.Repositories.course.CourseRepository;
import mandatory.school.administration.Utilities.CourseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    public LocalCourse createLocalCourse(LocalCourse course)
    {
        return repository.save(course);
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
    public void saveAll(List<LocalCourse> courses)
    {
        repository.saveAll(courses);
    }

    @Override
    public List<LocalCourse> getAllCoursesStudentHasApplied(int studentId)
    {
        return new ArrayList<>(repository.findAllByApplications_studentId(studentId));
    }

    @Override
    public List<LocalCourse> getAllCoursesStudentHasEnrolled(int studentId)
    {
        return new ArrayList<>(repository.findAllByStudentCourses_studentId(studentId));
    }

    @Override
    public long countCourses()
    {
        return repository.count();
    }

    @Override
    public void removeTeacherFromCourse(int teacherId, int courseId)
    {
        LocalCourse course = findCourseById(courseId);

        TeacherCourse teacherCourse = courseUtilities.getTeacherCourseByTeacherIdAndCourseId(teacherId, courseId, course.getTeacherCourses());
        course.getTeacherCourses().remove(teacherCourse);
        editCourse(course);
    }

    @Override
    public void removeStudentFromCourse(int studentId, int courseId)
    {
        LocalCourse course = findCourseById(courseId);

        StudentCourse studentCourse = courseUtilities.getStudentCourseByStudentIdAndCourseId(studentId, courseId, course.getStudentCourses());
        course.getStudentCourses().remove(studentCourse);
        editCourse(course);
    }

    public void updateCourses()
    {
        courses = getAllCoursesLegacy();
        List<LocalCourse> localCourses = getAllCourses();

        if (localCourses.size() < courses.size())
        {
            for (int i = localCourses.size(); i <= courses.size(); i++)
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

    public List<Course> getFullCourses()
    {
        return courses;
    }

    @Override
    public Course getFullCourseById(int id)
    {
        return courses.get(id - 1);
    }
}
