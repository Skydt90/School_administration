package mandatory.school.administration.Repositories.Application;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Repositories.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository
{
    @Autowired
    StudentRepository repository;

    @Override
    public List<Application> findAllApplications()
    {
        List<Student> students = repository.findAll();
        Set<Application> applications = new HashSet<>();

        for (Student s: students)
        {
            applications.addAll(s.getApplications());
        }

        List<Application> applicationList = new ArrayList<>(applications);
        System.out.println("applications: " + applicationList);
        return applicationList;
    }

    @Override
    public Application findApplicationByStudentIdAndCourseId(int studentId, int courseId)
    {
        List<Student> students = repository.findAll();
        Set<Application> applications = new HashSet<>();

        for (Student s: students)
        {
            applications.addAll(s.getApplications());
        }

        Application application = null;
        for (Application a: applications)
        {
            if (a.getStudent().getId() == studentId && a.getCourse().getId() == courseId)
            {
                application = a;
                break;
            }
        }
        return application;
    }
}
