package com.alarm.server.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emergency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String id_card;
	private String location;

	public Emergency(String id_card, String location) {
		super();
		this.id_card = id_card;
		this.location = location;
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

	public Integer getId() {
		return id;
	}

}
