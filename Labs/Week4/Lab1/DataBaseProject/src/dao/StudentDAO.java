package dao;

import entity.Student;

import java.util.List;

public interface StudentDAO extends BaseDAO<Integer, Student> {
    List<Student> findStudentByName(String patternName) throws DaoExeption;

}
