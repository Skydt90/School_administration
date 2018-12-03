package mandatory.school.administration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolAdministrationApplication
{
    private static final Logger LOG = LoggerFactory.getLogger("LOG");



    public static void main(String[] args)
    {
        SpringApplication.run(SchoolAdministrationApplication.class, args);
    }

    /*
    @Override
    public void run(String... wohoo)
    {
        // CRUD

        user user = userService.createUser(new user("MrPieler", "SygKode", "student"));
        LOG.info("user created in DB : {} ", user);

        student student1 = service.createStudent(new student("Mikkel", "Pieler", "MrPieler"));
        LOG.info("student created in DB : {} ", student1);
        LOG.info("Current students in DB : {}", service.countStudents());

        /*
        student dbStudent = service.findStudentById(1);
        LOG.info("student read from DB : {}", dbStudent);

        student1.setName("JakobErDetNyeBlå");
        service.editStudent(student1);
        LOG.info("Changed student1 name: {}", student1);

        service.deleteStudent(student1);
        LOG.info("Deleted student1 : {}", student1);
        LOG.info("Current students in DB : {}", service.countStudents());

        List<student> students = service.getAllStudents();
        LOG.info("List of all students: {}", students); */
    }

