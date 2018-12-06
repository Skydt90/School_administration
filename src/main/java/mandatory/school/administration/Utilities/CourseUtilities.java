package mandatory.school.administration.Utilities;

import mandatory.school.administration.Model.Application;
import mandatory.school.administration.Model.StudentCourse;
import mandatory.school.administration.Model.TeacherCourse;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CourseUtilities
{
    public TeacherCourse getTeacherCourseByTeacherIdAndCourseId(int teacherId, int courseId, Set<TeacherCourse> teacherCourses)
    {
        TeacherCourse teacherCourse = null;
        for (TeacherCourse tc: teacherCourses)
        {
            if (tc.getTeacher().getId() == teacherId && tc.getCourse().getId() == courseId)
            {
                teacherCourse = tc;
                break;
            }
        }
        return teacherCourse;
    }

    public StudentCourse getStudentCourseByStudentIdAndCourseId(int studentId, int courseId, Set<StudentCourse> studentCourses)
    {
        StudentCourse studentCourse = null;
        for (StudentCourse sc: studentCourses)
        {
            if (sc.getStudent().getId() == studentId && sc.getCourse().getId() == courseId)
            {
                studentCourse = sc;
                break;
            }
        }
        return studentCourse;
    }
    public Application getApplicationByStudentIdAndCourseId(int studentId, int courseId, Set<Application> applications)
    {
        Application application = null;
        for (Application a: applications)
        {
            if (a.getStudent().getId() == studentId && a.getCourse().getId() == courseId)
            {
                application = a;
                break;
            }
        }
        return application;
    }
}
