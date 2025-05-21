/*package com.karam.springboot.learn_jpa_hibernate.course.jdbc;

import com.karam.springboot.learn_jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn H2", "Karam"));
        repository.insert(new Course(2, "Learn SpringBoot", "Karam"));
        repository.insert(new Course(3, "Learn RestAPI", "Karam"));
        repository.delete(1);
        System.out.println(repository.select(2));
        System.out.println(repository.select(3));
    }
}
*/

/*
package com.karam.springboot.learn_jpa_hibernate.course;

import com.karam.springboot.learn_jpa_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn H2 JPA", "Karam"));
        repository.insert(new Course(2, "Learn SpringBoot JPA", "Karam"));
        repository.insert(new Course(3, "Learn RestAPI", "Karam"));
        repository.delete(1);
        System.out.println(repository.select(2));
        System.out.println(repository.select(3));
    }
}
*/

package com.karam.springboot.learn_jpa_hibernate.course;

import com.karam.springboot.learn_jpa_hibernate.course.springDataJpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn H2 JPA", "Karam"));
        repository.save(new Course(2, "Learn SpringBoot JPA", "Karam"));
        repository.save(new Course(3, "Learn RestAPI", "Karam"));

        repository.deleteById(1l);//l signifies long

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Karam"));
        System.out.println(repository.findByName("Learn SpringBoot JPA"));
    }
}