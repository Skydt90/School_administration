package mandatory.school.administration.Repositories.student;

import mandatory.school.administration.Model.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StudentRepositoryCustomImpl implements StudentRepositoryCustom
{
    private RestTemplate restTemplate = new RestTemplate();
    private String LINK = "http://18.185.40.91/student";

    @Override
    public Student[] getStudentLegacy()
    {
        ResponseEntity<Student[]> response = restTemplate.getForEntity(LINK, Student[].class);
        if (!response.getStatusCode().isError())
        {
            System.out.println(response.getStatusCode());
            return response.getBody();
        }
        return null;
    }

    @Override
    public Student postStudentLegacy(Student student)
    {
        String link = LINK + "/register";
        HttpEntity<Student> request = new HttpEntity<>(student);
        ResponseEntity<Student> response = restTemplate.postForEntity(LINK, request, Student.class);


        if (!response.getStatusCode().isError())
        {
            System.out.println(response.getStatusCode());
            return response.getBody();
        }
        return null;
    }
}
