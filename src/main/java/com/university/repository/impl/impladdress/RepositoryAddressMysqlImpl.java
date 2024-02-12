package com.university.repository.impl.impladdress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.repository.RepositoryAddress;
import com.university.repository.models.Address;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryAddressMysqlImpl implements RepositoryAddress{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Address> toList() {
        
        List<Address> listAddress = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM addresses");
            while (rs.next()) {
                listAddress.add(createAddress(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAddress;
    }

    @Override
    public Address findById(int address_id) {
        Address address = null;
        try (Statement stmt = getConnection().createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM addresses WHERE address_id = " + address_id);
            if (rs.next()) {
                address = createAddress(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void create(Address address) {
        
        try (PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO addresses (road, road_number, road_cross, road_dist) VALUES (?, ?, ?, ?)");) {
            stmt.setString(1, address.getRoad());
            stmt.setInt(2, address.getRoadNumber());
            stmt.setInt(3, address.getRoadCross());
            stmt.setInt(4, address.getRoadDist());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Address address) {
        
        try (PreparedStatement stmt = getConnection().prepareStatement("UPDATE addresses SET road = ?, road_number = ?, road_cross = ?, road_dist = ? WHERE address_id = ?");) {
            stmt.setString(1, address.getRoad());
            stmt.setInt(2, address.getRoadNumber());
            stmt.setInt(3, address.getRoadCross());
            stmt.setInt(4, address.getRoadDist());
            stmt.setInt(5, address.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(Address address) {
        
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM addresses WHERE address_id = ?");) {
            stmt.setInt(1, address.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private Address createAddress(ResultSet rs) throws SQLException {
        return new Address(rs.getInt("address_id"), rs.getString("road"), rs.getInt("road_number"), rs.getInt("road_cross"), rs.getInt("road_dist"));
    }

}
