package com.rotanareg.skolan;

import javax.ejb.EJB;

        import com.rotanareg.skolan.domains.Course;
        import com.rotanareg.skolan.coursePersist.*;

        import javax.faces.bean.ManagedBean;
        import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-20.
 */

@ManagedBean
@RequestScoped
public class CoursesBean {
    private Long id;
    private String name;
    private String description;
    private String courseNr;
    @EJB
    CourseService courseService;


    public String addCourse(){
        if (getId()==null)
            courseService.addCourse(new Course(name, description, courseNr));
        else
            courseService.updateCourse(new Course(getId(),getName(),getDescription(),getCourseNr()));

        setId(null);
        setName("");
        setDescription("");
        setCourseNr("");
        return "course";
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

    public CourseService getCourses() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
    //    public String editPerson(Long id){
//        PersonDomain personDomain = personService.getPerson(id);
//        setId(personDomain.getId());
//        setFirstname(personDomain.getFirstName());
//        setLastname(personDomain.getLastName());
//        return "person";
//    }
//    public String removePerson(Long id){
//        personService.removePerson(id);
//        return "person";
//    }
//    public List<Course> getCourses(){
//        return courseService.getCourses();
//    }
//    public List<PersonDomain> getPersonsFilter(){
//        if (myFilter==null || myFilter.equals(""))
//            return personService.getPersons();
//        else
//            return personService.getPersonsFirtsNameContain(myFilter);
//    }
//
//    public String getSubmitButtonLabel(){
//        if (id==null)
//            return "Add";
//        else
//            return "Update";
//    }
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getMyFilter() {
//        return myFilter;
//    }
//
//    public void setMyFilter(String myFilter) {
//        this.myFilter = myFilter;
//    }
}