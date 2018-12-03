package mandatory.school.administration.Repositories.course;

import mandatory.school.administration.Model.Course;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CourseRepositoryCustomImpl implements CourseRepositoryCustom
{
    private RestTemplate restTemplate = new RestTemplate();
    private final String LINK = "http://18.185.40.91/course";


    @Override
    public Course[] getCoursesLegacy()
    {
        ResponseEntity<Course[]> response = restTemplate.getForEntity(LINK,Course[].class);
        if(!response.getStatusCode().isError())
        {
            System.out.println(response.getStatusCode());
            return response.getBody();
        }
        return null;
    }

    @Override
    public Course postCourseLegacy(Course course)
    {
        HttpEntity<Course> request = new HttpEntity<>(course);
        ResponseEntity<Course> response = restTemplate.postForEntity(LINK, request, Course.class);


        if(!response.getStatusCode().isError())
        {
            System.out.println(response.getStatusCode());
            return response.getBody();
        }
        return null;
    }
}
