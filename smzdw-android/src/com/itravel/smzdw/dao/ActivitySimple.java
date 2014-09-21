package com.itravel.smzdw.dao;

import java.util.List;

import com.google.common.base.MoreObjects;

public class ActivitySimple {
	private long id;
	private String title;
	private List<String> images;
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
	
	public String getStart() {
		return start;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
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
		return MoreObjects.toStringHelper(this).add("id", id).add("title", title).add("images", images).toString();
	}
}
