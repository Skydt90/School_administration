package mandatory.school.administration.Repositories.teacher;

import mandatory.school.administration.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class TeacherCourseRepositoryImpl implements TeacherCourseRepository
{
    @Autowired
    JdbcTemplate jdbc;


    @Override
    public void add(Set<Teacher> teachers, int courseId)
    {
        for (Teacher teacher : teachers)
        {
            String sql = "INSERT INTO teacherCourse VALUES " +
                    "( " + teacher.getId() + ", " + courseId + ");";
            jdbc.update(sql);
        }
    }

    @Override
    public void remove(Set<Teacher> teachers, int courseId)
    {
        for (Teacher teacher : teachers)
        {
            String sql = "DELETE FROM teacherCourse WHERE " +
                    "( teacher_id = " + teacher.getId() + " AND course_id = " + courseId + ");";
            jdbc.update(sql);
        }
    }
}
