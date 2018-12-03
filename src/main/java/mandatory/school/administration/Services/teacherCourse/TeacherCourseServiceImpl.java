package mandatory.school.administration.Services.teacherCourse;

import mandatory.school.administration.Model.Teacher;
import mandatory.school.administration.Repositories.teacher.TeacherCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService
{
    @Autowired
    TeacherCourseRepository repository;


    @Override
    public void add(Set<Teacher> teachers, int courseId)
    {
        repository.add(teachers, courseId);
    }

    @Override
    public void remove(Set<Teacher> teachers, int courseId)
    {
        repository.remove(teachers, courseId);
    }
}
