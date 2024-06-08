package dao;

import model.SchoolClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCClassDAO implements ClassDAO {
    private final String url = "jdbc:mysql://localhost:3306/schooldb";
    private final String user = "root";
    private final String password = "mysql";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addClass(SchoolClass cls) {
        String sql = "INSERT INTO classes (class_id, name, teacher_id) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cls.getClassId());
            pstmt.setString(2, cls.getName());
            pstmt.setString(3, cls.getTeacherId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClass(SchoolClass cls) {
        String sql = "UPDATE classes SET name = ?, teacher_id = ? WHERE class_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cls.getName());
            pstmt.setString(2, cls.getTeacherId());
            pstmt.setString(3, cls.getClassId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClass(String classId) {
        String sql = "DELETE FROM classes WHERE class_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, classId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SchoolClass getClass(String classId) {

        String sql = "SELECT * FROM classes WHERE class_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, classId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new SchoolClass(
                        rs.getString("class_id"),
                        rs.getString("name"),
                        rs.getString("teacher_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SchoolClass> getAllClasses() {

        List<SchoolClass> classes = new ArrayList<>();
        String sql = "SELECT * FROM classes";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                classes.add(new SchoolClass(
                        rs.getString("class_id"),
                        rs.getString("name"),
                        rs.getString("teacher_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
}
