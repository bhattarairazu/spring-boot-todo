package com.acepirit.todo.acepirittodo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acepirit.todo.acepirittodo.entity.Subtask;
import com.acepirit.todo.acepirittodo.entity.Task;

public interface SubtaskRepository extends JpaRepository<Subtask,Integer> {
	
	public List<Subtask> findByTask(Task task);
	

}
