package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String studentId);
    Student getStudent(String studentId);
    List<Student> getAllStudents();

}
