package mandatory.school.administration.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_course")
public class StudentCourse implements Serializable
{
    private Student student;
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    @Override
    public String toString()
    {
        return "StudentCourse{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }
}
