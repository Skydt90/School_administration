package mandatory.school.administration.Controller;

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

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    ApplicationService applicationService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @GetMapping("/applications")
    public String applicationsOverview(Model model)
    {
        model.addAttribute("applications", ApplicationUtilities.sortListAfterTimestamp(applicationService.getAllApplications()));
        return "/Admin/applications";
    }

    @GetMapping("/applicationsDetails")
    public String applicationDetails(@RequestParam("studentId") int studentId, @RequestParam int courseId, Model model)
    {
        model.addAttribute("a", applicationService.getApplicationByStudentIdAndCourseId(studentId, courseId));
        return "/Admin/applicationDetails";
    }


    @GetMapping("/acceptApplication")
    public String acceptApplication(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId)
    {
        Student student = studentService.findStudentById(studentId);
        Course course = courseService.getFullCourseById(courseId);

        applicationService.acceptApplication(student, course, studentService, courseService);
        return "redirect:applications";
    }
}
