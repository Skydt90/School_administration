package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Services.Application.ApplicationService;
import mandatory.school.administration.Services.course.CourseService;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Utilities.ApplicationUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ApplicationController
{
    @Autowired
    ApplicationService applicationService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @GetMapping("/application")
    public String applicationsOverview(Model model)
    {
        ArrayList<Application> list = new ArrayList<>(ApplicationUtilities.sortListAfterTimestamp(applicationService.getAllApplications()));
        for (Application a: list)
        {
            a.fillFullCourse(courseService);
        }
        model.addAttribute("applications", list);
        model.addAttribute("a", new Application());
        model.addAttribute("studentId", "");
        model.addAttribute("courseId", "");
        return "/Application/overview";
    }


    @GetMapping("/application/accept")
    public String acceptApplication(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId)
    {
        Student student = studentService.findStudentById(studentId);
        Course course = courseService.getFullCourseById(courseId);

        applicationService.acceptApplication(student, course, studentService, courseService);
        return "redirect:/application";
    }

    @GetMapping("/application/decline")
    public String declineStudent (@RequestParam int courseId, @RequestParam int studentId)
    {
        applicationService.removeSignup(studentService.findStudentById(studentId), courseId, studentService);
        return "redirect:/application";
    }

    @GetMapping("/student/signup")
    public String signup(@RequestParam int studentId, @RequestParam int courseId)
    {
        Course course = courseService.getFullCourseById(courseId);
        Student student = studentService.findStudentById(studentId);
        applicationService.createApplication(student, course, studentService, courseService);
        return "redirect:/student";
    }

    @GetMapping("/student/removeSignup")
    public String removeSignup(@RequestParam int studentId, @RequestParam int courseId)
    {
        Student student = studentService.findStudentById(studentId);

        applicationService.removeSignup(student, courseId, studentService);
        return "redirect:/student";
    }
}