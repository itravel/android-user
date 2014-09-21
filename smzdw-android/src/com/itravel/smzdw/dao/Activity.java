package com.itravel.smzdw.dao;

import java.util.List;

import com.google.common.base.MoreObjects;



public class Activity {
	private long id;
	private String title;
	private String content;
	private String startTime;
	private String endTime;
	private String depart;
	private String destination;
	private String scenerySpot;
	private String contact;
	private String sponsor;
	private String recommender;
	private String image;
	private List<ActivityJourney> journey;
	
	private String tips;
//	private List<String> images;
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("title", title).add("journey", journey).toString();
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getScenerySpot() {
		return scenerySpot;
	}
	public void setScenerySpot(String scenerySpot) {
		this.scenerySpot = scenerySpot;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getRecommender() {
		return recommender;
	}
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<ActivityJourney> getJourney() {
		return journey;
	}
	public void setJourney(List<ActivityJourney> journey) {
		this.journey = journey;
	}
}
