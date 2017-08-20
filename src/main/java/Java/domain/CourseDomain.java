package domain;

/**
 * Created by Nils Gerstner on 8/20/17.
 */
public class CourseDomain {
    private long id;
    private String name;
    private String description;
    private String courseNr;

    public CourseDomain(String name, String description, String courseNr){
        this.name = name;
        this.description = description;
        this.courseNr = courseNr;
    }

    public CourseDomain(long id, String name, String description, String courseNr){
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseNr = courseNr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseNr() {
        return courseNr;
    }

    public void setCourseNr(String courseNr) {
        this.courseNr = courseNr;
    }
}