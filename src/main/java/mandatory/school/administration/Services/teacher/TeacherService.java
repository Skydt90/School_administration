package mandatory.school.administration.Services.teacher;

import mandatory.school.administration.Model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherService
{
    Teacher createTeacher(Teacher teacher);
}
