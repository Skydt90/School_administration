package mandatory.school.administration.Repositories.teacher;

import mandatory.school.administration.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>, TeacherRepositoryCustom
{
}

