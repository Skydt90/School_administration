package mandatory.school.administration.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher_course")
public class TeacherCourse implements Serializable
{
    private Teacher teacher;
    private LocalCourse course;

    @Id
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    public LocalCourse getCourse() {
        return course;
    }
    public void setCourse(LocalCourse course)
    {
        this.course = course;
    }

    @Override
    public String toString()
    {
        return "TeacherCourse{" +
                "teacher=" + teacher +
                ", course=" + course +
                '}';
    }
}