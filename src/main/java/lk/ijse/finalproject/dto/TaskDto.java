package lk.ijse.finalproject.dto;

public class TaskDto {

    private String task_id;
    private String employee_id;
    private String description;
    private String status;

    public TaskDto(String task_id, String employee_id,
                   String description, String status) {
        this.task_id = task_id;
        this.employee_id = employee_id;
        this.description = description;
        this.status = status;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "task_id='" + task_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
