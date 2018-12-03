package mandatory.school.administration.Services.teacher;

import mandatory.school.administration.Model.Teacher;
import mandatory.school.administration.Repositories.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
