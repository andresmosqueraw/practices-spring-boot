package co.edu.ue.practice2.repositories;

import co.edu.ue.practice2.model.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseData {
    List<Course> dataCourses;

    public CourseData() {
        this.dataCourses = new ArrayList<>(Arrays.asList(
            new Course(1, "Java", "Java Course", 1000),
            new Course(2, "Spring", "Spring Course", 1500),
            new Course(3, "Angular", "Angular Course", 2000),
            new Course(4, "React", "React Course", 2500),
            new Course(5, "Python", "Python Course", 3000)
        ));
    }

    public List<Course> getDataList() {
        return this.dataCourses;
    }

    public Course getCourseName(String name) {
        for (Course course : this.dataCourses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
        // return this.dataCourses.stream().filter(course -> course.getName().equals(name)).findFirst().orElse(null);
        // Explicacion de la linea anterior:
        // Se obtiene el stream de la lista de cursos, se filtra por el nombre del curso y se obtiene el primer elemento que cumpla con la condicion
    }

    public Course getCourseId(long id) {
        return this.dataCourses.stream().filter(course -> course.getId() == id).findFirst().orElseThrow();
    }

    public List<Course> postCourse(Course course) {
        this.dataCourses.add(course);
        return this.dataCourses;
    }

    public List<Course> putCourse(Course course) {
        for (Course c : this.dataCourses) {
            if (c.getId() == course.getId()) {
                c.setName(course.getName());
                c.setDescription(course.getDescription());
                c.setPrice(course.getPrice());
            }
        }
        return this.dataCourses;
    }

    public List<Course> deleteCourse(long id) {
        this.dataCourses.removeIf(course -> course.getId() == id);
        return this.dataCourses;
    }
}
