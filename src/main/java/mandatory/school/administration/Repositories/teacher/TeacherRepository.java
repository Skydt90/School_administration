package mandatory.school.administration.Repositories.teacher;

import mandatory.school.administration.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>, TeacherRepositoryCustom
{
    Set<Teacher> findAllByTeacherCourses_courseId(int courseId);
}

