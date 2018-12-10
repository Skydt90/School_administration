package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.*;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Services.teacher.TeacherService;
import mandatory.school.administration.Utilities.CourseUtilities;
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
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseUtilities courseUtilities;


    @GetMapping()
    public String overview(Model model)
    {
        courseService.updateCourses();
        List<Course> courses = courseService.getFullCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("count", courses.size());

        return "/course/overview";
    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam int id)
    {
        model.addAttribute("course", courseService.getFullCourseById(id));
        model.addAttribute("students", studentService.getAllByCourseId(id));
        model.addAttribute("teachers", teacherService.getAllByCourseId(id));
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
        courseService.updateCourses();
        int id = courseService.createCourseLegacy(course).getId();
        course.getLocalCourse().setId(id);
        courseService.createLocalCourse(course.getLocalCourse());
        //return "redirect:/course/details?id=" + id;
        return "redirect:/course";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam int courseId)
    {
        model.addAttribute("course", courseService.getFullCourseById(courseId));
        return "/course/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Course course, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "/course/details?id=" + course.getId();
        }
        courseService.editCourse(course.getLocalCourse());
        System.out.println("Course Id: " + course.getId() + " Local Id: " + course.getLocalCourse().getId());
        courseService.createCourseLegacy(course);
        System.out.println("Course Id: " + course.getId() + " Local Id: " + course.getLocalCourse().getId());

        return "redirect:/course/details?id=" + course.getId();
    }

    @GetMapping("/removeStudent")
    public String removeStudent (@RequestParam int courseId, @RequestParam int studentId)
    {
        LocalCourse course = courseService.findCourseById(courseId);
        StudentCourse studentCourse = courseUtilities.getStudentCourseByStudentIdAndCourseId(studentId, courseId, course.getStudentCourses());
        course.getStudentCourses().remove(studentCourse);
        courseService.editCourse(course);
        return "redirect:/course/details?id=" + courseId;
    }

    @GetMapping("/removeTeacher")
    public String removeTeacher (@RequestParam int courseId, @RequestParam int teacherId, Model model)
    {
        LocalCourse course = courseService.findCourseById(courseId);
        TeacherCourse teacherCourse = courseUtilities.getTeacherCourseByTeacherIdAndCourseId(teacherId, courseId, course.getTeacherCourses());
        course.getTeacherCourses().remove(teacherCourse);
        courseService.editCourse(course);
        return "redirect:/course/details?id=" + courseId;
    }
}
