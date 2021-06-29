package com.codingdojo.beltexam.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexam.models.Task;
import com.codingdojo.beltexam.repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	// create a task
	public Task createTask(Task myTask) {
		return taskRepository.save(myTask);
	}
	// get all tasks and return as a List<Task>
	public List<Task> getAll() {
		return (List<Task>) taskRepository.findAll();
	}
	// find a task by id
	public Task findTask(Long id) {
		Optional<Task> mytask = taskRepository.findById(id);
		if (mytask.isPresent()) {
			return mytask.get();
		}else {
			System.out.println("no task you are looking for");
			return null;
		}
	}
	// Delete task
	public void deleteTask(Long myId) {
		taskRepository.deleteById(myId);
	}
	// Update task
	public void updateTask(Task myTask) {
		taskRepository.save(myTask);
	}
	//List all tasks by ASC priority
	public List<Task> lowToHigh(){
		return taskRepository.findAllPriorityLowToHigh();
	}
	//List all Tasks by DESC priority
	
	public List<Task> highToLow(){
		return taskRepository.findAllPriorityHighToLow();
	}
	
}
