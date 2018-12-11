package mandatory.school.administration.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "students")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student
{
    private int id;
    private String name;
    private User user;
    private Set<StudentCourse> studentCourses;
    private Set<Application> applications;

    public Student(){}

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @NotNull(message = "is required")
    @Size(min = 2, max = 25)
    @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed")
    @Column(name = "name")
    @JsonProperty("name")
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "username")
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }
    public void setStudentCourses(Set<StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Application> getApplications()
    {
        return applications;
    }
    public void setApplications(Set<Application> applications)
    {
        this.applications = applications;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
