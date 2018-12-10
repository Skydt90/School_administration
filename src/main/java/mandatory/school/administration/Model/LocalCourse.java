package mandatory.school.administration.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @Min(value = 0)
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "minimum_students")
    public int getMinimumStudents()
    {
        return minimumStudents;
    }
    public void setMinimumStudents(int minimumStudents)
    {
        this.minimumStudents = minimumStudents;
    }

    @Min(value = 0)
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "expected_students")
    public int getExpectedStudents()
    {
        return expectedStudents;
    }
    public void setExpectedStudents(int expectedStudents)
    {
        this.expectedStudents = expectedStudents;
    }

    @Min(value = 0)
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "maximum_students")
    public int getMaximumStudents()
    {
        return maximumStudents;
    }
    public void setMaximumStudents(int maximumStudents)
    {
        this.maximumStudents = maximumStudents;
    }

    @Pattern(regexp = "[ ,.a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(min = 0, max = 200, message = "cannot exceed 200 characters")
    @Column(name = "prerequisites")
    public String getPrerequisites()
    {
        return prerequisites;
    }
    public void setPrerequisites(String prerequisites)
    {
        this.prerequisites = prerequisites;
    }

    @Pattern(regexp = "[ ,.a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "learning_outcome")
    public String getLearningOutcome()
    {
        return learningOutcome;
    }
    public void setLearningOutcome(String learningOutcome)
    {
        this.learningOutcome = learningOutcome;
    }

    @Pattern(regexp = "[ ,.a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "content")
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    @Pattern(regexp = "[ ,.a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "learning_activities")
    public String getLearningActivities()
    {
        return learningActivities;
    }
    public void setLearningActivities(String learningActivities)
    {
        this.learningActivities = learningActivities;
    }

    @Pattern(regexp = "[ ,.a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "exam_form")
    public String getExamForm()
    {
        return examForm;
    }
    public void setExamForm(String examForm)
    {
        this.examForm = examForm;
    }

    @OneToMany(mappedBy = "course" /*cascade = CascadeType.ALL, orphanRemoval = true*/)
    public Set<TeacherCourse> getTeacherCourses()
    {
        return teacherCourses;
    }
    public void setTeacherCourses(Set<TeacherCourse> teacherCourses)
    {
        this.teacherCourses = teacherCourses;
    }

    @OneToMany(mappedBy = "course" /*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    public Set<StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }
    public void setStudentCourses(Set<StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
    }

    @OneToMany(mappedBy = "course"/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    public Set<Application> getApplications()
    {
        return applications;
    }
    public void setApplications(Set<Application> applications)
    {
        this.applications = applications;
    }
}
