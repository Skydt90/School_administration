package mandatory.school.administration.Repositories.teacher;

import mandatory.school.administration.Model.Teacher;

import java.util.Set;

public interface TeacherCourseRepository
{
    void add(Set<Teacher> teachers, int courseId);
    void remove(Set<Teacher> teachers, int courseId);
}
