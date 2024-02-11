package com.university.repository.impl.implschedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositorySchedule;
import com.university.repository.models.Schedule;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryScheduleMysqlImpl implements RepositorySchedule{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    @Override
    public List<Schedule> toList() {

        List <Schedule> listSchedules = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM schedules");) {
            while (rs.next()) {
                listSchedules.add(createSchedule(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSchedules;
    }

    @Override
    public Schedule findById(int schedule_id) {

        Schedule schedule = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE schedule_id = ?");) {
            pstmt.setInt(1, schedule_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    schedule = createSchedule(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedule;

    }

    @Override
    public void create(Schedule schedule) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO schedules (schedule_day, start_time, end_time, classroom_id, signature_id) VALUES (?, ?, ?, ?, ?)");) {
            pstmt.setString(1, schedule.getDay());
            pstmt.setString(2, schedule.getStart());
            pstmt.setString(3, schedule.getEnd());
            pstmt.setInt(4, schedule.getClassroomId());
            pstmt.setInt(5, schedule.getSignatureId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Schedule schedule) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE schedules SET schedule_day = ?, start_time = ?, end_time = ?, classroom_id = ?, signature_id = ? WHERE schedule_id = ?");) {
            pstmt.setString(1, schedule.getDay());
            pstmt.setString(2, schedule.getStart());
            pstmt.setString(3, schedule.getEnd());
            pstmt.setInt(4, schedule.getClassroomId());
            pstmt.setInt(5, schedule.getSignatureId());
            pstmt.setInt(6, schedule.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Schedule> toListByStudentId(int student_id) {
        
        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE signature_id IN (SELECT siganture_id FROM registers WHERE student_id = ?)");) {
            pstmt.setInt(1, student_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> toListByTeacherId(int teacher_id) {

        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE signature_id IN (SELECT siganture_id FROM signatures WHERE teacher_id = ?)");) {
            pstmt.setInt(1, teacher_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> toListBySignatureId(int signature_id) {
        
        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE signature_id = ?");) {
            pstmt.setInt(1, signature_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> toListByClassroomId(int classroom_id) {

        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE classroom_id = ?");) {
            pstmt.setInt(1, classroom_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    @Override
    public List<Schedule> toListByDay(String day) {

        List <Schedule> listSchedules = new ArrayList<>();

        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM schedules WHERE schedule_day = ?");) {
            pstmt.setString(1, day);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listSchedules.add(createSchedule(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSchedules;

    }

    private Schedule createSchedule(ResultSet rs) throws SQLException {
        return new Schedule(rs.getInt("schedule_id"), rs.getString("schedule_day"), rs.getString("start_time"), rs.getString("end_time"), rs.getInt("classroom_id"), rs.getInt("signature_id"));
    }

}
