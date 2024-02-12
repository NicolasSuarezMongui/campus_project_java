package com.university.repository.impl.implteacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.university.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.university.repository.RepositoryTeacher;
import com.university.repository.impl.implperson.RepositoryPersonMysqlImpl;
import com.university.repository.models.Person;
import com.university.repository.models.Teacher;
import com.university.utils.connectionsdb.connectiondbmysql.ConexionBDMysql;

public class RepositoryTeacherMysqlImpl implements RepositoryTeacher{
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Person> toList(){
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.toListTeachers();
    }
    
    @Override
    public Person findByDocument(String document){
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        return repositoryPersonMysqlImpl.findByDocument(document);
    }

    @Override
    public void create(Teacher teacher){
        
        String sql = "INSERT INTO teachers (person_id, department_id) VALUES (?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, teacher.getPersonId());
            stmt.setInt(2, teacher.getDepartmentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void create(Person person, int department_id) throws PersonExceptionInsertDataBase{
        
        RepositoryPersonMysqlImpl repositoryPersonMysqlImpl = new RepositoryPersonMysqlImpl();
        repositoryPersonMysqlImpl.create(person);

        Person personCreated = repositoryPersonMysqlImpl.findByDocument(person.getDocumentNumber());

        Teacher teacher = new Teacher(personCreated.getId(), department_id);

        create(teacher);

    }

    @Override
    public void update(Teacher teacher){
        
        String sql = "UPDATE teachers SET department_id = ? WHERE person_id = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, teacher.getDepartmentId());
            stmt.setInt(2, teacher.getPersonId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Teacher teacher){
        System.out.println("Deleting teacher");
    }

}
