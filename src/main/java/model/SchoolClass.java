package model;

public class SchoolClass {
    private String classId;
    private String name;
    private String teacherId;

    // Constructor
    public SchoolClass(String classId, String name, String teacherId) {
        this.classId = classId;
        this.name = name;
        this.teacherId = teacherId;
    }

    // Getter methods
    public String getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    // Setter methods (if needed)
    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }


    @Override
    public String toString() {
        return "SchoolClass{" +
                "classId=" + classId + '\'' +
                ", name=" + name + '\'' +
                ", teacherId=" + teacherId + '\'' +
                '}';
    }

}
