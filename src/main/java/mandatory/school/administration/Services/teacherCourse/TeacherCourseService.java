package mandatory.school.administration.Services.teacherCourse;

import mandatory.school.administration.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface TeacherCourseService
{
    void add(Set<Teacher> teachers, int courseId);
    void remove(Set<Teacher> teachers, int courseId);
}
