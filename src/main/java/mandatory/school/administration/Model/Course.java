package mandatory.school.administration.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;


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
    private String ECTS;
    private String language;
    private LocalCourse localCourse;

    public Course(){}

    public Course(int id, int semester, int numberOfTeachers, String description, String nameDanish, String nameEnglish, String studyProgramme, String mandatory, String ECTS, String language, LocalCourse localCourse)
    {
        this.id = id;
        this.semester = semester;
        this.numberOfTeachers = numberOfTeachers;
        this.description = description;
        this.nameDanish = nameDanish;
        this.nameEnglish = nameEnglish;
        this.studyProgramme = studyProgramme;
        this.mandatory = mandatory;
        this.ECTS = ECTS;
        this.language = language;
        this.localCourse = localCourse;
    }

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
    @Size(min = 10, max = 100, message = "Must be at least 10 characters, and maximum 100")
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
    @Pattern(regexp = "[ a-zA-ZæÆøØåÅ1-9,.-]+$", message = "Only characters allowed")
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
    @Pattern(regexp = "[ a-zA-Z1-9,.-]+$", message = "Only characters allowed")
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
    @Size(min = 3, max = 25)
    @Pattern(regexp = "[ ,.a-zA-Z]+$", message = "Only characters allowed")
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
    @Max(value = 30, message = "must be equal to or less than 10")
    @JsonProperty("ects")
    public String getECTS()
    {
        return ECTS;
    }
    public void setECTS(String ECTS)
    {
        this.ECTS = ECTS;
    }

    @NotNull(message = "is required")
    @Size(min = 3, max = 7)
    @Pattern(regexp = "[a-zA-Z]+$", message = "Only characters allowed")
    @JsonProperty("languange")
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }

    @NotNull
    public LocalCourse getLocalCourse()
    {
        return localCourse;
    }
    public void setLocalCourse(LocalCourse localCourse)
    {
        this.localCourse = localCourse;
    }

    @Override
    public String toString()
    {
        return "Course{" +
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
                ", localCourse=" + localCourse +
                '}';
    }
}
