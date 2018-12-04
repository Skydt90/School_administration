package mandatory.school.administration.Repositories.student;

import mandatory.school.administration.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustom
{
    Set<Student> findAllByStudentCourses_courseId(int courseId);
}
