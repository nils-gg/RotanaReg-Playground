package ejb;

import domain.CourseDomain;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Local
public interface CourseService {

    void addCourse(CourseDomain course);
    void updateCourse(CourseDomain course);
    void removeCourse(Long id);
    CourseDomain getCourse(Long id);
    List<CourseDomain> getCourses();
    public List<CourseDomain> getCoursesContaining(String filter);
}
