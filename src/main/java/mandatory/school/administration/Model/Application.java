package mandatory.school.administration.Model;

import mandatory.school.administration.Services.course.CourseService;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application implements Serializable, Comparable<Application>
{
    private Student student;
    private LocalCourse course;
    private Date timestamp;
    private Course fullCourse;

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
    public LocalCourse getCourse()
    {
        return course;
    }
    public void setCourse(LocalCourse course)
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

    @Transient
    public Course getFullCourse()
    {
        return fullCourse;
    }
    public void setFullCourse(Course fullCourse)
    {
        this.fullCourse = fullCourse;
    }

    public void fillFullCourse(CourseService courseService)
    {
        ArrayList<LocalCourse> list = new ArrayList<>();
        list.add(this.course);
        this.setFullCourse(courseService.convertToFullCourses(list).get(0));
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
