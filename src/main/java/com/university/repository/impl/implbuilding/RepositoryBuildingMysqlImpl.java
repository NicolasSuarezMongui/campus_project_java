package com.university.repository.impl.implbuilding;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.university.repository.RepositoryBuilding;
import com.university.repository.models.Building;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryBuildingMysqlImpl implements RepositoryBuilding{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    @Override
    public List<Building> toList() {
        
        List<Building> listBuildings = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM buildings");) {
            while (rs.next()) {
                listBuildings.add(createBuilding(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBuildings;

    }

    @Override
    public Building findById(int building_id) {
        
        Building building = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM buildings WHERE building_id = ?");) {
            pstmt.setInt(1, building_id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    building = createBuilding(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return building;

    }

    @Override
    public Building findByName(String building_name) {
        
        Building building = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM buildings WHERE building_name = ?");) {
            pstmt.setString(1, building_name);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    building = createBuilding(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return building;

    }
    
    @Override
    public void create(Building building) {
        
        try (PreparedStatement pstmt = getConnection().prepareStatement("INSERT INTO buildings (building_name, building_levels) VALUES (?, ?)");) {
            pstmt.setString(1, building.getName());
            pstmt.setInt(2, building.getLevels());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Building building) {

        try (PreparedStatement pstmt = getConnection().prepareStatement("UPDATE buildings SET building_name = ?, building_levels = ? WHERE building_id = ?");) {
            pstmt.setString(1, building.getName());
            pstmt.setInt(2, building.getLevels());
            pstmt.setInt(3, building.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(int building_id) {

        try (PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM buildings WHERE building_id = ?");) {
            pstmt.setInt(1, building_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private Building createBuilding(ResultSet rs) throws SQLException{
        return new Building(rs.getInt("building_id"), rs.getString("building_name"), rs.getInt("building_levels"));
    }

}
