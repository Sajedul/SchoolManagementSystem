package model;

public class Staff {
    private String staffId;
    private String name;
    private String position;

    private double salary;

    public Staff(String staffId, String name, String position, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getStaffId() {

        return staffId;
    }

    public void setStaffId(String staffId) {

        this.staffId = staffId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {

        return position;
    }

    public void setPosition(String position) {

        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

}
