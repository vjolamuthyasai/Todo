package com.example.todo.repositories;

import com.example.todo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findByName(String name);

    List<Course> findAllByUserName(String userName);
}
