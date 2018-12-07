package mandatory.school.administration.Services.Application;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Services.course.CourseService;
import mandatory.school.administration.Services.student.StudentService;

import java.util.List;

public interface ApplicationService
{
    Application getApplicationByStudentIdAndCourseId(int studentId, int courseId);
    List<Application> getAllApplications();
    void acceptApplication(Student studentId, Course courseId, StudentService studentService, CourseService courseService);
    void createApplication(Student student, Course course, StudentService studentService, CourseService courseService);
    void removeSignup (Student student, int courseId, StudentService studentService);
}
