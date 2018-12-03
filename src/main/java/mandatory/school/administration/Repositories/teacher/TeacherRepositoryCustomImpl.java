package mandatory.school.administration.Repositories.teacher;

import mandatory.school.administration.Model.Teacher;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class TeacherRepositoryCustomImpl implements TeacherRepositoryCustom
{
    private RestTemplate restTemplate = new RestTemplate();
    private final String LINK = "http://18.185.40.91/teacher";

    @Override
    public Teacher[] getTeachersLegacy()
    {
        ResponseEntity<Teacher[]> response = restTemplate.getForEntity(LINK,Teacher[].class);
        if(!response.getStatusCode().isError())
        {
            System.out.println(response.getStatusCode());
            return response.getBody();
        }
        return null;
    }

    @Override
    public Teacher postTeacherLegacy(Teacher teacher)
    {
        HttpEntity<Teacher> request = new HttpEntity<>(teacher);
        ResponseEntity<Teacher> response = restTemplate.postForEntity(LINK, request, Teacher.class);
        if(!response.getStatusCode().isError())
        {
            System.out.println(response.getStatusCode());
            return response.getBody();
        }
        return null;
    }
}

