package com.university.repository.impl.implperiod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositoryPeriod;
import com.university.repository.models.Period;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryPeriodMysqlImpl implements RepositoryPeriod{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Period> toList() {
        List<Period> listPeriods = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM periods");) {
            while (rs.next()) {
                listPeriods.add(createPeriod(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPeriods;
    }

    @Override
    public Period findById(int period_id) {
        Period period = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM periods WHERE period_id = ?");) {
            pstmt.setInt(1, period_id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    period = createPeriod(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return period;
    }

    @Override
    public Period findByCode(String period_code) {
        Period period = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM periods WHERE period_code = ?");) {
            pstmt.setString(1, period_code);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    period = createPeriod(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return period;
    }

    @Override
    public void create(Period period) {
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO periods (period_year, semester, period_code) VALUES (?, ?, ?)");) {
            pstmt.setInt(1, period.getYear());
            pstmt.setString(2, period.getSemester());
            pstmt.setString(3, period.getCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(int period_id) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM periods WHERE period_id = ?");) {
            pstmt.setInt(1, period_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(Period period) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE periods SET period_year = ?, semester = ?, period_code = ? WHERE period_id = ?");) {
            pstmt.setInt(1, period.getYear());
            pstmt.setString(2, period.getSemester());
            pstmt.setString(3, period.getCode());
            pstmt.setInt(4, period.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private Period createPeriod(ResultSet rs) throws SQLException {
        Period period = new Period();
        period.setId(rs.getInt("period_id"));
        period.setCode(rs.getString("period_code"));
        period.setYear(rs.getInt("period_year"));
        period.setSemester(rs.getString("semester"));
        return period;
    }

}
