package com.university.repository.impl.implprogram;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.university.repository.RepositoryProgram;
import com.university.repository.models.Program;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryProgramMysqlImpl implements RepositoryProgram{

    private Connection getConnection()  throws SQLException{
        return ConexionBDMysql.getInstance();
    }

    public List<Program> toList(){
        List<Program> listPrograms = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM programs");) {
            while (rs.next()) {
                listPrograms.add(createProgram(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPrograms;

    }

    public Program findById(int program_id){
        
        Program program = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM programs WHERE program_id = ?");) {
            pstmt.setInt(1, program_id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    program = createProgram(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return program;
    }

    public Program findByName(String program_name){
        Program program = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM programs WHERE program_name = ?");) {
            pstmt.setString(1, program_name);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    program = createProgram(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return program;
    }

    public void create(Program program){
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO programs (program_name) VALUES (?)");) {
            pstmt.setString(1, program.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int program_id){
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM programs WHERE program_id = ?");) {
            pstmt.setInt(1, program_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Program program){
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE programs SET program_name = ?, program_level = ? WHERE program_id = ?");) {
            pstmt.setString(1, program.getName());
            pstmt.setString(2, program.getLevel());
            pstmt.setInt(3, program.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Program createProgram(ResultSet rs) throws SQLException{
        return new Program(rs.getInt("program_id"), rs.getString("program_name"), rs.getString("program_level"));
    }
}
