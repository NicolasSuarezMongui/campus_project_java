package com.university.repository.impl.implcity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositoryCity;
import com.university.repository.models.City;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryCityMysqlImpl implements RepositoryCity{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    @Override
    public List<City> toList() {
        List<City> listCities = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cities");) {
            while (rs.next()) {
                listCities.add(createCity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCities;
    }

    @Override
    public City findByName(String name) {
        City city = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM cities WHERE city_name = ?");) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    city = createCity(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void create(City city) {
        String sql = "INSERT INTO cities (city_name) VALUES (?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, city.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(City city) {
        try (PreparedStatement stmt = getConnection().prepareStatement("UPDATE cities SET city_name = ? WHERE city_id = ?");) {
            stmt.setString(1, city.getName());
            stmt.setInt(2, city.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(City city) {
        
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM cities WHERE city_id = ?");) {
            stmt.setInt(1, city.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private City createCity(ResultSet rs) throws SQLException {
        return new City(rs.getInt("city_id"), rs.getString("city_name"));
    }

}
