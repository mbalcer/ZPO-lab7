package pl.mbalcer.lab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mbalcer.lab7.dto.CreateTaskDTO;
import pl.mbalcer.lab7.dto.TaskDTO;
import pl.mbalcer.lab7.entity.Task;
import pl.mbalcer.lab7.mapper.TaskMapper;
import pl.mbalcer.lab7.service.TaskService;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("/tasks/{taskId}")
    public TaskDTO getTask(@PathVariable long taskId) {
        Task task = taskService.getTask(taskId);
        return taskMapper.toDTO(task);
    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody CreateTaskDTO taskDTO) {
        Task task = taskMapper.fromDTO(taskDTO);
        taskService.createTask(task);
    }
}
