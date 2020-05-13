package com.acepirit.todo.acepirittodo.service;

import java.util.List;


import com.acepirit.todo.acepirittodo.entity.Subtask;
import com.acepirit.todo.acepirittodo.entity.Task;

public interface SubtaskService {
	
	public void save(Subtask subtask);
	
	public void deleteById(int id);
	
	public List<Subtask> findAll();
	
	public Subtask findById(int id);
	
	public List<Subtask> findByTask(Task task);

}
