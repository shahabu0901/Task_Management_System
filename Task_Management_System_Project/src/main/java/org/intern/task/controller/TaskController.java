package org.intern.task.controller;

import java.util.List;

import org.intern.task.Dto.Task;
import org.intern.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping()
	public Task SaveTask(@RequestBody Task task) {
		return taskService.SaveTask(task);
	}

	@PutMapping("/{id}")
	public Task UpdateTask(@PathVariable Long id, @RequestBody Task task) {
		return taskService.updateTask(id, task);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Task> FindAllTasks() {
		return taskService.getAllTasks();
	}
}
