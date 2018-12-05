package mandatory.school.administration.Repositories.student;

import mandatory.school.administration.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustom
{
    List<Student> findAllByStudentCourses_courseId(int courseId);
}
