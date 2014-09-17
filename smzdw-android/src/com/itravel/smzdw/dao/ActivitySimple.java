package com.itravel.smzdw.dao;

import com.google.common.base.MoreObjects;

public class ActivitySimple {
	private long id;
	private String title;
	private String image;
	private String start;
	private String end;
	private String scenerySpot;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getScenerySpot() {
		return scenerySpot;
	}
	public void setScenerySpot(String scenerySpot) {
		this.scenerySpot = scenerySpot;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("title", title).add("images", image).toString();
	}
}
