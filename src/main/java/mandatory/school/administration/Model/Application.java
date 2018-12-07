package mandatory.school.administration.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application implements Serializable, Comparable<Application>
{
    private Student student;
    private Course course;
    private Date timestamp;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent()
    {
        return student;
    }
    public void setStudent(Student student)
    {
        this.student = student;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse()
    {
        return course;
    }
    public void setCourse(Course course)
    {
        this.course = course;
    }

    @NotNull(message = "is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getTimestamp()
    {
        return timestamp;
    }
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString()
    {
        return "Application{" +
                "studentId=" + student.getId() +
                ", courseId=" + course.getId() +
                ", timestamp=" + timestamp +

                '}';
    }

    @Override
    public int compareTo(Application a)
    {
        return this.getTimestamp().compareTo(a.getTimestamp());
    }
}
