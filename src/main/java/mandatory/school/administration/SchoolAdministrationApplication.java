package mandatory.school.administration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchoolAdministrationApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SchoolAdministrationApplication.class, args);
    }
}

