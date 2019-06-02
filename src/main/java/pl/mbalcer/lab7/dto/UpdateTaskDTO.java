package pl.mbalcer.lab7.dto;

import pl.mbalcer.lab7.enumType.TaskStatus;
import pl.mbalcer.lab7.enumType.TaskType;

import java.time.LocalDate;

public class UpdateTaskDTO {
    private long id;
    private String title;
    private LocalDate createDate;
    private TaskType type;
    private TaskStatus status;

    public UpdateTaskDTO(long id, String title, LocalDate createDate, TaskType type, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.createDate = createDate;
        this.type = type;
        this.status = status;
    }

    public UpdateTaskDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
