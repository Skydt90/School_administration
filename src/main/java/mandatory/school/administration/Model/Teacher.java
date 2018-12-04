package mandatory.school.administration.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "teachers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher
{
    private int id;
    private String name;

    private User user;
    private Set<TeacherCourse> teacherCourses;

    public Teacher(){}

    public Teacher(int id, String name)
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
    @Size(min = 2, max = 50)
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


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<TeacherCourse> getTeacherCourses()
    {
        return teacherCourses;
    }
    public void setTeacherCourses(Set<TeacherCourse> teacherCourses)
    {
        this.teacherCourses = teacherCourses;
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
