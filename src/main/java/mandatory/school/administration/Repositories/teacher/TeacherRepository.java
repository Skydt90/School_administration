package mandatory.school.administration.Repositories.teacher;

import mandatory.school.administration.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>, TeacherRepositoryCustom
{
    List<Teacher> findAllByTeacherCourses_courseId(int courseId);
    Teacher findTeacherByUser_username(String username);
    List<Teacher> findAllByTeacherCourses_teacherId(int teacherId);
}

