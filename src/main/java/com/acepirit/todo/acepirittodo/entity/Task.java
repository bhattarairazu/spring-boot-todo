package com.acepirit.todo.acepirittodo.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
//	@Column(name="board_id")
//	private int boardId;
//	
	@Column(name="type")
	private String type;
	
	@Column(name="created_at",columnDefinition = "DATETIME")
	private Date created_at;
	
	@Column(name="description")
	private String description;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="board_id",referencedColumnName="id")
	private Boards boards;
	
	
	public Task() {
		
	}

	public Task(int id,String type, Date created_at, String description) {
	
		this.id = id;
		this.type = type;
		this.created_at = created_at;
		this.description = description;
	}

	public Boards getBoards() {
		return boards;
	}

	public void setBoards(Boards boards) {
		this.boards = boards;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
