package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Teacher;
import mandatory.school.administration.Services.teacher.TeacherService;

import java.util.List;

public interface CourseService
{
    Course createCourse(Course course);

    Course createCourseLegacy(Course course);

    Course findCourseById(int id);

    void editCourse(Course course);

    void deleteCourse(Course course);

    void deleteCourseById(int id);

    void saveAll(List<Course> courses);

    List<Course> getAllCourses();

    void getAllCoursesLegacy();

    List<Course> getAllCoursesStudentHasApplied(int studentId);

    List<Course> getAllCoursesStudentHasEnrolled(int studentId);

    long countCourses();

    void removeTeacherFromCourse(int teacherId, int courseId);
    void removeStudentFromCourse(int studentid, int courseId);
}