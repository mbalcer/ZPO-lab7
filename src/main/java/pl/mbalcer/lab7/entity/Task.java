package pl.mbalcer.lab7.entity;

import pl.mbalcer.lab7.enumType.TaskStatus;
import pl.mbalcer.lab7.enumType.TaskType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDate createDate;
    private TaskType type;
    private TaskStatus status;

    @OneToMany
    private User user;

    public Task(String title, LocalDate createDate, TaskType type, TaskStatus status, User user) {
        this.title = title;
        this.createDate = createDate;
        this.type = type;
        this.status = status;
        this.user = user;
    }

    public Task() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", type=" + type +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
