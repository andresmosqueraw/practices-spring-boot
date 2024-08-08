package co.edu.ue.practice5.services;

import co.edu.ue.practice5.model.Course;
import co.edu.ue.practice5.repositories.ICourseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {

    /* @Autowired // inyeccion por atributo
    CourseData data; */

    @Autowired
    ICourseData data;

    // private CourseData data; // inyeccion por contructor/metodo

    @Value("${iva1}") // traer informacion de un archivo de configuracion, mejor hacerlo asi
    double iva1;

    @Value("${iva2}") // traer informacion de un archivo de configuracion, mejor hacerlo asi
    double iva2;

    // final double IVA_19 = 0.19;
    // final double IVA_5 = 0.05;

    /* public CourseService(CourseData data) {
        this.data = data;
    } */

    @Override
    public List<Course> getCourseData() {
        return data.getDataList();
    }

    @Override
    public List<Course> getCourseDataIva19() {
        return data.getDataList().stream().map(
            c -> {
                long value = (long) ((c.getPrice() * iva1) + c.getPrice());
                Course course = new Course(c.getId(), c.getName(), c.getDescription(), value);
                return course;
            }
        ).collect(Collectors.toList());
    }

    @Override
    public List<Course> getCourseDataIva5() {
        return data.getDataList().stream().map(
                c -> {
                    long value = (long) ((c.getPrice() * iva2) + c.getPrice());
                    Course course = new Course(c.getId(), c.getName(), c.getDescription(), value);
                    return course;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Course getCourseName(String name) {
        return data.getCourseName(name);
    }

    @Override
    public Course getCourseId(long id) {
        return data.getCourseId(id);
    }

    @Override
    public List<Course> postCourse(Course course) {
        return data.postCourse(course);
    }

    @Override
    public List<Course> putCourse(Course course) {
        return data.putCourse(course);
    }

    @Override
    public List<Course> deleteCourse(long id) {
        return data.deleteCourse(id);
    }
}
