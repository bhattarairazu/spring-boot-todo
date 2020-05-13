package com.acepirit.todo.acepirittodo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acepirit.todo.acepirittodo.entity.Subtask;
import com.acepirit.todo.acepirittodo.entity.Task;
import com.acepirit.todo.acepirittodo.repository.SubtaskRepository;


@Service
public class SubtaskServiceImpl implements SubtaskService {
	
	private SubtaskRepository subtaskRepository;
	
	@Autowired
	public SubtaskServiceImpl(SubtaskRepository subtaskrepository) {
		subtaskRepository = subtaskrepository;
	}

	@Override
	public void save(Subtask subtask) {
		subtaskRepository.save(subtask);

	}

	@Override
	public void deleteById(int id) {
		subtaskRepository.deleteById(id);

	}

	@Override
	public List<Subtask> findAll() {
		List<Subtask> subtasklist = subtaskRepository.findAll();
		return subtasklist;
	}

	@Override
	public Subtask findById(int id) {
		Optional<Subtask> result = subtaskRepository.findById(id);
		Subtask subtask = null;
		if(result.isPresent()) {
			subtask = result.get();
		}else {
			throw new RuntimeException("Subtask with id :"+id+" Not Found");
		}
		return subtask;
	}

	@Override
	public List<Subtask> findByTask(Task task) {
		List<Subtask> subtasklist = subtaskRepository.findByTask(task);
		return subtasklist;
	}

}
