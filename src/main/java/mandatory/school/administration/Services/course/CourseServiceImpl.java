package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.StudentCourse;
import mandatory.school.administration.Model.Teacher;
import mandatory.school.administration.Model.TeacherCourse;
import mandatory.school.administration.Repositories.course.CourseRepository;
import mandatory.school.administration.Services.teacher.TeacherService;
import mandatory.school.administration.Utilities.CourseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository repository;


    @Override
    public Course createCourse(Course course)
    {
        return repository.save(course);
    }

    @Override
    public Course createCourseLegacy(Course course)
    {
        return repository.postCourseLegacy(course);
    }

    @Override
    public Course findCourseById(int id)
    {
        return repository.getOne(id);
    }

    @Override
    public void editCourse(Course course)
    {
        repository.save(course);
    }

    @Override
    public void deleteCourse(Course course)
    {
        repository.delete(course);
    }

    @Override
    public void deleteCourseById(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourses()
    {
        return repository.findAll();
    }

    @Override
    //@Scheduled(fixedRate = 120 * 1000)
    public void getAllCoursesLegacy()
    {
        ArrayList<Course> legacyCourses = new ArrayList<>(Arrays.asList(repository.getCoursesLegacy()));
        ArrayList<Course> localCourses = new ArrayList<>(repository.findAll());
        ArrayList<Course> missingCourses = new ArrayList<>();

        Map<String, String> names = new HashMap<>();
        for (Course c: localCourses)
        {
            names.put(c.getNameDanish(), c.getNameEnglish() + c.getLanguage());
        }

        for (Course legacy : legacyCourses)
        {
            if(!names.containsKey(legacy.getNameDanish()) || !names.containsValue(legacy.getNameEnglish() + legacy.getLanguage()))
            {
                missingCourses.add(legacy);
            }
        }

        if (!missingCourses.isEmpty())
        {
            saveAll(missingCourses);
        }
    }

    @Override
    public void saveAll(List<Course> courses)
    {
        repository.saveAll(courses);
    }

    @Override
    public List<Course> getAllCoursesStudentHasApplied(int studentId)
    {
        return new ArrayList<>(repository.findAllByApplications_studentId(studentId));
    }

    @Override
    public List<Course> getAllCoursesStudentHasEnrolled(int studentId)
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
        Course course = findCourseById(courseId);

        TeacherCourse teacherCourse = CourseUtilities.getTeacherCourseByTeacherIdAndCourseId(teacherId, courseId, course.getTeacherCourses());
        course.getTeacherCourses().remove(teacherCourse);
        editCourse(course);
    }

    @Override
    public void removeStudentFromCourse(int studentId, int courseId)
    {
        Course course = findCourseById(courseId);

        StudentCourse studentCourse = CourseUtilities.getStudentCourseByStudentIdAndCourseId(studentId, courseId, course.getStudentCourses());
        course.getStudentCourses().remove(studentCourse);
        editCourse(course);
    }
}
