package mandatory.school.administration.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "courses")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 1, message = "must be equal to or greater than 1")
    @Max(value = 10, message = "must be equal to or less than 10")
    @Column(name = "semester")
    @JsonProperty("semester")
    private int semester;

    @Min(value = 0, message = "must be equal to or greater than 0")
    @Max(value = 10, message = "must be equal to or less than 10")
    @Column(name = "number_of_Teachers")
    @JsonProperty("numberOfTeachers")
    private int numberOfTeachers;

    @NotNull(message = "is required")
    @Pattern(regexp = "[ a-zA-ZæÆøØåÅ.]+$", message = "Only characters allowed")
    @Size(min = 10, max = 100, message = "Must be at least 10 characters, and maximum 100")
    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-ZæÆøØåÅ]+$", message = "Only characters allowed")
    @Column(name = "name_danish")
    @JsonProperty("namedanish")
    private String nameDanish;

    @NotNull(message = "is required")
    @Size(min = 3, max = 40)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @Column(name = "name_english")
    @JsonProperty("name")
    private String nameEnglish;

    @NotNull(message = "is required")
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[ a-zA-Z.]+$", message = "Only characters allowed")
    @Column(name = "study_programme")
    @JsonProperty("studyprogramme")
    private String studyProgramme;

    @NotNull(message = "is required")
    @Size(min = 4, max = 5)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @Column(name = "mandatory")
    @JsonProperty("mandatory")
    private String mandatory;

    @Min(value = 0, message = "must be equal to or greater than 0")
    @Max(value = 10, message = "must be equal to or less than 10")
    @Column(name = "ECTS")
    @JsonProperty("ects")
    private int ECTS;

    @NotNull(message = "is required")
    @Size(min = 3, max = 7)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @Column(name = "language")
    @JsonProperty("languange")
    private String language;

    @Min(value = 5, message = "must have 5 or more students")
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "minimum_students")
    private int minimumStudents;

    @Min(value = 5, message = "must have 5 or more students")
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "expected_students")
    private int expectedStudents;

    @Min(value = 5, message = "must have 5 or more students")
    @Max(value  = 45, message = "cannot exceed 45 students")
    @Column(name = "maximum_students")
    private int maximumStudents;

    @NotNull
    @Pattern(regexp = "[ a-zA-ZøØæÆåÅ.]+$", message = "Only characters allowed")
    @Size(min = 0, max = 100, message = "cannot exceed 100 characters")
    @Column(name = "prerequisites")
    private String prerequisites;

    @NotNull
    @Pattern(regexp = "[ a-zA-ZøØæÆåÅ.]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "learning_outcome")
    private String learningOutcome;

    @NotNull
    @Pattern(regexp = "[ a-zA-ZøØæÆåÅ.]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "content")
    private String content;

    @NotNull
    @Pattern(regexp = "[ a-zA-ZøØæÆåÅ.]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "learning_activities")
    private String learningActivities;

    @NotNull
    @Pattern(regexp = "[ a-zA-ZøØæÆåÅ.]+$", message = "Only characters allowed")
    @Size(max = 300, message = "cannot exceed 300 characters")
    @Column(name = "exam_form")
    private String examForm;

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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSemester()
    {
        return semester;
    }

    public void setSemester(int semester)
    {
        this.semester = semester;
    }

    public int getNumberOfTeachers()
    {
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(int numberOfTeachers)
    {
        this.numberOfTeachers = numberOfTeachers;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getNameDanish()
    {
        return nameDanish;
    }

    public void setNameDanish(String nameDanish)
    {
        this.nameDanish = nameDanish;
    }

    public String getNameEnglish()
    {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish)
    {
        this.nameEnglish = nameEnglish;
    }

    public String getStudyProgramme()
    {
        return studyProgramme;
    }

    public void setStudyProgramme(String studyProgramme)
    {
        this.studyProgramme = studyProgramme;
    }

    public String getMandatory()
    {
        return mandatory;
    }

    public void setMandatory(String mandatory)
    {
        this.mandatory = mandatory;
    }

    public int getECTS()
    {
        return ECTS;
    }

    public void setECTS(int ECTS)
    {
        this.ECTS = ECTS;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public int getMinimumStudents()
    {
        return minimumStudents;
    }

    public void setMinimumStudents(int minimumStudents)
    {
        this.minimumStudents = minimumStudents;
    }

    public int getExpectedStudents()
    {
        return expectedStudents;
    }

    public void setExpectedStudents(int expectedStudents)
    {
        this.expectedStudents = expectedStudents;
    }

    public int getMaximumStudents()
    {
        return maximumStudents;
    }

    public void setMaximumStudents(int maximumStudents)
    {
        this.maximumStudents = maximumStudents;
    }

    public String getPrerequisites()
    {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites)
    {
        this.prerequisites = prerequisites;
    }

    public String getLearningOutcome()
    {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome)
    {
        this.learningOutcome = learningOutcome;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getLearningActivities()
    {
        return learningActivities;
    }

    public void setLearningActivities(String learningActivities)
    {
        this.learningActivities = learningActivities;
    }

    public String getExamForm()
    {
        return examForm;
    }

    public void setExamForm(String examForm)
    {
        this.examForm = examForm;
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
