package com.acepirit.todo.acepirittodo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acepirit.todo.acepirittodo.entity.Boards;
import com.acepirit.todo.acepirittodo.repository.BoardsRepository;

@Service
public class BoardsServiceImpl implements BoardsService {
	private BoardsRepository boardRepository;
	
	@Autowired
	public BoardsServiceImpl(BoardsRepository boardsrepository) {
		boardRepository = boardsrepository;
	}
	@Override
	public List<Boards> findAll() {
		// TODO Auto-generated method stub
		return boardRepository.findAll();
	}

	@Override
	public Boards findById(int id) {
		Optional<Boards> result = boardRepository.findById(id);
		Boards board = null;
		if(result.isPresent()) {
			board = result.get();
		}else {
			throw new RuntimeException("Board with id :"+id+" Not found");
		}
		
		return board;
	}

	@Override
	public void deleteById(int id) {

		boardRepository.deleteById(id);

	}

	@Override
	public void save(Boards board) {

		boardRepository.save(board);

	}

}
