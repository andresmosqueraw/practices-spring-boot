package co.edu.ue.practice5.repositories;

import co.edu.ue.practice5.model.Course;

import java.util.List;

public interface ICourseData {
    List<Course> getDataList();
    Course getCourseName(String name);
    Course getCourseId(long id);
    List<Course> postCourse(Course course);
    List<Course> putCourse(Course course);
    List<Course> deleteCourse(long id);
}
