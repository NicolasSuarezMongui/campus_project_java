package com.university.repository;

import java.util.List;

import com.university.repository.models.Course;

public interface RepositoryCourse {

    public List<Course> toList();

    public Course findById(int course_id);

    public Course findByName(String course_name);

    public void create(Course course);

    public void delete(int course_id);

    public void update(Course course);

}
