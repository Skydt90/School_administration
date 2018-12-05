package mandatory.school.administration.Repositories.course;

import mandatory.school.administration.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>, CourseRepositoryCustom
{
    List<Course> findAllByStudentCourses_studentId(int studentId);
}
