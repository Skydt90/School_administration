package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Repositories.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository repository;


    @Override
    public Course createCourse(Course course)
    {
        return repository.save(course);
    }

    @Override
    public Course createCourseLegacy(Course course)
    {
        return repository.postCourseLegacy(course);
    }

    @Override
    public Course findCourseById(int id)
    {
        return repository.findById(id).get();
    }

    @Override
    public void editCourse(Course course)
    {
        repository.save(course);
    }

    @Override
    public void deleteCourse(Course course)
    {
        repository.delete(course);
    }

    @Override
    public void deleteCourseById(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourses()
    {
        return repository.findAll();
    }

    @Override
    public List<Course> getAllCoursesLegacy()
    {
        return new ArrayList<>(Arrays.asList(repository.getCoursesLegacy()));
    }

    @Override
    public long countCourses()
    {
        return repository.count();
    }
}
