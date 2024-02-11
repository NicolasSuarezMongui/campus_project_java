package com.university.repository.impl.implregister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositoryRegister;
import com.university.repository.models.Register;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryRegisterMysqlImpl implements RepositoryRegister{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    @Override
    public List<Register> toList() {
        
        List<Register> listRegisters = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM registers");) {
            while (rs.next()) {
                listRegisters.add(createRegister(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRegisters;

    }

    @Override
    public Register findById(int register_id) {
        
        Register register = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM registers WHERE register_id = ?");) {
            pstmt.setInt(1, register_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    register = createRegister(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return register;

    }

    @Override
    public Register findByStudentId(int student_id) {
        
        Register register = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM registers WHERE student_id = ?");) {
            pstmt.setInt(1, student_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    register = createRegister(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return register;

    }

    @Override
    public void create(Register register) {

        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO registers (student_id, period_id, signature_id) VALUES (?, ?, ?)");) {
            pstmt.setInt(1, register.getStudentId());
            pstmt.setInt(2, register.getPeriodId());
            pstmt.setInt(3, register.getSignatureId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Register register) {

        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE registers SET student_id = ?, period_id = ?, signature_id = ? WHERE register_id = ?");) {
            pstmt.setInt(1, register.getStudentId());
            pstmt.setInt(2, register.getPeriodId());
            pstmt.setInt(3, register.getSignatureId());
            pstmt.setInt(4, register.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Register createRegister(ResultSet rs) throws SQLException {
        return new Register(rs.getInt("register_id"), rs.getInt("student_id"), rs.getInt("period_id"), rs.getInt("signature_id"));
    }

}
