package mandatory.school.administration.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User
{
    private String username;
    private String password;

    private UserType userType;
    private Set<Student> students;
    private Set<Teacher> teachers;

    public User(){}

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    @Id
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[a-zA-ZæÆøØåÅ0-9]+$", message = "Only characters and digits allowed")
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @NotNull
    @Size(min = 6, max = 60)
    @Column(name = "password")
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "userType")
    public UserType getUserType()
    {
        return userType;
    }
    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Student> getStudents()
    {
        return students;
    }
    public void setStudents(Set<Student> students)
    {
        this.students = students;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Teacher> getTeachers()
    {
        return teachers;
    }
    public void setTeachers(Set<Teacher> teachers)
    {
        this.teachers = teachers;
    }

    @Override
    public String toString()
    {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
