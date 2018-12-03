package mandatory.school.administration.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application
{
    @EmbeddedId
    private ApplicationId applicationId;

    @NotNull(message = "is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timestamp;

    @MapsId("student_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Student student;

    @MapsId("course_id")
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Course course;

    public Application() {}

    public Application(ApplicationId applicationId, @NotNull(message = "is required") Date timestamp)
    {
        this.applicationId = applicationId;
        this.timestamp = timestamp;
    }

    public ApplicationId getApplicationId()
    {
        return applicationId;
    }

    public void setApplicationId(ApplicationId applicationId)
    {
        this.applicationId = applicationId;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
}
