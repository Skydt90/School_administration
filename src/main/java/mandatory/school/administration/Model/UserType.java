package mandatory.school.administration.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usertypes")
public class UserType
{
    private String userType;

    private Set<User> users;

    public UserType()
    {}

    public UserType(String userType)
    {
        this.userType = userType;
    }

    @Id
    @Column(name = "user_type")
    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<User> getUsers()
    {
        return users;
    }

    public void setUsers(Set<User> users)
    {
        this.users = users;
    }

    @Override
    public String toString()
    {
        return "UserType{" +
                "userType='" + userType + '\'' +
                '}';
    }
}
