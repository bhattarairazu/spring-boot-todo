package com.acepirit.todo.acepirittodo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acepirit.todo.acepirittodo.entity.Comment;
import com.acepirit.todo.acepirittodo.entity.Task;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	public List<Comment> findAllByTask(Task task);
	

}
