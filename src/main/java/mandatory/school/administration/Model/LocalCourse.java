package mandatory.school.administration.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class LocalCourse
{
    private int id;
    private int minimumStudents;
    private int expectedStudents;
    private int maximumStudents;
    private String prerequisites;
    private String learningOutcome;
    private String content;
    private String learningActivities;
    private String examForm;

    private Set<TeacherCourse> teacherCourses;
    private Set<StudentCourse> studentCourses;
    private Set<Application> applications;

    public LocalCourse(){}

    public LocalCourse(int id)
    {
        this.id = id;
    }

    public LocalCourse(int id, int minimumStudents, int expectedStudents, int maximumStudents, String prerequisites, String learningOutcome, String content, String learningActivities, String examForm)
    {
        this.id = id;
        this.minimumStudents = minimumStudents;
        this.expectedStudents = expectedStudents;
        this.maximumStudents = maximumStudents;
        this.prerequisites = prerequisites;
        this.learningOutcome = learningOutcome;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
    }

    @Id
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        teacherCourses = new HashSet<>();
        studentCourses = new HashSet<>();
        applications = new HashSet<>();
        this.id = id;
    }

    @Max(value  = 50, message = "cannot exceed 50 students")
    @Column(name = "minimum_students")
    public int getMinimumStudents()
    {
        return minimumStudents;
    }
    public void setMinimumStudents(int minimumStudents)
    {
        this.minimumStudents = minimumStudents;
    }

    @Max(value  = 50, message = "cannot exceed 50 students")
    @Column(name = "expected_students")
    public int getExpectedStudents()
    {
        return expectedStudents;
    }
    public void setExpectedStudents(int expectedStudents)
    {
        this.expectedStudents = expectedStudents;
    }

    @Max(value  = 50, message = "cannot exceed 50 students")
    @Column(name = "maximum_students")
    public int getMaximumStudents()
    {
        return maximumStudents;
    }
    public void setMaximumStudents(int maximumStudents)
    {
        this.maximumStudents = maximumStudents;
    }

    @Column(name = "prerequisites")
    public String getPrerequisites()
    {
        return prerequisites;
    }
    public void setPrerequisites(String prerequisites)
    {
        this.prerequisites = prerequisites;
    }

    @Column(name = "learning_outcome")
    public String getLearningOutcome()
    {
        return learningOutcome;
    }
    public void setLearningOutcome(String learningOutcome)
    {
        this.learningOutcome = learningOutcome;
    }

    @Column(name = "content")
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    @Column(name = "learning_activities")
    public String getLearningActivities()
    {
        return learningActivities;
    }
    public void setLearningActivities(String learningActivities)
    {
        this.learningActivities = learningActivities;
    }

    @Column(name = "exam_form")
    public String getExamForm()
    {
        return examForm;
    }
    public void setExamForm(String examForm)
    {
        this.examForm = examForm;
    }

    @OneToMany(mappedBy = "course")
    public Set<TeacherCourse> getTeacherCourses()
    {
        return teacherCourses;
    }
    public void setTeacherCourses(Set<TeacherCourse> teacherCourses)
    {
        this.teacherCourses = teacherCourses;
    }

    @OneToMany(mappedBy = "course")
    public Set<StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }
    public void setStudentCourses(Set<StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
    }

    @OneToMany(mappedBy = "course")
    public Set<Application> getApplications()
    {
        return applications;
    }
    public void setApplications(Set<Application> applications)
    {
        this.applications = applications;
    }
}
