package util;

import model.SchoolClass;
import model.Staff;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String STUDENT_FILE = "src/students.text";
    private static final String STAFF_FILE_PATH = "src/staff.txt";
    private static final String CLASS_FILE_PATH = "src/classes.txt";

    // Methods to load and save classes
    public static List<SchoolClass> loadClasses() {
        List<SchoolClass> classes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CLASS_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    SchoolClass cls = new SchoolClass(parts[0], parts[1], parts[2]);
                    classes.add(cls);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }

    public static void saveClasses(List<SchoolClass> classes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CLASS_FILE_PATH))) {
            for (SchoolClass cls : classes) {
                bw.write(String.format("%s,%s,%s", cls.getClassId(), cls.getName(), cls.getTeacherId()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENT_FILE))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methods to load and save staff
    public static List<Staff> loadStaff() {
        List<Staff> staffList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(STAFF_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Staff staff = new Staff(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                    staffList.add(staff);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public static void saveStaff(List<Staff> staffList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STAFF_FILE_PATH))) {
            for (Staff staff : staffList) {
                bw.write(String.format("%s,%s,%s,%.2f", staff.getStaffId(), staff.getName(), staff.getPosition(), staff.getSalary()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
