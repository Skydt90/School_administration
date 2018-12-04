package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mandatory.school.administration.Services.course.CourseService;

import java.util.Date;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String details(Model model, @RequestParam int id)
    {
        Course course = courseService.findCourseById(id);
        model.addAttribute("student", studentService.findStudentById(id));
        model.addAttribute("students", courseService.getAllByStudentId(id));
        return "/student/details";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam int studentId, @RequestParam int courseId)
    {
        Course course = courseService.findCourseById(courseId);
        Student student = studentService.findStudentById(studentId);

        Application application = new Application();
        application.setStudent(student);
        application.setCourse(course);
        application.setTimestamp(new Date());

        course.getApplications().add(application);

        return "redirect:/course";
    }

    @DeleteMapping("/removeSignup")
    public String removeSignup(@RequestParam int studentId, int courseId)
    {
        Course course = courseService.findCourseById(courseId);
        Application application = course.getApplicationByStudentIdAndCourseId(studentId, courseId);
        course.getApplications().remove(application);
        return "redirect:/course";
    }
}
