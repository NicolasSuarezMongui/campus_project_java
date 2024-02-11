package com.university.repository.impl.impldepartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositoryDepartment;
import com.university.repository.models.Department;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryDepartmentMysqlImpl implements RepositoryDepartment{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    public List<Department> toList(){
        
        List<Department> listDepartments = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM departments");) {
            while (rs.next()) {
                listDepartments.add(createDepartment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDepartments;

    }
    
    public Department findById(int department_id){
        
        Department department = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM departments WHERE department_id = ?");) {
            pstmt.setInt(1, department_id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    department = createDepartment(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;

    }
    
    public Department findByName(String department_name){
        
        Department department = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM departments WHERE department_name = ?");) {
            pstmt.setString(1, department_name);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    department = createDepartment(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;

    }
    
    public void create(Department department){
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO departments (department_name) VALUES (?)");) {
            pstmt.setString(1, department.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void delete(int department_id){
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM departments WHERE department_id = ?");) {
            pstmt.setInt(1, department_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void update(Department department){
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE departments SET department_name = ? WHERE department_id = ?");) {
            pstmt.setString(1, department.getName());
            pstmt.setInt(2, department.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Department createDepartment(ResultSet rs) throws SQLException {
        return new Department(rs.getInt("department_id"), rs.getString("department_name"));
    }

}
