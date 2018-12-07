package mandatory.school.administration.Services.student;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Repositories.course.CourseRepository;
import mandatory.school.administration.Repositories.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student createStudent(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(int id)
    {
        return studentRepository.getOne(id);
    }

    @Override
    public Student findStudentByUsername(String username)
    {
        return studentRepository.findStudentByUser_username(username);
    }

    @Override
    public void editStudent(Student student)
    {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student)
    {
        studentRepository.delete(student);
    }

    @Override
    public void deleteStudentById(int id)
    {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllByCourseId(int courseId)
    {
        return studentRepository.findAllByStudentCourses_courseId(courseId);
    }

    @Override
    public long countStudents()
    {
        return studentRepository.count();
    }
}
