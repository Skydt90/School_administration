package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Services.Application.ApplicationService;
import mandatory.school.administration.Services.course.CourseService;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Utilities.ApplicationUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/application")
public class ApplicationController
{
    @Autowired
    ApplicationService applicationService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @GetMapping()
    public String applicationsOverview(Model model)
    {
        ArrayList<Application> list = new ArrayList<>(ApplicationUtilities.sortListAfterTimestamp(applicationService.getAllApplications()));
        for (Application a: list)
        {
            a.fillFullCourse(courseService);
        }
        model.addAttribute("applications", list);
        return "/Application/overview";
    }

    @GetMapping("/details")
    public String applicationDetails(@RequestParam("studentId") int studentId, @RequestParam int courseId, Model model)
    {
        model.addAttribute("a", applicationService.getApplicationByStudentIdAndCourseId(studentId, courseId));
        return "/Application/details";
    }

    @GetMapping("/accept")
    public String acceptApplication(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId)
    {
        Student student = studentService.findStudentById(studentId);
        Course course = courseService.getFullCourseById(courseId);

        applicationService.acceptApplication(student, course, studentService, courseService);
        return "redirect:/application";
    }

    @GetMapping("/decline")
    public String declineStudent (@RequestParam int courseId, @RequestParam int studentId)
    {
        applicationService.removeSignup(studentService.findStudentById(studentId), courseId, studentService);
        return "redirect:/application";
    }
}