package org.intern.task.service;

import java.util.List;

import org.intern.task.Dto.Task;
import org.intern.task.Repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task SaveTask(Task task) {
		return taskRepository.save(task);
	}

	public Task updateTask(Long id, Task taskDetails) {
		Task task = taskRepository.findById(id).orElseThrow();

		task.setTitle(taskDetails.getTitle());
		task.setDescription(taskDetails.getDescription());
		task.setCompleted(taskDetails.isCompleted());

		return taskRepository.save(task);
	}

	public void deleteTask(Long id) {
		Task task = taskRepository.findById(id).orElseThrow();

		taskRepository.delete(task);

	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();

	}
}
