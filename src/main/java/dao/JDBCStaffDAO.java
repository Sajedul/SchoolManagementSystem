package dao;

import model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCStaffDAO implements StaffDAO {

    private final String url = "jdbc:mysql://localhost:3306/schooldb";
    private final String user = "root";
    private final String password = "mysql";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    @Override
    public void addStaff(Staff staff) {
        String sql = "INSERT INTO staff (staff_id, name, position, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getStaffId());
            pstmt.setString(2, staff.getName());
            pstmt.setString(3, staff.getPosition());
            pstmt.setDouble(4, staff.getSalary());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        String sql = "UPDATE staff SET name = ?, position = ?, salary = ? WHERE staff_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getName());
            pstmt.setString(2, staff.getPosition());
            pstmt.setDouble(3, staff.getSalary());
            pstmt.setString(4, staff.getStaffId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStaff(String staffId) {
        String sql = "DELETE FROM staff WHERE staff_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Staff getStaff(String staffId) {

        String sql = "SELECT * FROM staff WHERE staff_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Staff(
                        rs.getString("staff_id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Staff> getAllStaff() {

        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM staff";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                staffList.add(new Staff(
                        rs.getString("staff_id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
