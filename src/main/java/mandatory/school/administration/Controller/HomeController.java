package mandatory.school.administration.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping("/home")
    public String home()
    {
        return "home";
    }

    @GetMapping("/fail")
    public String fail()
    {
        return "fail";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}