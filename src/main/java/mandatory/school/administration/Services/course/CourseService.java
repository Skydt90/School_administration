package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.LocalCourse;

import java.util.List;

public interface CourseService
{
    LocalCourse createLocalCourse(LocalCourse course);

    Course createCourseLegacy(Course course);

    LocalCourse findCourseById(int id);

    void editCourse(LocalCourse course);

    void deleteCourse(LocalCourse course);

    void deleteCourseById(int id);

    void saveAll(List<LocalCourse> courses);

    List<LocalCourse> getAllCourses();

    List<Course> getAllCoursesLegacy();

    List<LocalCourse> getAllCoursesStudentHasApplied(int studentId);

    List<LocalCourse> getAllCoursesStudentHasEnrolled(int studentId);

    void updateCourses();

    List<Course> getFullCourses();

    Course getFullCourseById(int id);

    long countCourses();

    void removeTeacherFromCourse(int teacherId, int courseId);
    void removeStudentFromCourse(int studentid, int courseId);
}