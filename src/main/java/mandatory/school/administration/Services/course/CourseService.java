package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;

import java.util.List;

public interface CourseService
{
    Course createCourse(Course course);

    Course createCourseLegacy(Course course);

    Course findCourseById(int id);

    void editCourse(Course course);

    void deleteCourse(Course course);

    void deleteCourseById(int id);

    List<Course> getAllCourses();

    List<Course> getAllCoursesLegacy();

    List<Course> getAllByStudentId(int studentId);

    long countCourses();
}