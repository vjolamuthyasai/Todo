package com.example.todo.controller;

import com.example.todo.entity.Course;
import com.example.todo.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = {"http://localhost:3000}"})
@RestController
public class CourseController {

    private CourseService courseService;
    CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        logger.info("Course Object {}", course.toString());
        return courseService.saveCourse(course);
    }

    @PostMapping("/addCourses")
    public List<Course> addCourses(@RequestBody List<Course> courses){
        return courseService.saveCourses(courses);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/courseById/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/courseByName/{name}")
    public Course getCourseByName(@PathVariable String name){
        return courseService.getCourseByName(name);
    }

    @GetMapping("/listCourseByUserName/{userName}")
    public List<Course> getCourseByUserName(@PathVariable String userName){
        return courseService.getCoursesForUser(userName);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        System.out.println("UPDATED");
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }
}
