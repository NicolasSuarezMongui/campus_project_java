package com.university.repository.impl.implsignature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositorySignature;
import com.university.repository.models.Signature;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositorySignatureMysqlImpl implements RepositorySignature{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    @Override
    public List<Signature> toList() {
        List<Signature> listSignatures = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM signatures");) {
            while (rs.next()) {
                listSignatures.add(createSignature(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSignatures;
    }

    @Override
    public Signature findById(int signature_id) {
        Signature signature = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM signatures WHERE signature_id = ?");) {
            pstmt.setInt(1, signature_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    signature = createSignature(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signature;
    }

    @Override
    public Signature findByName(String signature_name) {
        Signature signature = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM signatures WHERE name = ?");) {
            pstmt.setString(1, signature_name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    signature = createSignature(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signature;
    }

    @Override
    public void create(Signature signature) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO signatures (credits, capacity, duration, name, teacher_id, course_id, period_id) VALUES (?, ?, ?, ?, ?, ?, ?)");) {
            pstmt.setInt(1, signature.getCredits());
            pstmt.setInt(2, signature.getCapacity());
            pstmt.setInt(3, signature.getDuration());
            pstmt.setString(4, signature.getName());
            pstmt.setInt(5, signature.getTeacherId());
            pstmt.setInt(6, signature.getCourseId());
            pstmt.setInt(7, signature.getPeriodId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int signature_id) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM signatures WHERE signature_id = ?");) {
            pstmt.setInt(1, signature_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Signature signature) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE signatures SET credits = ?, capacity = ?, duration = ?, name = ?, teacher_id = ?, course_id = ?, period_id = ? WHERE signature_id = ?");) {
            pstmt.setInt(1, signature.getCredits());
            pstmt.setInt(2, signature.getCapacity());
            pstmt.setInt(3, signature.getDuration());
            pstmt.setString(4, signature.getName());
            pstmt.setInt(5, signature.getTeacherId());
            pstmt.setInt(6, signature.getCourseId());
            pstmt.setInt(7, signature.getPeriodId());
            pstmt.setInt(8, signature.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Signature createSignature(ResultSet rs) throws SQLException {
        return new Signature(rs.getInt("signature_id"), rs.getInt("credits"), rs.getInt("capacity"), rs.getInt("duration"), rs.getString("name"), rs.getInt("teacher_id"), rs.getInt("course_id"), rs.getInt("period_id"));
    }

}
