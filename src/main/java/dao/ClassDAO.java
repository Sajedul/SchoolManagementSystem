package dao;

import model.SchoolClass;

import java.util.List;

public interface ClassDAO {
    void addClass(SchoolClass cls);
    void updateClass(SchoolClass cls);
    void deleteClass(String classId);
    SchoolClass getClass(String classId);
    List<SchoolClass> getAllClasses();
}
