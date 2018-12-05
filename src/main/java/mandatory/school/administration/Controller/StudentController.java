package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Model.Student;
import mandatory.school.administration.Model.StudentCourse;
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

    @GetMapping("")
    public String details(Model model)
    {
        Student student = studentService.findStudentById(1);
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllByStudentId(1));
        model.addAttribute("studentId", 1);
        model.addAttribute("courseId", 1);
        model.addAttribute("applications", student.getApplications());
        return "/Student/details";
    }

    @GetMapping("/applyForCourse")
    public String applyForCourse(Model model)
    {
        model.addAttribute("studentId", studentService.findStudentById(1));
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
        Application application = course.getApplicationByStudentIdAndCourseId(studentId, courseId);
        course.getApplications().remove(application);
        courseService.createCourse(course);
        return "redirect:/student";
    }

    @GetMapping("/removeStudent")
    public String removeStudent (@RequestParam int courseId, @RequestParam int studentId)
    {
        Course course = courseService.findCourseById(courseId);
        StudentCourse studentCourse = course.getStudentCourseByStudentIdAndCourseId(studentId, courseId);
        course.getStudentCourses().remove(studentCourse);
        courseService.editCourse(course);
        return "redirect:/student";
    }
}
