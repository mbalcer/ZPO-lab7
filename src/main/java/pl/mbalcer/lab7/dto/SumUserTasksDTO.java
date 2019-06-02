package pl.mbalcer.lab7.dto;

import pl.mbalcer.lab7.entity.User;

public class SumUserTasksDTO {
    private User user;
    private long sumTasks;

    public SumUserTasksDTO() {
    }

    public SumUserTasksDTO(User user, long sumTasks) {
        this.user = user;
        this.sumTasks = sumTasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getSumTasks() {
        return sumTasks;
    }

    public void setSumTasks(long sumTasks) {
        this.sumTasks = sumTasks;
    }
}
