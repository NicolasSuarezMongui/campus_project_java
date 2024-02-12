package com.university.repository.impl.implperson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.repository.RepositoryPerson;
import com.university.repository.models.Person;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryPersonMysqlImpl implements RepositoryPerson{
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Person> toList() {
        List<Person> listPersons = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM persons");) {
            while (rs.next()) {
                listPersons.add(createPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    public List<Person> toListStudents() {
        List<Person> listPersons = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM persons p INNER JOIN students s ON p.person_id = s.person_id");) {
            while (rs.next()) {
                listPersons.add(createPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    public List<Person> toListTeachers() {
        List<Person> listPersons = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM persons p INNER JOIN teachers t ON p.person_id = t.person_id");) {
            while (rs.next()) {
                listPersons.add(createPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPersons;
    }

    @Override
    public Person findByDocument(String document) {
        Person person = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM persons WHERE document_numb = ?");) {
            stmt.setString(1, document);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    person = createPerson(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void create(Person person) throws PersonExceptionInsertDataBase{

        Connection conn = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO persons (document_type, document_numb, name, last_name, phone, birthdate, gender, address_id, city_id) VALUES (?, ?, ?, ?, ?, ?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {
                stmt.setString(1, person.getDocuemntType());
                stmt.setString(2, person.getDocumentNumber());
                stmt.setString(3, person.getFirstName());
                stmt.setString(4, person.getLastName());
                stmt.setString(5, person.getPhone());
                stmt.setString(6, person.getBirthdate());
                stmt.setString(7, person.getGender());
                stmt.setInt(8, person.getAddressId());
                stmt.setInt(9, person.getCityId());
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys();) {
                    if (rs.next()) {
                        person.setId(rs.getInt(1));
                    } else {
                        throw new PersonExceptionInsertDataBase("Error inserting person in database");
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
            e.printStackTrace();
            //throw new PersonExceptionInsertDataBase("Error inserting person in database");
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Person person) {
        try (PreparedStatement stmt = getConnection().prepareStatement("UPDATE persons SET name = ?, last_name = ?, phone = ?,  address_id = ?, city_id = ? WHERE document_numb = ?");) {
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getPhone());
            stmt.setInt(4, person.getAddressId());
            stmt.setInt(5, person.getCityId());
            stmt.setString(6, person.getDocumentNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Person person) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM persons WHERE document_numb = ?");) {
            stmt.setString(1, person.getDocumentNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int personId) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM persons WHERE person_id = ?");) {
            stmt.setInt(1, personId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Person createPerson(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("person_id"));
        person.setDocuemntType(rs.getString("document_type"));
        person.setDocumentNumber(rs.getString("document_numb"));
        person.setFirstName(rs.getString("name"));
        person.setLastName(rs.getString("last_name"));
        person.setPhone(rs.getString("phone"));
        person.setBirthdate(rs.getString("birthdate"));
        person.setGender(rs.getString("gender"));
        person.setAddressId(rs.getInt("address_id"));
        person.setCityId(rs.getInt("city_id"));

        return person;
    }
}
