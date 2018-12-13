package mandatory.school.administration.Services.teacher;

import mandatory.school.administration.Model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TeacherService
{
    Teacher createTeacher(Teacher teacher);

    Teacher getOne(int id);

    Teacher findTeacherByUsername(String username);

    void editTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    void deleteTeacherById(int id);

    List<Teacher> getAllTeachers();

    List<Teacher> getAllByCourseId(int courseId);

    long countTeachers();

    List<Teacher> getAllTeachersThatIsNotInCourse(int teacherId);
}
