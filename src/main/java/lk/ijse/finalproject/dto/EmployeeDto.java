package lk.ijse.finalproject.dto;

public class EmployeeDto {
    private  String employee_id;
    private  String name;
    private String nic;
    private String number;
    private String role;

    public EmployeeDto(String employee_id, String name, String nic, String number, String role) {
        this.employee_id = employee_id;
        this.name = name;
        this.nic = nic;
        this.number = number;
        this.role = role;
    }

    public String getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employee_id='" + employee_id + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", number='" + number + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
