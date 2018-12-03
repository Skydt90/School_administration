package mandatory.school.administration.Repositories.teacher;

import mandatory.school.administration.Model.Teacher;

public interface TeacherRepositoryCustom
{
    Teacher[] getTeachersLegacy();

    Teacher postTeacherLegacy(Teacher teacher);
}
