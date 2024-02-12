package com.university.repository.impl.implstudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.repository.RepositoryStudent;
import com.university.repository.impl.implperson.RepositoryPersonMysqlImpl;
import com.university.repository.models.Person;
import com.university.repository.models.Student;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryStudentMysqlImpl implements RepositoryStudent{
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Person> toList() {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.toListStudents();
    }

    @Override
    public Person findByDocument(String document) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.findByDocument(document);
    }

    @Override
    public void create(Student student) {

        String sql = "INSERT INTO students (person_id, program_id) VALUES (?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, student.getPersonId());
            stmt.setInt(2, student.getProgramId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Person person, int program_id) throws PersonExceptionInsertDataBase{

        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        repositoryPersonMysqlImpl.create(person);

        Person personCreated = repositoryPersonMysqlImpl.findByDocument(person.getDocumentNumber());

        Student student = new Student(program_id, personCreated.getId());

        create(student);

    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE students SET program_id = ? WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, student.getProgramId());
            stmt.setInt(2, student.getPersonId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        String sql = "DELETE FROM students WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
            repositoryPersonMysqlImpl.delete(student.getPersonId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String document) {
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        int person_id = repositoryPersonMysqlImpl.findByDocument(document).getId();
        String sql = "DELETE FROM students WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, person_id);
            stmt.executeUpdate();
            repositoryPersonMysqlImpl.delete(person_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
