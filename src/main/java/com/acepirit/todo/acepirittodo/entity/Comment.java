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
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="created_at",columnDefinition = "DATETIME")
	private Date created_at;
	
	@Column(name="comments")
	private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="task_id",referencedColumnName = "id")
	private Task task;
	
	public Comment() {}
	
	public Comment(int id, int user_id, Date created_at, String comment, Task task) {
		
		this.id = id;
		this.user_id = user_id;
		this.created_at = created_at;
		this.comment = comment;
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	
	

}
