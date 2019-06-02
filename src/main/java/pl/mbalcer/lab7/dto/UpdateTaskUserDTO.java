package pl.mbalcer.lab7.dto;

import pl.mbalcer.lab7.entity.User;

public class UpdateTaskUserDTO {
    private long id;
    private User user;

    public UpdateTaskUserDTO(long id, User user) {
        this.id = id;
        this.user = user;
    }

    public UpdateTaskUserDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
