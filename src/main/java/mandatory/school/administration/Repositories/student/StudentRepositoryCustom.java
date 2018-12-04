package mandatory.school.administration.Repositories.student;

import mandatory.school.administration.Model.Student;

public interface StudentRepositoryCustom
{
    Student[] getStudentLegacy();
    Student postStudentLegacy(Student student);
}
