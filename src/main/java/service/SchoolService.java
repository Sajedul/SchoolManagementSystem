package service;

import dao.*;
import model.SchoolClass;
import model.Staff;
import model.Student;

import java.util.List;

public class SchoolService {
    private StudentDAO studentDAO;
    private StaffDAO staffDAO;
    private ClassDAO classDAO;

    public SchoolService(StudentDAO studentDAO, StaffDAO staffDAO, ClassDAO classDAO) {
        this.studentDAO = studentDAO;
        this.staffDAO = staffDAO;
        this.classDAO = classDAO;
    }

    public void enrollStudent(Student student) {

        studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents() {

        return studentDAO.getAllStudents();
    }

    public void hireStaff(Staff staff) {

        staffDAO.addStaff(staff);
    }
    public List<Staff> getAllStaff() {

        return staffDAO.getAllStaff();
    }


    // Methods for classes
    public void createClass(SchoolClass cls) {

        classDAO.addClass(cls);
    }

    public List<SchoolClass> getAllClasses() {

        return classDAO.getAllClasses();
    }

}
