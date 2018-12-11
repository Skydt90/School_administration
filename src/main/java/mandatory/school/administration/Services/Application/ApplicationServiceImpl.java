package mandatory.school.administration.Services.Application;

import mandatory.school.administration.Model.*;
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
    @Autowired
    CourseService courseService;

    @Override
    public Application getApplicationByStudentIdAndCourseId(int studentId, int courseId)
    {
        Application value = repository.findApplicationByStudentIdAndCourseId(studentId, courseId);
        ArrayList<LocalCourse> list = new ArrayList<>();
        list.add(value.getCourse());
        value.setFullCourse(courseService.convertToFullCourses(list).get(0));
        return value;
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
        studentCourse.setCourse(course.getLocalCourse());

        //  add studentCourse to student
        student.getStudentCourses().add(studentCourse);

        //  remove application
        Application application = ApplicationUtilities.getApplicationByStudentIdAndCourseId(student.getId(), course.getId(), new ArrayList<>(student.getApplications()));
        student.getApplications().remove(application);

        //  save update
        courseService.createLocalCourse(course.getLocalCourse());
        studentService.createStudent(student);
    }

    @Override
    public void createApplication(Student student, Course course, StudentService studentService, CourseService courseService)
    {
        Application application = new Application();
        application.setStudent(student);
        application.setCourse(course.getLocalCourse());
        application.setTimestamp(new Date());

        student.getApplications().add(application);
        courseService.editCourse(course.getLocalCourse());
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
