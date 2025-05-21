package com.karam.springboot.learn_jpa_hibernate.course.jpa;

import com.karam.springboot.learn_jpa_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext //more specific annotation
    //specifically used for entitymanager
    //tied to the context of jpa
    //@Autowired
    private EntityManager em;

    public void insert(Course course) {
        em.merge(course);
    }

    public void delete(long id) {
        em.remove(em.find(Course.class, id));
    }

    public Course select(long id) {
        return em.find(Course.class, id);
    }
}
