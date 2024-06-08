package dao;

import model.Staff;

import java.util.List;

public interface StaffDAO {
    void addStaff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(String staffId);
    Staff getStaff(String staffId);
    List<Staff> getAllStaff();
}
