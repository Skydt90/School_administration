package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.LocalCourse;

import java.util.List;

public interface CourseService
{
    void createLocalCourse(LocalCourse course);

    Course createCourseLegacy(Course course);

    LocalCourse findCourseById(int id);

    void editCourse(LocalCourse course);

    void deleteCourse(LocalCourse course);

    void deleteCourseById(int id);

    List<LocalCourse> getAllCourses();

    List<Course> getAllCoursesLegacy();

    List<LocalCourse> getAllCoursesStudentHasApplied(int studentId);

    List<LocalCourse> getAllCoursesStudentHasEnrolled(int studentId);

    List<Course> convertToFullCourses(List<LocalCourse> localCourses);

    void updateCourses();

    List<Course> getFullCourses();

    Course getFullCourseById(int id);

    boolean getIsShowAbleBasedOnAuthority();

    void removeTeacherFromCourse(int teacherId, int courseId);

    void removeStudentFromCourse(int studentid, int courseId);
}