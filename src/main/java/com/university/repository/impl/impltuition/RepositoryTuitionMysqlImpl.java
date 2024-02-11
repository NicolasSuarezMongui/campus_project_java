package com.university.repository.impl.impltuition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositoryTuition;
import com.university.repository.models.Tuition;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryTuitionMysqlImpl implements RepositoryTuition{
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Tuition> toList() {
        List<Tuition> listTuition = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tuitions");) {
            while (rs.next()) {
                listTuition.add(createTuition(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTuition;
    }

    @Override
    public Tuition findById(int tuiton_id) {
        Tuition tuition = null;
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tuitions WHERE tuition_id = " + tuiton_id);) {
            if (rs.next()) {
                tuition = createTuition(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tuition;
    }

    @Override
    public void create(Tuition tuiton) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO tuitions (credit_cost, program_id, period_id) VALUES (?, ?, ?)");) {
            pstmt.setInt(1, tuiton.getCreditValue());
            pstmt.setInt(2, tuiton.getProgramId());
            pstmt.setInt(3, tuiton.getPeriodId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int tuiton_id) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM tuitions WHERE tuition_id = ?");) {
            pstmt.setInt(1, tuiton_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Tuition tuiton) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE tuitions SET credit_cost = ?, program_id = ?, period_id = ? WHERE tuition_id = ?");) {
            pstmt.setInt(1, tuiton.getCreditValue());
            pstmt.setInt(2, tuiton.getProgramId());
            pstmt.setInt(3, tuiton.getPeriodId());
            pstmt.setInt(4, tuiton.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Tuition createTuition(ResultSet rs) throws SQLException {
        return new Tuition(rs.getInt("tuition_id"), rs.getInt("credit_cost"), rs.getInt("program_id"), rs.getInt("period_id"));
    }

}
