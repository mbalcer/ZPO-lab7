package pl.mbalcer.lab7.dto;

import pl.mbalcer.lab7.enumType.TaskStatus;
import pl.mbalcer.lab7.enumType.TaskType;

import java.time.LocalDate;

public class CreateTaskDTO {

    private String title;
    private LocalDate createDate;
    private TaskType type;
    private TaskStatus status;

    private long userId;

    public CreateTaskDTO() {
    }

    public CreateTaskDTO(String title, LocalDate createDate, TaskType type, TaskStatus status, long userId) {
        this.title = title;
        this.createDate = createDate;
        this.type = type;
        this.status = status;
        this.userId = userId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
