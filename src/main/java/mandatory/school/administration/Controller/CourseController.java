package mandatory.school.administration.Controller;

import mandatory.school.administration.Model.*;
import mandatory.school.administration.Services.student.StudentService;
import mandatory.school.administration.Services.teacher.TeacherService;
import mandatory.school.administration.Utilities.CourseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        boolean visible = courseService.getIsShowAbleBasedOnAuthority();
        courseService.updateCourses();
        List<Course> courses = courseService.getFullCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("count", courses.size());
        model.addAttribute("course", new Course());
        model.addAttribute("showable", visible);
        return "/course/overview";
    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam int id)
    {
        courseService.updateCourses();
        model.addAttribute("course", courseService.getFullCourseById(id));
        model.addAttribute("students", studentService.getAllByCourseId(id));
        model.addAttribute("teachers", teacherService.getAllByCourseId(id));
        return "/course/details";
    }

    @ResponseBody
    @GetMapping("/ajaxdetails")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> getCourseAjax(@RequestParam int id)
    {
        Course response = courseService.getFullCourseById(id);

        String json =
                "{" +
                    "\n\t\"nameDanish\" :\"" + response.getNameDanish() + "\"," +
                    "\n\t\"nameEnglish\" :\"" + response.getNameEnglish() + "\"," +
                    "\n\t\"semester\" :\"" + response.getSemester() + "\"," +
                    "\n\t\"numberOfTeachers\" :\"" + response.getNumberOfTeachers() + "\"," +
                    "\n\t\"description\" :\"" + response.getDescription() + "\"," +
                    "\n\t\"studyProgramme\" :\"" + response.getStudyProgramme() + "\"," +
                    "\n\t\"mandatory\" :\"" + response.getMandatory() + "\"," +
                    "\n\t\"ects\" :\"" + response.getECTS() + "\"," +
                    "\n\t\"language\" :\"" + response.getLanguage() + "\"," +
                    "\n\t\"minimumStudents\" :\"" + response.getLocalCourse().getMinimumStudents() + "\"," +
                    "\n\t\"expectedStudents\" :\"" + response.getLocalCourse().getExpectedStudents() + "\"," +
                    "\n\t\"maximumStudents\" :\"" + response.getLocalCourse().getMaximumStudents() + "\"," +
                    "\n\t\"prerequisites\" :\"" + response.getLocalCourse().getPrerequisites() + "\"," +
                    "\n\t\"learningOutcome\" :\"" + response.getLocalCourse().getLearningOutcome() + "\"," +
                    "\n\t\"content\" :\"" + response.getDescription() + "\"," +
                    "\n\t\"learningActivities\" :\"" + response.getLocalCourse().getLearningActivities() + "\"," +
                    "\n\t\"examForm\" :\"" + response.getLocalCourse().getExamForm() + "\"" +
                    "\n}";

        return new ResponseEntity<>(json, HttpStatus.OK);
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
        return "redirect:/course/details?id=" + id;
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
        courseService.createCourseLegacy(course);
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
