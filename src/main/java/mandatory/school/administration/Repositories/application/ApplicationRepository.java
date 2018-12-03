package mandatory.school.administration.Repositories.application;

import mandatory.school.administration.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

public interface ApplicationRepository extends JpaRepository<Application, Integer>
{
    Set<Application> findApplicationsByApplicationId_StudentId(int studentId);
    Set<Application> findApplicationsByApplicationId_CourseId(int courseId);
    void deleteApplicationByApplicationId_StudentIdAndApplicationId_CourseId(int studentId, int courseId);
}
