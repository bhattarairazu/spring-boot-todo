package com.acepirit.todo.acepirittodo.service;

import java.util.List;

import com.acepirit.todo.acepirittodo.entity.Boards;

public interface BoardsService {
	public List<Boards> findAll();
	
	public Boards findById(int id);
	
	public void deleteById(int id);
	
	public void save(Boards board);
}
