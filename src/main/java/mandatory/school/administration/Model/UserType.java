package mandatory.school.administration.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usertypes")
public class UserType
{
    @Id
    @NotNull
    @Size(max = 13)
    @Column(name = "user_type")
    private String userType;

    public UserType()
    {}

    public UserType(@NotNull @Size(max = 13) String userType)
    {
        this.userType = userType;
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
        return "UserType{" +
                "userType='" + userType + '\'' +
                ", users=" +
                '}';
    }
}
