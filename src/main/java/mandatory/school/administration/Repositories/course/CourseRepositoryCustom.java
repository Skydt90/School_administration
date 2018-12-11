package mandatory.school.administration.Repositories.course;

import mandatory.school.administration.Model.Course;

public interface CourseRepositoryCustom
{
    Course[] getCoursesLegacy();
    Course postCourseLegacy(Course course);
}
