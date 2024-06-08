package main;

import dao.*;
import model.SchoolClass;
import model.Staff;
import model.Student;
import service.SchoolService;

public class Main {
    public static void main(String[] args) {

        // Use JDBC-based DAO
        JDBCClassDAO classDAO = new JDBCClassDAO();
        JDBCStudentDAO studentDAO = new JDBCStudentDAO();
        JDBCStaffDAO staffDAO=new JDBCStaffDAO();
        // Use file-based DAOs
        
        //FileStaffDAO staffDAO_Obj = new FileStaffDAO();
        //FileClassDAO classDAO_Obj= new FileClassDAO();
        //FileStudentDAO studentDAO_Obj= new FileStudentDAO();


        SchoolService schoolService = new SchoolService(studentDAO, staffDAO, classDAO);
        studentDAO.clearTables();

        // Example usage for classes
        SchoolClass newClass = new SchoolClass("C001", "Math 101", "T001");
        classDAO.addClass(newClass);

        // Example usage for student
        Student student = new Student("S001", "John Doe", 20, "A");
        schoolService.enrollStudent(student);
        // Example usage for staff
        Staff staff = new Staff("T001", "Alice Smith", "Teacher", 50000);
        staffDAO.addStaff(staff);

        System.out.println(classDAO.getAllClasses());
        System.out.println(studentDAO.getAllStudents());
        System.out.println(staffDAO.getAllStaff());
    }

}

