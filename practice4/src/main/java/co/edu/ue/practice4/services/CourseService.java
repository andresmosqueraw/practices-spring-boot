package co.edu.ue.practice4.services;

import co.edu.ue.practice4.model.Course;
import co.edu.ue.practice4.repositories.CourseData;
import co.edu.ue.practice4.repositories.ICourseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService implements co.edu.ue.practice4.services.ICourseService {
    @Autowired // por atributo
    ICourseData data; // por interfaz // Esta es la inyeccion recomendada para usar en nuestros proyectos

    /* @Autowired // inyeccion por atributo
    CourseData data; */

    // private CourseData data; // inyeccion por contructor/metodo

    final double IVA_19 = 0.19;
    final double IVA_5 = 0.05;

    /*public CourseService(CourseData data) { //inyeccion por constructor/metodo
        this.data = data;
    }*/

    @Override
    public List<Course> getCourseData() {
        return data.getDataList();
    }

    @Override
    public List<Course> getCourseDataIva19() {
        return data.getDataList().stream().map(
            c -> {
                long value = (long) ((c.getPrice() * IVA_19) + c.getPrice());
                Course course = new Course(c.getId(), c.getName(), c.getDescription(), value);
                return course;
            }
        ).collect(Collectors.toList());
    }

    @Override
    public List<Course> getCourseDataIva5() {
        return data.getDataList().stream().map(
                c -> {
                    long value = (long) ((c.getPrice() * IVA_5) + c.getPrice());
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
