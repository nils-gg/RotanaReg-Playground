package jpa;

import javax.persistence.*;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Entity
@NamedQueries({
        @NamedQuery(name="selectAll",query="SELECT c FROM Course c"),
        @NamedQuery(name="selectSome",query="SELECT t FROM Course t WHERE LOCATE(:filt,t.name) OR LOCATE(:filt,t.courseNr) >0 ")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String courseNr;

    public Course() {
    }

    public Course(String name, String description, String courseNr) {
        this.name = name;
        this.description = description;
        this.courseNr = courseNr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
