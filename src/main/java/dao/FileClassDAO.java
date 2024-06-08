package dao;

import model.SchoolClass;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class FileClassDAO implements ClassDAO {

    private List<SchoolClass> classes;

    public FileClassDAO() {

        classes = FileUtil.loadClasses(); // Ensure FileUtil has loadClasses method
    }
    @Override
    public void addClass(SchoolClass cls) {
        classes.add(cls);
        FileUtil.saveClasses(classes);
    }

    @Override
    public void updateClass(SchoolClass cls) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getClass().equals(cls.getClass())) {
                classes.set(i, cls);
                break;
            }
        }
        FileUtil.saveClasses(classes);
    }

    @Override
    public void deleteClass(String classId) {
        classes.removeIf(cls -> cls.getClass().equals(classId));
        FileUtil.saveClasses(classes);
    }

    @Override
    public SchoolClass getClass(String classId) {

        return classes.stream()
                .filter(cls -> cls.getClass().equals(classId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<SchoolClass> getAllClasses() {

        return new ArrayList<>(classes);
    }
}
