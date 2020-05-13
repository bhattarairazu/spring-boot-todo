package com.acepirit.todo.acepirittodo.service;

import java.util.List;

import com.acepirit.todo.acepirittodo.entity.Comment;
import com.acepirit.todo.acepirittodo.entity.Task;

public interface CommentService {
	
	public void save(Comment comment);
	
	public void deleteById(int id);
	
	public List<Comment> findAll();
	
	public Comment findById(int id);
	
	public List<Comment> findAllByTask(Task task);
	

}
