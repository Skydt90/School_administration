package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Services.Application.ApplicationService;
import mandatory.school.administration.Services.course.CourseService;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Utilities.CourseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseUtilities courseUtilities;
    @Autowired
    ApplicationService applicationService;

    @GetMapping()
    public String details(Model model, Principal principal)
    {
        Student student = studentService.findStudentByUsername(principal.getName());
        ArrayList<Application> applications = new ArrayList<>(student.getApplications());
        for (Application a: applications)
        {
            a.fillFullCourse(courseService);
        }

        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.convertToFullCourses(courseService.getAllCoursesStudentHasEnrolled(student.getId())));
        model.addAttribute("applications", applications);
        return "/Student/details";
    }

    @GetMapping("/applyForCourse")
    public String applyForCourse(Model model, @RequestParam int studentId)
    {
        Student student = studentService.findStudentById(studentId);

        model.addAttribute("studentId", student.getId());
        model.addAttribute("courses", courseUtilities.getCoursesStudentHaveNotSignedUpFor(
                courseService.getAllCourses(),
                courseService.getAllCoursesStudentHasApplied(studentId),
                courseService.getAllCoursesStudentHasEnrolled(studentId)));
        return "/Student/applyForCourse";
    }

    @GetMapping("/signup")
    public String signup(@RequestParam int studentId, @RequestParam int courseId)
    {
        Course course = courseService.getFullCourseById(courseId);
        Student student = studentService.findStudentById(studentId);
        applicationService.createApplication(student, course, studentService, courseService);
        return "redirect:/student";
    }

    @GetMapping("/removeSignup")
    public String removeSignup(@RequestParam int studentId, @RequestParam int courseId)
    {
        Student student = studentService.findStudentById(studentId);

        applicationService.removeSignup(student, courseId, studentService);
        return "redirect:/student";
    }

    @GetMapping("/removeStudent")
    public String removeStudent (@RequestParam int courseId, @RequestParam int studentId)
    {
        courseService.removeStudentFromCourse(studentId, courseId);
        return "redirect:/student";
    }
}
