package mandatory.school.administration.Services.user;

import mandatory.school.administration.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component(value="userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User appUser = userService.findUserByUsername(username);
        if(appUser==null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        //Make a list of authorities
        List<GrantedAuthority> grantList = new ArrayList<>();

        //Input the usertype in the grant list
        GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getUserType().getUserType());
        grantList.add(authority);

        //Make the security user from the userdata
        return (UserDetails) new org.springframework.security.core.userdetails.User(appUser.getUsername(),
                appUser.getPassword(), grantList);

    }
}
