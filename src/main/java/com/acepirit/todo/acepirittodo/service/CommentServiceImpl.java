package com.acepirit.todo.acepirittodo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acepirit.todo.acepirittodo.entity.Comment;
import com.acepirit.todo.acepirittodo.entity.Task;
import com.acepirit.todo.acepirittodo.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentRepository commentRepository;
	
	@Autowired
	public CommentServiceImpl(CommentRepository commentrepository) {
		commentRepository = commentrepository;
	}

	@Override
	public void save(Comment comment) {
		
		commentRepository.save(comment);

	}

	@Override
	public void deleteById(int id) {
		commentRepository.deleteById(id);

	}

	@Override
	public List<Comment> findAll() {
		List<Comment> allComment = commentRepository.findAll();
		return allComment;
	}

	@Override
	public Comment findById(int id) {
		Optional<Comment> result = commentRepository.findById(id);
		Comment comment = null;
		if(result.isPresent()) {
			comment = result.get();
			
		}else {
			throw new RuntimeException("No Comment found with id:"+id);
		}
		return comment;
	}

	@Override
	public List<Comment> findAllByTask(Task task) {
		List<Comment> commentlist = commentRepository.findAllByTask(task);
		return commentlist;
	}

}
