package co.edu.ue.practice4.repositories;

import co.edu.ue.practice4.model.Course;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class CourseSpecialData implements ICourseData{

    List<Course> dataCourses;

    @Override
    public List<Course> getDataList() {
        dataCourses = new ArrayList<>();
        dataCourses.add(new Course(1, "Java", "Java Course", 100000));
        return dataCourses;
    }

    @Override
    public Course getCourseName(String name) {
        Course course = new Course(1, "Java", "Java Course", 100000);
        return course;
    }

    @Override
    public Course getCourseId(long id) {
        Course course = new Course(1, "Java", "Java Course", 100000);
        return course;
    }

    @Override
    public List<Course> postCourse(Course course) {
        return List.of();
    }

    @Override
    public List<Course> putCourse(Course course) {
        return List.of();
    }

    @Override
    public List<Course> deleteCourse(long id) {
        return List.of();
    }
}
