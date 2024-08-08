package co.edu.ue.practice5.controller;

import co.edu.ue.practice5.model.Course;
import co.edu.ue.practice5.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService service;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return service.getCourseData();
    }

    @GetMapping("/courses19")
    public List<Course> getAllCoursesIva19() {
        return service.getCourseDataIva19();
    }

    @GetMapping("/courses5")
    public List<Course> getAllCoursesIva5() {
        return service.getCourseDataIva5();
    }

    @GetMapping("/courses/name")
    public Course getCourseName(String name) {
        return service.getCourseName(name);
    }

    @GetMapping("/courses/{id}")
    public Course getCourseId(@PathVariable("id") long id) {
        return service.getCourseId(id);
    }

    @PostMapping("/courses")
    public List<Course> postCourse(@RequestBody Course course) {
        return service.postCourse(course);
    }

    @GetMapping("/courses/put")
    public List<Course> putCourse(Course course) {
        return service.putCourse(course);
    }

    @GetMapping("/courses/delete")
    public List<Course> deleteCourse(long id) {
        return service.deleteCourse(id);
    }
}
