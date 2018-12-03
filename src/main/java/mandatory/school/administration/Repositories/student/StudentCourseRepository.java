package mandatory.school.administration.Repositories.student;

public interface StudentCourseRepository
{
    void add(int studentId, int courseId);
    void remove(int studentId, int courseId);
}
