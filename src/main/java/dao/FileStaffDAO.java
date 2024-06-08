package dao;

import model.Staff;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class FileStaffDAO implements StaffDAO {

    private List<Staff> staff;
    public FileStaffDAO() {

        staff = FileUtil.loadStaff(); // Ensure FileUtil has loadStaff method
    }
    @Override
    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
        FileUtil.saveStaff(staff);
    }

    @Override
    public void updateStaff(Staff staffMember) {
        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).getStaffId().equals(staffMember.getStaffId())) {
                staff.set(i, staffMember);
                break;
            }
        }
        FileUtil.saveStaff(staff);
    }

    @Override
    public void deleteStaff(String staffId) {
        staff.removeIf(staffMember -> staffMember.getStaffId().equals(staffId));
        FileUtil.saveStaff(staff);
    }

    @Override
    public Staff getStaff(String staffId) {

        return staff.stream()
                .filter(staffMember -> staffMember.getStaffId().equals(staffId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Staff> getAllStaff() {

        return new ArrayList<>(staff);
    }
}
