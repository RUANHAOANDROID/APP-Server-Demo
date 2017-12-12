package com.alarm.server.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 可疑媒情-媒体
 * 
 * @author hao.ruan
 *
 */
@Entity
public class Suspicious {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String id_card;
	private int type;
	private String description;
	private String imagepath;
	private String videopath;
	private String location;

	public Suspicious() {
		super();
	}

	public Suspicious(String id_card, String location, int type, String description) {
		super();
		this.id_card = id_card;
		this.type = type;
		this.description = description;
		this.location = location;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getVidopath() {
		return videopath;
	}

	public void setVidopath(String vidopath) {
		this.videopath = vidopath;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
