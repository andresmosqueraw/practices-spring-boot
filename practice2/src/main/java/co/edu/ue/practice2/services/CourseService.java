package co.edu.ue.practice2.services;

import co.edu.ue.practice2.model.Course;
import co.edu.ue.practice2.repositories.CourseData;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService implements ICourseService{

    CourseData data = new CourseData();
    final double IVA_19 = 0.19;
    final double IVA_5 = 0.05;

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
