package mandatory.school.administration.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ApplicationId implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public ApplicationId(){};

    public ApplicationId(int studentId, int courseId){
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public int getCourseId()
    {
        return courseId;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }
}
