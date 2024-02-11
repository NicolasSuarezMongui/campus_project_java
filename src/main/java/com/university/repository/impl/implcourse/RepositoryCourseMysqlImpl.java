package com.university.repository.impl.implcourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositoryCourse;
import com.university.repository.models.Course;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryCourseMysqlImpl implements RepositoryCourse {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Course> toList() {
        
        List<Course> listCourse = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM course");
            while (rs.next()) {
                listCourse.add(createCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCourse;

    }

    @Override
    public Course findById(int course_id) {
        
        Course course = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM course WHERE course_id = ?");) {
            stmt.setInt(1, course_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                course = createCourse(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
        
    }

    @Override
    public Course findByName(String course_name) {
        
        Course course = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM course WHERE course_name = ?");) {
            stmt.setString(1, course_name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                course = createCourse(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;

    }

    @Override
    public void create(Course course) {
        
        try (PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO course (course_name, course_guide) VALUES (?, ?)");) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getGuide());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int course_id) {
    
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM course WHERE course_id = ?");) {
            stmt.setInt(1, course_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Course course) {
        
        try (PreparedStatement stmt = getConnection().prepareStatement("UPDATE course SET course_name = ?, course_guide = ? WHERE course_id = ?");) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getGuide());
            stmt.setInt(3, course.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Course createCourse(ResultSet rs) throws SQLException{
        
        return new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("course_guide"));
    }
}
