package com.karam.springboot.learn_jpa_hibernate.course.springDataJpa;

import com.karam.springboot.learn_jpa_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {//entity it manages is course, and id is of type long
    //can also add custom methods!
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
