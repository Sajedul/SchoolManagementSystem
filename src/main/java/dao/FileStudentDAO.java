package dao;

import model.Student;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class FileStudentDAO implements StudentDAO {
    private List<Student> students;

    public FileStudentDAO() {
        students = FileUtil.loadStudents(); // Save to file after adding
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
        FileUtil.saveStudents(students);
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(student.getStudentId())) {
                students.set(i, student); // Update the student
                break;
            }
        }
        FileUtil.saveStudents(students); // Save to file after updating
    }

    @Override
    public void deleteStudent(String studentId) {

        students.removeIf(student -> student.getStudentId().equals(studentId));
        FileUtil.saveStudents(students);
    }

    @Override
    public Student getStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {

        return new ArrayList<>(students);// Return the list of students
    }
}
