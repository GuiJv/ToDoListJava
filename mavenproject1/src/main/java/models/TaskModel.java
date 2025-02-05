package models;

public class TaskModel {
    private int id;
    private String taskName;
    private String taskType;
    private boolean isDone;

    public TaskModel(int id, String taskName, String taskType, boolean isDone) {
        this.id = id;
        this.taskName = taskName;
        this.taskType = taskType;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
    @Override
    public String toString() {
    return "TaskModel{" +
           "id=" + id +
           ", taskName='" + taskName + '\'' +
           ", taskType='" + taskType + '\'' +
           ", isDone=" + isDone +
           '}';
}
}