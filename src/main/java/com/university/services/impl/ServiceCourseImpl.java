package com.university.services.impl;

import java.util.List;

import com.university.repository.RepositoryCourse;
import com.university.repository.models.Course;
import com.university.services.ServiceCourse;

public class ServiceCourseImpl implements ServiceCourse{

    private final RepositoryCourse crudRepositoryCourse;

    public ServiceCourseImpl(RepositoryCourse crudRepositoryCourse) {
        this.crudRepositoryCourse = crudRepositoryCourse;
    }
    
    public List<Course> toList(){
        return crudRepositoryCourse.toList();
    }

    public Course findById(int course_id) {
        return crudRepositoryCourse.findById(course_id);
    }

    public Course findByName(String course_name){
        return crudRepositoryCourse.findByName(course_name);
    }

    public void create(Course course){
        crudRepositoryCourse.create(course);
    }

    public void update(Course course){
        crudRepositoryCourse.update(course);
    }

    public void delete(int id_course){
        crudRepositoryCourse.delete(id_course);
    }

}
