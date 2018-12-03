package mandatory.school.administration.Services.application;

import mandatory.school.administration.Model.Application;

import java.util.List;
import java.util.Set;

public interface ApplicationService
{
    Application createApplication(Application application);

    Set<Application> findApplicationsByStudentId(int studentId);

    Set<Application> findApplicationsByCourseId(int courseId);

    void deleteApplication(Application application);

    void deleteApplicationByStudentIdAndCourseId(int studentId, int courseId);

    List<Application> getAllApplications();

    long countApplication();
}
