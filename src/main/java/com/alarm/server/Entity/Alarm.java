package com.alarm.server.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alarm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String id_card;
	private String location;
	private String description;
	private String path;
	private int type;

	public Alarm() {
		super();
	}

	public Alarm(String id_card, String location, String description, int type) {
		super();
		this.id_card = id_card;
		this.location = location;
		this.description = description;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
