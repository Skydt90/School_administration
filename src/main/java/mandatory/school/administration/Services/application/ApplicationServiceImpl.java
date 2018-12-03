package mandatory.school.administration.Services.application;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Repositories.application.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService
{
    @Autowired
    ApplicationRepository repository;

    @Override
    public Application createApplication(Application application)
    {
        return repository.save(application);
    }

    @Override
    public Set<Application> findApplicationsByStudentId(int studentId)
    {
        return new HashSet<Application>(repository.findApplicationsByApplicationId_StudentId(studentId));
    }

    @Override
    public Set<Application> findApplicationsByCourseId(int courseId)
    {
        return new HashSet<Application>(repository.findApplicationsByApplicationId_CourseId(courseId));
    }

    @Override
    public void deleteApplication(Application application)
    {
        repository.delete(application);
    }

    @Override
    public void deleteApplicationByStudentIdAndCourseId(int studentId, int courseId)
    {
        repository.deleteApplicationByApplicationId_StudentIdAndApplicationId_CourseId(studentId, courseId);
    }

    @Override
    public List<Application> getAllApplications()
    {
        return repository.findAll();
    }

    @Override
    public long countApplication()
    {
        return repository.count();
    }
}
