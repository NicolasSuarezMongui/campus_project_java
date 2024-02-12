package com.university.repository.impl.implclassroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.exceptions.classroomexceptions.ClassroomExceptionInsertDataBase;
import com.university.repository.RepositoryClassroom;
import com.university.repository.models.Classroom;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryClassroomMysqlImpl implements RepositoryClassroom{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    public List<Classroom> toList() {
        List<Classroom> listClassrooms = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM classrooms");) {
            while (rs.next()) {
                listClassrooms.add(createClassroom(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClassrooms;
    }

    public Classroom findById(int classroom_id) {
        Classroom classroom = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM classrooms WHERE classroom_id = ?");) {
            pstmt.setInt(1, classroom_id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    classroom = createClassroom(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    public Classroom findByName(String classroom_name) {
        Classroom classroom = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM classrooms WHERE classroom_name = ?");) {
            pstmt.setString(1, classroom_name);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    classroom = createClassroom(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    public void create(Classroom classroom) throws ClassroomExceptionInsertDataBase {
        
        Connection conn = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO classrooms (classroom_capacity, classroom_level, classroom_code, building_id) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);) {
                pstmt.setInt(1, classroom.getCapacity());
                pstmt.setInt(2, classroom.getLevel());
                pstmt.setString(3, classroom.getName());
                pstmt.setInt(4, classroom.getBuildingId());
                pstmt.executeUpdate();
                try (ResultSet rs = pstmt.getGeneratedKeys();) {
                    if (rs.next()) {
                        classroom.setId(rs.getInt(1));
                    } else {
                        throw new ClassroomExceptionInsertDataBase("Error creating classroom, no ID obtained.");
                    }
                }
            }

            conn.commit();

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new ClassroomExceptionInsertDataBase("Error creating classroom");
        }
        
    }

    public void delete(int classroom_id) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM classrooms WHERE classroom_id = ?");) {
            pstmt.setInt(1, classroom_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void update(Classroom classroom) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE classrooms SET classroom_capacity = ?, classroom_name = ?, building_id = ? WHERE classroom_id = ?");) {
            pstmt.setInt(1, classroom.getCapacity());
            pstmt.setString(2, classroom.getName());
            pstmt.setInt(3, classroom.getBuildingId());
            pstmt.setInt(4, classroom.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private Classroom createClassroom(ResultSet rs) throws SQLException {
        return new Classroom(rs.getInt("classroom_id"), rs.getInt("classroom_capacity"), rs.getInt("classroom_level"), rs.getString("classroom_code"), rs.getInt("building_id"));
    }

}
