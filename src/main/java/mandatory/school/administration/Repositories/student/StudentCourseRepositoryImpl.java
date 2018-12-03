package mandatory.school.administration.Repositories.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCourseRepositoryImpl implements StudentCourseRepository
{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void add(int studentId, int courseId)
    {
        String sql = "INSERT INTO studentCourse VALUES " +
                "(" + studentId + ", " + courseId + ");";

        jdbc.update(sql);
    }

    @Override
    public void remove(int studentId, int courseId)
    {
        String sql = "DELETE FROM studentCourse " +
                "WHERE student_Id = " + studentId + " AND course_id = " + courseId + ";";

        jdbc.update(sql);
    }
}
