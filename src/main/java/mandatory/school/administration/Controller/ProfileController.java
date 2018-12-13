package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.*;
import mandatory.school.administration.Services.course.CourseService;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Services.teacher.TeacherService;
import mandatory.school.administration.Services.user.UserService;
import mandatory.school.administration.Utilities.CourseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController
{
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    CourseUtilities courseUtilities;

    @GetMapping("/profile")
    public String profile(Principal principal)
    {
        String userType = userService.findUserByUsername(principal.getName()).getUserType().getUserType();
        switch (userType)
        {
            case "student": return "redirect:/student";
            case "teacher" : return "redirect:/teacher";
            case "admin" : return "redirect:/admin";
            default: return "fail"; // or maybe login??
        }
    }

    @GetMapping("/admin")
    public String adminDetails(Model model, Principal principal)
    {
        User user = userService.findUserByUsername(principal.getName());
        System.out.println(user);
        model.addAttribute("user", user);
        return "/Admin/details";
    }

    @GetMapping("/teacher")
    public String teacherDetails(Model model, Principal principal)
    {
        Teacher teacher = teacherService.findTeacherByUsername(principal.getName());
        model.addAttribute("teacher", teacher);
        model.addAttribute("courses", courseService.convertToFullCourses(courseService.getAllCoursesTeacherAreTeaching(teacher.getId())));
        return "/Teacher/details";
    }

    @GetMapping("/student")
    public String details(Model model, Principal principal)
    {
        Student student = studentService.findStudentByUsername(principal.getName());
        ArrayList<Application> applications = new ArrayList<>(student.getApplications());
        for (Application a: applications)
        {
            a.fillFullCourse(courseService);
        }
        List<Course> enrolledCourses = courseService.convertToFullCourses(courseService.getAllCoursesStudentHasEnrolled(student.getId()));
        List<Course> newCourses = courseUtilities.getCoursesStudentHaveNotSignedUpFor(
                courseService.getAllCourses(),
                courseService.getAllCoursesStudentHasApplied(student.getId()),
                courseService.getAllCoursesStudentHasEnrolled(student.getId()));

        model.addAttribute("student", student);
        model.addAttribute("courses", enrolledCourses);
        model.addAttribute("applications", applications);
        model.addAttribute("newCourses", newCourses);
        model.addAttribute("countEnrolledCourses", enrolledCourses.size());
        model.addAttribute("countApplications", applications.size());
        model.addAttribute("countNewCourses", newCourses.size());
        return "/Student/details";
    }
}
