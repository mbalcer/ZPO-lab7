package pl.mbalcer.lab7.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mbalcer.lab7.dto.CreateTaskDTO;
import pl.mbalcer.lab7.dto.CreateUserDTO;
import pl.mbalcer.lab7.dto.TaskDTO;
import pl.mbalcer.lab7.entity.Task;
import pl.mbalcer.lab7.entity.User;
import pl.mbalcer.lab7.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    public TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getTitle(), task.getCreateDate(), task.getStatus(), task.getType(), userMapper.toDTO(task.getUser()));
    }

    public List<TaskDTO> toDTOs(List<Task> tasks) {
        return tasks.stream()
                .map(task -> toDTO(task))
                .collect(Collectors.toList());
    }

    public Task fromDTO(CreateTaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setCreateDate(taskDTO.getCreateDate());
        task.setType(taskDTO.getType());
        task.setStatus(taskDTO.getStatus());
        task.setUser(userService.getUser(taskDTO.getUserId()));
        return task;
    }
}
