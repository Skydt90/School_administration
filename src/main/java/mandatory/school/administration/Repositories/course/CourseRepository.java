package mandatory.school.administration.Repositories.course;

import mandatory.school.administration.Model.LocalCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<LocalCourse, Integer>, CourseRepositoryCustom
{
    List<LocalCourse> findAllByApplications_studentId(int studentId);
    List<LocalCourse> findAllByStudentCourses_studentId(int studentId);
    List<LocalCourse> findAllByTeacherCourses_teacherId(int teacherId);
}
