package mandatory.school.administration.Services.studentCourse;

import mandatory.school.administration.Repositories.student.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseServiceImpl implements StudentCourseService
{
    @Autowired
    StudentCourseRepository repository;

    @Override
    public void add(int studentId, int courseId)
    {
        repository.add(studentId, courseId);
    }

    @Override
    public void remove(int studentId, int courseId)
    {
        repository.remove(studentId, courseId);
    }
}
