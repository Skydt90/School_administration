package mandatory.school.administration.Services.student;

import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Repositories.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository repository;

    @Override
    public Student createStudent(Student student)
    {
        return repository.save(student);
    }

    @Override
    public Student findStudentById(int id)
    {
        return repository.findById(id).get();
    }

    @Override
    public void editStudent(Student student)
    {
        repository.save(student);
    }

    @Override
    public void deleteStudent(Student student)
    {
        repository.delete(student);
    }

    @Override
    public void deleteStudentById(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents()
    {
        return repository.findAll();
    }

    @Override
    public long countStudents()
    {
        return repository.count();
    }
}
