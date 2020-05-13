package com.acepirit.todo.acepirittodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acepirit.todo.acepirittodo.entity.Boards;

public interface BoardsRepository extends JpaRepository<Boards, Integer> {

}
