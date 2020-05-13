package com.acepirit.todo.acepirittodo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acepirit.todo.acepirittodo.entity.Boards;
import com.acepirit.todo.acepirittodo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	public List<Task> findAllByBoards(Boards board);
	
	@Query("SELECT t FROM Task t WHERE t.boards=?1 AND t.type=?2")
	public List<Task> findAllByBoardsANDType(Boards boards,String type);
}
