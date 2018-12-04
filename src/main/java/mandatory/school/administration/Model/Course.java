package mandatory.school.administration.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "courses")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course
{
    private int id;
    private int semester;
    private int numberOfTeachers;
    private String description;
    private String nameDanish;
    private String nameEnglish;
    private String studyProgramme;
    private String mandatory;
    private int ECTS;
    private String language;
    private int minimumStudents;
    private int expectedStudents;
    private int maximumStudents;
    private String prerequisites;
    private String learningOutcome;
    private String content;
    private String learningActivities;
    private String examForm;

    private Set<TeacherCourse> teacherCourses;
    private Set<StudentCourse> studentCourses;
    private Set<Application> applications;

    public Course(){}

    public Course(int semester, int numberOfTeachers, String description, @NotNull(message = "is required") @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed") String nameDanish, @NotNull(message = "is required") @Size(min = 3, max = 40) @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed") String nameEnglish, @NotNull(message = "is required") @Size(min = 3, max = 20) @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed") String studyProgramme, @NotNull(message = "is required") @Size(min = 4, max = 5) @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed") String mandatory, @Min(value = 0, message = "must be equal to or greater than 0") @Max(value = 10, message = "must be equal to or less than 10") int ECTS, @NotNull(message = "is required") @Size(min = 3, max = 7) @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed") String language, @Min(value = 5, message = "must have 5 or more students") @Max(value = 45, message = "cannot exceed 45 students") int minimumStudents, @Min(value = 5) @Max(value = 45) int expectedStudents, @Min(value = 5) @Max(value = 45, message = "must have 45 or less students") int maximumStudents, @NotNull @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed") @Size(min = 0, max = 100, message = "cannot exceed 100 characters") String prerequisites, @NotNull @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed") @Size(max = 300, message = "cannot exceed 300 characters") String learningOutcome, @NotNull @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed") @Size(max = 300, message = "cannot exceed 300 characters") String content, @NotNull @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed") @Size(max = 300, message = "cannot exceed 300 characters") String learningActivities, @NotNull @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed") @Size(max = 300, message = "cannot exceed 300 characters") String examForm)
    {
        this.semester = semester;
        this.numberOfTeachers = numberOfTeachers;
        this.description = description;
        this.nameDanish = nameDanish;
        this.nameEnglish = nameEnglish;
        this.studyProgramme = studyProgramme;
        this.mandatory = mandatory;
        this.ECTS = ECTS;
        this.language = language;
        this.minimumStudents = minimumStudents;
        this.expectedStudents = expectedStudents;
        this.maximumStudents = maximumStudents;
        this.prerequisites = prerequisites;
        this.learningOutcome = learningOutcome;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    @Min(value = 1, message = "must be equal to or greater than 1")
    @Max(value = 10, message = "must be equal to or less than 10")
    @Column(name = "semester")
    @JsonProperty("semester")
    public int getSemester()
    {
        return semester;
    }
    public void setSemester(int semester)
    {
        this.semester = semester;
    }

    @Min(value = 0, message = "must be equal to or greater than 0")
    @Max(value = 10, message = "must be equal to or less than 10")
    @Column(name = "number_of_Teachers")
    @JsonProperty("numberOfTeachers")
    public int getNumberOfTeachers()
    {
        return numberOfTeachers;
    }
    public void setNumberOfTeachers(int numberOfTeachers)
    {
        this.numberOfTeachers = numberOfTeachers;
    }

    @NotNull(message = "is required")
    @Pattern(regexp = "[ a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed")
    @Size(min = 10, max = 100, message = "Must be at least 10 characters, and maximum 100")
    @Column(name = "description")
    @JsonProperty("description")
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed")
    @Column(name = "name_danish")
    @JsonProperty("namedanish")
    public String getNameDanish()
    {
        return nameDanish;
    }
    public void setNameDanish(String nameDanish)
    {
        this.nameDanish = nameDanish;
    }

    @NotNull(message = "is required")
    @Size(min = 3, max = 40)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @Column(name = "name_english")
    @JsonProperty("name")
    public String getNameEnglish()
    {
        return nameEnglish;
    }
    public void setNameEnglish(String nameEnglish)
    {
        this.nameEnglish = nameEnglish;
    }

    @NotNull(message = "is required")
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @Column(name = "study_programme")
    @JsonProperty("studyprogramme")
    public String getStudyProgramme()
    {
        return studyProgramme;
    }
    public void setStudyProgramme(String studyProgramme)
    {
        this.studyProgramme = studyProgramme;
    }

    @NotNull(message = "is required")
    @Size(min = 4, max = 5)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @Column(name = "mandatory")
    @JsonProperty("mandatory")
    public String getMandatory()
    {
        return mandatory;
    }
    public void setMandatory(String mandatory)
    {
        this.mandatory = mandatory;
    }

    @Min(value = 0, message = "must be equal to or greater than 0")
    @Max(value = 10, message = "must be equal to or less than 10")
    @Column(name = "ECTS")
    @JsonProperty("ects")
    public int getECTS()
    {
        return ECTS;
    }
    public void setECTS(int ECTS)
    {
        this.ECTS = ECTS;
    }

    @NotNull(message = "is required")
    @Size(min = 3, max = 7)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @Column(name = "language")
    @JsonProperty("languange")
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }

    @Min(value = 5, message = "must have 5 or more students")
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "minimum_students")
    public int getMinimumStudents()
    {
        return minimumStudents;
    }
    public void setMinimumStudents(int minimumStudents)
    {
        this.minimumStudents = minimumStudents;
    }

    @Min(value = 5, message = "must have 5 or more students")
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "expected_students")
    public int getExpectedStudents()
    {
        return expectedStudents;
    }
    public void setExpectedStudents(int expectedStudents)
    {
        this.expectedStudents = expectedStudents;
    }

    @Min(value = 5, message = "must have 5 or more students")
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "maximum_students")
    public int getMaximumStudents()
    {
        return maximumStudents;
    }
    public void setMaximumStudents(int maximumStudents)
    {
        this.maximumStudents = maximumStudents;
    }

    @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(min = 0, max = 100, message = "cannot exceed 100 characters")
    @Column(name = "prerequisites")
    public String getPrerequisites()
    {
        return prerequisites;
    }
    public void setPrerequisites(String prerequisites)
    {
        this.prerequisites = prerequisites;
    }

    @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "learning_outcome")
    public String getLearningOutcome()
    {
        return learningOutcome;
    }
    public void setLearningOutcome(String learningOutcome)
    {
        this.learningOutcome = learningOutcome;
    }

    @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "content")
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "learning_activities")
    public String getLearningActivities()
    {
        return learningActivities;
    }
    public void setLearningActivities(String learningActivities)
    {
        this.learningActivities = learningActivities;
    }

    @Pattern(regexp = "[a-zA-ZøØæÆåÅ]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "exam_form")
    public String getExamForm()
    {
        return examForm;
    }
    public void setExamForm(String examForm)
    {
        this.examForm = examForm;
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<TeacherCourse> getTeacherCourses()
    {
        return teacherCourses;
    }
    public void setTeacherCourses(Set<TeacherCourse> teacherCourses)
    {
        this.teacherCourses = teacherCourses;
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }
    public void setStudentCourses(Set<StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
    }

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Application> getApplications()
    {
        return applications;
    }
    public void setApplications(Set<Application> applications)
    {
        this.applications = applications;
    }

    public TeacherCourse getTeacherCourseByTeacherIdAndCourseId(int teacherId, int courseId)
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
    public StudentCourse getStudentCourseByStudentIdAndCourseId(int studentId, int courseId)
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
    public Application getApplicationByStudentIdAndCourseId(int studentId, int courseId)
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

    @Override
    public String toString()
    {
        return "course{" +
                "id=" + id +
                ", semester=" + semester +
                ", numberOfTeachers=" + numberOfTeachers +
                ", description='" + description + '\'' +
                ", nameDanish='" + nameDanish + '\'' +
                ", nameEnglish='" + nameEnglish + '\'' +
                ", studyProgramme='" + studyProgramme + '\'' +
                ", mandatory='" + mandatory + '\'' +
                ", ECTS=" + ECTS +
                ", language='" + language + '\'' +
                ", minimumStudents=" + minimumStudents +
                ", expectedStudents=" + expectedStudents +
                ", maximumStudents=" + maximumStudents +
                ", prerequisites='" + prerequisites + '\'' +
                ", learningOutcome='" + learningOutcome + '\'' +
                ", content='" + content + '\'' +
                ", learningActivities='" + learningActivities + '\'' +
                ", examForm='" + examForm + '\'' +
                '}';
    }
}
