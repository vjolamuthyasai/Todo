package com.example.todo.service;

import com.example.todo.entity.Course;
import com.example.todo.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    private CourseRepository courseRepository;
    CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    // Save Courses
    public Course saveCourse(Course course){
        System.out.println(course.toString());
        return courseRepository.save(course);
    }

    public List<Course> saveCourses(List<Course> courses){
        return courseRepository.saveAll(courses);
    }

    // Get All Courses
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseById(int id){
        return courseRepository.findById(id).orElse(null);
    }

    public Course getCourseByName(String name){
        return courseRepository.findByName(name);
    }

    public List<Course> getCoursesForUser(String userName){
        return courseRepository.findAllByUserName(userName);
    }


    // Update Courses
    public Course updateCourse(Course course){
        System.out.println("updates");
        Course existing_course = courseRepository.findById(course.getId()).orElse(null);
        existing_course.setName(course.getName());
        existing_course.setDescription(course.getDescription());
        existing_course.setStatus(course.getStatus());
        return courseRepository.save(existing_course);
    }


    // Delete Courses
    public String deleteCourse(int id){
        courseRepository.deleteById(id);
        return id+"id-> course removed/completed";
    }
}
