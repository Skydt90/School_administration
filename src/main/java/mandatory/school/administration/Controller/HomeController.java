package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.UserType;
import mandatory.school.administration.Services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController
{
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String emptyHome(){return "/home";}

    @GetMapping("/home")
    public String home()
    {
        return "/home";
    }

    @GetMapping("/fail")
    public String fail()
    {
        return "/fail";
    }

    @GetMapping("/login")
    public String login()
    {
        return "/login";
    }

    @GetMapping("/error")
    public String error()
    {
        return "/fail";
    }
}