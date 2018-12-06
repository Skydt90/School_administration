package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Model.StudentCourse;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Utilities.CourseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mandatory.school.administration.Services.course.CourseService;

import java.security.Principal;
import java.util.Date;

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

    @GetMapping("")
    public String details(Model model, Principal principal)
    {
        Student student = studentService.findStudentByUsername(principal.getName());
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllByStudentId(student.getId()));
        model.addAttribute("applications", student.getApplications());
        return "/Student/details";
    }

    @GetMapping("/applyForCourse")
    public String applyForCourse(Model model, @RequestParam int studentId)
    {
        model.addAttribute("studentId", studentService.findStudentById(studentId));
        model.addAttribute("courses", courseService.getAllCourses());
        return "/Student/applyForCourse";
    }

    @GetMapping("/signup")
    public String signup(@RequestParam int studentId, @RequestParam int courseId)
    {
        Course course = courseService.findCourseById(courseId);
        Student student = studentService.findStudentById(studentId);

        Application application = new Application();
        application.setStudent(student);
        application.setCourse(course);
        application.setTimestamp(new Date());
        course.getApplications().add(application);
        studentService.createStudent(student);
        courseService.createCourse(course);
        return "redirect:/student";
    }

    @GetMapping("/removeSignup")
    public String removeSignup(@RequestParam int studentId, int courseId)
    {
        Course course = courseService.findCourseById(courseId);
        Application application = courseUtilities.getApplicationByStudentIdAndCourseId(studentId, courseId, course.getApplications());
        course.getApplications().remove(application);
        courseService.createCourse(course);
        return "redirect:/student";
    }

    @GetMapping("/removeStudent")
    public String removeStudent (@RequestParam int courseId, @RequestParam int studentId)
    {
        Course course = courseService.findCourseById(courseId);
        StudentCourse studentCourse = courseUtilities.getStudentCourseByStudentIdAndCourseId(studentId, courseId, course.getStudentCourses());
        course.getStudentCourses().remove(studentCourse);
        courseService.editCourse(course);
        return "redirect:/student";
    }
}
