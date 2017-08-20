package ejb;

import domain.CourseDomain;
import jpa.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Solidbeans on 2017-03-20.
 */

@Stateless
public class CourseServiceImpl implements CourseService{
    @PersistenceContext
    EntityManager em;

    @Override
    public void addCourse(CourseDomain course) {
        Course c = new Course(course.getName(),course.getDescription(),course.getCourseNr());
        em.persist(c);

    }

    @Override
    public void updateCourse(CourseDomain course) {
        Course c = em.find(Course.class,course.getId());
        c.setName(course.getName());
        c.setDescription(course.getDescription());
        c.setCourseNr(course.getCourseNr());
        em.merge(c);
    }

    @Override
    public void removeCourse(Long id) {
        Course c = em.find(Course.class, id);
        em.remove(c);
    }

    @Override
    public CourseDomain getCourse(Long id) {
        Course c = em.find(Course.class,id);
        CourseDomain cd = new CourseDomain(c.getId(),c.getName(),c.getDescription(),c.getCourseNr());

        return cd;
    }

    @Override
    public List<CourseDomain> getCourses() {
       List<Course> courseList = em.createNamedQuery("selectAll").getResultList();

       return courseList.stream().
               map(c->new CourseDomain(c.getId(),c.getName(),c.getDescription(),c.getCourseNr())).
               collect(Collectors.toList());
    }

    @Override
    public List<CourseDomain> getCoursesContaining(String filter) {
        List<Course> courseList = em.createNamedQuery("selectSome").setParameter("filt",filter).getResultList();

        return courseList.stream().
                map(c->new CourseDomain(c.getId(),c.getName(),c.getDescription(),c.getCourseNr())).
                collect(Collectors.toList());
    }

}
