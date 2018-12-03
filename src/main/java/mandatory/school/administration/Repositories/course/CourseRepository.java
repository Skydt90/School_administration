package mandatory.school.administration.Repositories.course;

import mandatory.school.administration.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>, CourseRepositoryCustom
{

}
