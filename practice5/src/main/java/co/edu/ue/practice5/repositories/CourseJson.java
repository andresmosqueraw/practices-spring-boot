package co.edu.ue.practice5.repositories;

import co.edu.ue.practice5.model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Primary
@Repository
public class CourseJson implements ICourseData{

    private List<Course> listCourses;

    public CourseJson() {
        Resource path = new ClassPathResource("json/data.json");
        ObjectMapper mapper = new ObjectMapper();
        Course[] courses = null;
        try {
            courses = mapper.readValue(path.getInputStream(), Course[].class);
        } catch (IOException e) {
            this.listCourses = new ArrayList<>();
            throw new RuntimeException(e);
        }
        this.listCourses = new ArrayList<>(Arrays.asList(courses));
    }

    @Override
    public List<Course> getDataList() {
        return this.listCourses;
    }

    @Override
    public Course getCourseName(String name) {
        return this.listCourses.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Course getCourseId(long id) {
        return this.listCourses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
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
