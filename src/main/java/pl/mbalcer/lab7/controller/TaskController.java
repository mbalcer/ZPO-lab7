package pl.mbalcer.lab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mbalcer.lab7.dto.CreateTaskDTO;
import pl.mbalcer.lab7.dto.TaskDTO;
import pl.mbalcer.lab7.dto.UpdateTaskDTO;
import pl.mbalcer.lab7.dto.UpdateTaskUserDTO;
import pl.mbalcer.lab7.entity.Task;
import pl.mbalcer.lab7.enumType.TaskStatus;
import pl.mbalcer.lab7.enumType.TaskType;
import pl.mbalcer.lab7.mapper.TaskMapper;
import pl.mbalcer.lab7.service.TaskService;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/tasks/user/{userId}")
    public List<TaskDTO> getTasksByUser(@PathVariable long userId) {
        List<Task> tasks = taskService.getTasks()
                .stream()
                .filter(task -> task.getUser().getId()==userId)
                .collect(Collectors.toList());

        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/user/{userId}/status/{status}")
    public List<TaskDTO> getTasksByStatusAndUser(@PathVariable String status, @PathVariable long userId) {
        TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase());
        List<Task> tasks = taskService.getTasks()
                .stream()
                .filter(task -> task.getUser().getId()==userId)
                .filter(task -> task.getStatus()==taskStatus)
                .collect(Collectors.toList());

        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/user/{userId}/type/{type}")
    public List<TaskDTO> getTasksByTypeAndUser(@PathVariable String type, @PathVariable long userId) {
        TaskType taskType = TaskType.valueOf(type.toUpperCase());
        List<Task> tasks = taskService.getTasks()
                .stream()
                .filter(task -> task.getUser().getId()==userId)
                .filter(task -> task.getType()==taskType)
                .collect(Collectors.toList());

        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/user/{userId}/status/{status}/type/{type}")
    public List<TaskDTO> getTasksByTypeAndStatusAndUser(@PathVariable String status, @PathVariable String type, @PathVariable long userId) {
        TaskType taskType = TaskType.valueOf(type.toUpperCase());
        TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase());
        List<Task> tasks = taskService.getTasks()
                .stream()
                .filter(task -> task.getUser().getId()==userId)
                .filter(task -> task.getType()==taskType)
                .filter(task -> task.getStatus()==taskStatus)
                .collect(Collectors.toList());

        return taskMapper.toDTOs(tasks);
    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody CreateTaskDTO taskDTO) {
        Task task = taskMapper.fromDTO(taskDTO);
        taskService.createTask(task);
    }

    @PutMapping("/tasks/{taskId}")
    public void updateTask(@RequestBody UpdateTaskDTO taskDTO, @PathVariable long taskId) {
        Task taskFromDb = taskService.getTask(taskId);
        if (taskFromDb != null) {
            Task task = taskMapper.fromDTO(taskDTO);
            task.setId(taskId);
            task.setUser(taskFromDb.getUser());
            taskService.updateTask(task);
        }
    }

    @PutMapping("/tasks/{taskId}/user")
    public void updateTaskByUser(@RequestBody UpdateTaskUserDTO taskDTO, @PathVariable long taskId) {
        Task taskFromDb = taskService.getTask(taskId);
        if(taskFromDb != null) {
            Task task = taskMapper.fromDTO(taskDTO);
            task.setId(taskId);
            task.setTitle(taskFromDb.getTitle());
            task.setCreateDate(taskFromDb.getCreateDate());
            task.setStatus(taskFromDb.getStatus());
            task.setType(taskFromDb.getType());
            taskService.updateTask(task);
        }
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable long taskId) {
        taskService.deleteTask(taskId);
    }

}
