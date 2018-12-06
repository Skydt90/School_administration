package mandatory.school.administration.Services.course;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Repositories.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return repository.getOne(id);
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
    @Scheduled(fixedRate = 120 * 1000)
    public void getAllCoursesLegacy()
    {
        ArrayList<Course> legacyCourses = new ArrayList<>(Arrays.asList(repository.getCoursesLegacy()));
        ArrayList<Course> localCourses = new ArrayList<>(repository.findAll());
        ArrayList<Course> missingCourses = new ArrayList<>();

        Map<String, String> names = new HashMap<>();
        for (Course c: localCourses)
        {
            names.put(c.getNameDanish(), c.getNameEnglish() + c.getLanguage());
        }

        for (Course legacy : legacyCourses)
        {
            if(!names.containsKey(legacy.getNameDanish()) || !names.containsValue(legacy.getNameEnglish() + legacy.getLanguage()))
            {
                missingCourses.add(legacy);
            }
        }

        System.out.println(missingCourses);

        if (!missingCourses.isEmpty())
        {
            saveAll(missingCourses);
        }
    }

    @Override
    public void saveAll(List<Course> courses)
    {
        repository.saveAll(courses);
    }

    @Override
    public List<Course> getAllByStudentId(int studentId)
    {
        return repository.findAllByStudentCourses_studentId(studentId);
    }

    @Override
    public long countCourses()
    {
        return repository.count();
    }
}
