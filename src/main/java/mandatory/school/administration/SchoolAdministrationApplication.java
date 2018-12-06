package mandatory.school.administration;

import mandatory.school.administration.Controller.CourseController;
import mandatory.school.administration.Repositories.UsertypeRepository;
import mandatory.school.administration.Repositories.course.CourseRepository;
import mandatory.school.administration.Repositories.student.StudentRepository;
import mandatory.school.administration.Repositories.teacher.TeacherRepository;
import mandatory.school.administration.Repositories.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.transaction.Transactional;

@SpringBootApplication
@EnableScheduling
public class SchoolAdministrationApplication implements CommandLineRunner
{
    private static final Logger LOG = LoggerFactory.getLogger("LOG");


    @Autowired
    UserRepository userRepository;
    @Autowired
    UsertypeRepository usertypeRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseController courseController;

    public static void main(String[] args)
    {
        SpringApplication.run(SchoolAdministrationApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... strings) throws Exception
    {
        /*
        Course course = courseRepository.getOne(3);
        Student student = studentRepository.getOne(1);
        //Teacher teacher = teacherRepository.getOne(2);

        //TeacherCourse teacherCourse = course.getTeacherCourseByTeacherIdAndCourseId(teacher.getId(), course.getId());

        //course.getTeacherCourses().remove(teacherCourse);

        Application application = new Application();
        application.setStudent(student);
        application.setCourse(course);
        application.setTimestamp(new Date());

        course.getApplications().add(application);*/
    }
}

