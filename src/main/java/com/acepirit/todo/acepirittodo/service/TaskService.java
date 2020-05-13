package com.acepirit.todo.acepirittodo.service;

import java.util.List;

import com.acepirit.todo.acepirittodo.entity.Boards;
import com.acepirit.todo.acepirittodo.entity.Task;

public interface TaskService {

		public List<Task> findAll();
		
		public void save(Task task);
		
		public Task findById(int id);
		
		public void deleteById(int id);
		
		public List<Task> findAllByBoards(Boards board);
		
		public List<Task> findAllByBoardsANDType(Boards boards,String type);
}
