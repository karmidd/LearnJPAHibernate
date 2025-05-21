package com.karam.springboot.learn_jpa_hibernate.course.jdbc;

import com.karam.springboot.learn_jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;; //enables firing queries using spring jdbc

    private static String INSERT_QUERY =
            """
                    insert into course (id, name, author)
                    values(?, ?, ?);
            """;
    private static String DELETE_QUERY =
            """
                    delete from course where id = ?;
            """;
    private static String SELECT_QUERY =
            """
            select * from course where id = ?;
            """;

    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());//execute query
    }

    public void delete(long id){
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course select(long id){
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
        //ResultSet -> Bean -> Row Mapper
        //what happens here is that we are querying for an object (1st parameter),
        //-the 2nd parameter maps the variables of Course into a bean,
        //-the third parameter uses the id to look for the queried item,
        //then returns it
    }
}
