package mandatory.school.administration.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teachers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "is required")
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed")
    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Email
    @NotNull(message = "is required")
    @Size(min = 3, max = 20)
    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "is required")
    @Size(min = 3, max = 20)
    @Column(name = "username")
    private String username;

    public Teacher(){}

    public Teacher(@NotNull(message = "is required") @Size(min = 2, max = 50) @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed") String name, @Email @NotNull(message = "is required") @Size(min = 3, max = 20) String email, @NotNull(message = "is required") @Size(min = 3, max = 20) String username)
    {
        this.name = name;
        this.email = email;
        this.username = username;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
