package mandatory.school.administration.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[a-zA-ZæÆøØåÅ0-9]+$", message = "Only characters and digits allowed")
    private String username;

    @NotNull
    @Size(min = 6, max = 20)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    private String userType;

    public User(){}

    public User(@Size(min = 2, max = 20)
                @Pattern(regexp = "[a-zA-ZæÆøØåÅ0-9]+$", message = "Only characters and digits allowed") String username,
                @NotNull @Size(min = 6, max = 20) String password, @NotNull @Size(min = 3, max = 20) String userType)
    {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
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
