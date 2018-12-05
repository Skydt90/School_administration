package mandatory.school.administration.Services.student;

import mandatory.school.administration.Model.Student;

import java.util.List;
import java.util.Set;

public interface StudentService
{
    Student createStudent(Student student);

    Student findStudentById(int id);

    void editStudent(Student student);

    void deleteStudent(Student student);

    void deleteStudentById(int id);

    List<Student> getAllStudents();

    List<Student> getAllByCourseId(int courseId);

    long countStudents();
}
