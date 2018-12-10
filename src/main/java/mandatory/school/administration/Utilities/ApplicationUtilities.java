package mandatory.school.administration.Utilities;

import mandatory.school.administration.Model.Application;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ApplicationUtilities
{
    public static Application getApplicationByStudentIdAndCourseId(int studentId, int courseid, List<Application> applications)
    {
        Application application = null;
        for (Application a: applications)
        {
            if (a.getStudent().getId() == studentId && a.getCourse().getId() == courseid)
            {
                application = a;
            }
        }
        return application;
    }

    public static List<Application> sortListAfterTimestamp(List<Application> applications)
    {
        Collections.sort(applications);
        return applications;
    }
}
