package com.university.services;

import java.util.List;

import com.university.repository.models.Course;

public interface ServiceCourse {
    
    List<Course> toList();

    Course findById(int course_id);

    Course findByName(String course_name);

    void create(Course course);

    void update(Course course);

    void delete(int id_course);

}
