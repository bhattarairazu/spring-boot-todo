package com.acepirit.todo.acepirittodo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acepirit.todo.acepirittodo.entity.Boards;
import com.acepirit.todo.acepirittodo.entity.Task;
import com.acepirit.todo.acepirittodo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	public TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskrepository) {
		taskRepository = taskrepository;
	}
	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public void save(Task task) {
		taskRepository.save(task);
		
	}

	@Override
	public Task findById(int id) {
		// TODO Auto-generated method stub
		Optional<Task> result = taskRepository.findById(id);
		Task tasks = null;
		if(result.isPresent()) {
			tasks = result.get();
			
		}else {
			throw new RuntimeException("Task with id:"+id+"No found");
		}
		return tasks;
	}

	@Override
	public void deleteById(int id) {
		
		taskRepository.deleteById(id);
		

	}
	@Override
	public List<Task> findAllByBoards(Boards boards) {
		// TODO Auto-generated method stub
		return taskRepository.findAllByBoards(boards);
		//return null;
	}
	@Override
	public List<Task> findAllByBoardsANDType(Boards boards, String type) {
		// TODO Auto-generated method stub
		return taskRepository.findAllByBoardsANDType(boards, type);
	}

}
