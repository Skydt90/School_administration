package mandatory.school.administration.Services.teacher;

import mandatory.school.administration.Model.Teacher;
import mandatory.school.administration.Repositories.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    TeacherRepository repository;

    @Override
    public Teacher createTeacher(Teacher teacher)
    {
        return repository.save(teacher);
    }

    @Override
    public Teacher getOne(int id)
    {
        return repository.getOne(id);
    }

    @Override
    public Teacher findTeacherByUsername(String username)
    {
        return repository.findTeacherByUser_username(username);
    }

    @Override
    public void editTeacher(Teacher teacher)
    {
        repository.save(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher)
    {
        repository.delete(teacher);
    }

    @Override
    public void deleteTeacherById(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public List<Teacher> getAllTeachers()
    {
        return repository.findAll();
    }

    @Override
    public List<Teacher> getAllByCourseId(int courseId)
    {
        return repository.findAllByTeacherCourses_courseId(courseId);
    }

    @Override
    public long countTeachers()
    {
        return repository.count();
    }

    @Override
    public List<Teacher> getAllTeachersThatIsNotInCourse(int teacherId)
    {
        return repository.findAllByTeacherCourses_teacherId(teacherId);
    }
}
