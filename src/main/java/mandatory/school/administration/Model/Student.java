package mandatory.school.administration.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "students")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "is required")
    @Size(min = 2, max = 25)
    @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed")
    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "is required")
    @Size(min = 3, max = 20)
    @Column(name = "username")
    @JsonProperty("username")
    private String username;

    @Email
    @Size(min = 3, max = 20)
    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "is required")
    @Size(min = 3, max = 20)
    @Column(name = "password")
    @JsonProperty("password")
    private String password;

    @Min(value = 0, message = "must be either 0 or 1")
    @Max(value = 1, message = "must be either 0 or 1")
    @Column(name = "enabled")
    @JsonProperty("enabled")
    private int enabled;

    public Student(){}

    public Student(@NotNull(message = "is required") @Size(min = 2, max = 25) @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed") String name, @NotNull(message = "is required") @Size(min = 3, max = 20) String username, @Email @NotNull(message = "is required") @Size(min = 3, max = 20) String email, @NotNull(message = "is required") @Size(min = 3, max = 20) String password, @Min(value = 0, message = "must be either 0 or 1") @Max(value = 1, message = "must be either 0 or 1") int enabled)
    {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
