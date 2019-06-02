package pl.mbalcer.lab7.dto;

public class CreateUserDTO {

    private String name;

    public CreateUserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
