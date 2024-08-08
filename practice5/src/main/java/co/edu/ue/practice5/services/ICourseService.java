package co.edu.ue.practice5.services;

import co.edu.ue.practice5.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getCourseData();
    List<Course> getCourseDataIva19();
    List<Course> getCourseDataIva5();
    Course getCourseName(String name);
    Course getCourseId(long id);
    List<Course> postCourse(Course course);
    List<Course> putCourse(Course course);
    List<Course> deleteCourse(long id);
}
