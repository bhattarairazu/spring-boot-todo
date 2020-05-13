package com.acepirit.todo.acepirittodo.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boards")
public class Boards {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="created_at",columnDefinition="DATETIME")
	private Date created_at;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="images")
	private String images;
	
	public Boards() {}

	
	public Boards(int id, String name, Date created_at, int user_id, String images) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.user_id = user_id;
		this.images = images;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	

}
