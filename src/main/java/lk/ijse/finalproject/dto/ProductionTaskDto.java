package lk.ijse.finalproject.dto;

public class ProductionTaskDto {

    private String production_task_id;
    private String production_id;
    private String task_id;

    public ProductionTaskDto(String production_task_id, String production_id, String task_id) {
        this.production_task_id = production_task_id;
        this.production_id = production_id;
        this.task_id = task_id;
    }

    public String getProduction_task_id() {
        return production_task_id;
    }

    public void setProduction_task_id(String production_task_id) {
        this.production_task_id = production_task_id;
    }

    public String getProduction_id() {
        return production_id;
    }

    public void setProduction_id(String production_id) {
        this.production_id = production_id;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "ProductionTaskDto{" +
                "production_task_id='" + production_task_id + '\'' +
                ", production_id='" + production_id + '\'' +
                ", task_id='" + task_id + '\'' +
                '}';
    }

}
