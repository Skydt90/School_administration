package mandatory.school.administration.Services.Application;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Model.StudentCourse;
import mandatory.school.administration.Repositories.Application.ApplicationRepository;
import mandatory.school.administration.Services.course.CourseService;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Utilities.ApplicationUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService
{
    @Autowired
    ApplicationRepository repository;

    @Override
    public Application getApplicationByStudentIdAndCourseId(int studentId, int courseId)
    {
        return repository.findApplicationByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Application> getAllApplications()
    {
        return repository.findAllApplications();
    }

    @Override
    public void acceptApplication(Student student, Course course, StudentService studentService, CourseService courseService)
    {
        //  create new studentCourse
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);

        //  add studentCourse to student
        student.getStudentCourses().add(studentCourse);

        //  remove application
        Application application = ApplicationUtilities.getApplicationByStudentIdAndCourseId(student.getId(), course.getId(), new ArrayList<>(student.getApplications()));
        student.getApplications().remove(application);

        //  save update
        courseService.createCourse(course);
        studentService.createStudent(student);
    }

    @Override
    public void createApplication(Student student, Course course, StudentService studentService, CourseService courseService)
    {
        Application application = new Application();
        application.setStudent(student);
        application.setCourse(course);
        application.setTimestamp(new Date());

        student.getApplications().add(application);
        courseService.editCourse(course);
        studentService.editStudent(student);
    }

    @Override
    public void removeSignup(Student student, int courseId, StudentService studentService)
    {
        Application application = getApplicationByStudentIdAndCourseId(student.getId(), courseId);

        student.getApplications().remove(application);
        studentService.editStudent(student);
    }
}
