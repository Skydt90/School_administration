package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.Course;
import mandatory.school.administration.Services.teacherCourse.TeacherCourseService;
import mandatory.school.administration.Services.studentCourse.StudentCourseService;
import mandatory.school.administration.Services.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mandatory.school.administration.Services.course.CourseService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController
{
    @Autowired
    CourseService courseService;
    @Autowired
    StudentCourseService studentCourseService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherCourseService teacherCourseService;

    @GetMapping()
    public String overview(Model model)
    {
        List<Course> courses = courseService.getAllCoursesLegacy();
        model.addAttribute("courses", courses);
        model.addAttribute("count", courses.size());
        return "/course/overview";
    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam int id)
    {
        model.addAttribute("course", courseService.findCourseById(id));
        return "/course/details";
    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("course", new Course());
        return "/course/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Course course, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "/course/create";
        }
        courseService.createCourseLegacy(course);
        courseService.createCourse(course);
        return "redirect:/course";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam int studentId, @RequestParam int courseId)
    {
        studentCourseService.add(studentId, courseId);
        return "redirect:/course";
    }

    @DeleteMapping("/removeSignup")
    public String removeSignup(@RequestParam int studentId, int courseId)
    {
        studentCourseService.remove(studentId, courseId);
        return "redirect:/course";
    }
}
