package mandatory.school.administration.Repositories.Application;

import mandatory.school.administration.Model.Application;

import java.util.List;

public interface ApplicationRepository
{
    List<Application> findAllApplications();
    Application findApplicationByStudentIdAndCourseId(int studentId, int courseId);
}
