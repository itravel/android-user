package demo.travel.models;

import java.util.Collection;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.itravel.server.interfaces.dal.ITravelNote;

public class TravelNote implements ITravelNote {

	private String userName;
	private String userAvatar;
	private String title;
	private int province;
	private double longitude;
	private double latitude;
	private long id;
	private String destination;
	private String content;
	private int city;
	private long userId;
	private Collection<String> pictures = Sets.newHashSet();

	@Override
	public void addPicture(String picture) {
		// TODO Auto-generated method stub
		this.pictures.add(picture);
	}

	@Override
	public int getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return this.content;
	}

	@Override
	public String getDestination() {
		// TODO Auto-generated method stub
		return this.destination;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public Collection<String> getPictures() {
		return this.pictures;
	}

	@Override
	public int getProvince() {
		// TODO Auto-generated method stub
		return this.province;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public String getUserAvatar() {
		// TODO Auto-generated method stub
		return this.userAvatar;
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return this.userId;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public void setCity(int city) {
		// TODO Auto-generated method stub
		this.city = city;
	}

	@Override
	public void setContent(String content) {
		// TODO Auto-generated method stub
		this.content = content;
	}

	@Override
	public void setDestination(String destination) {
		// TODO Auto-generated method stub
		this.destination = destination;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public void setLatitude(double latitude) {
		// TODO Auto-generated method stub
		this.latitude = latitude;
	}

	@Override
	public void setLongitude(double longitude) {
		// TODO Auto-generated method stub
		this.longitude = longitude;
	}

	@Override
	public void setPictures(String... pics) {
		// TODO Auto-generated method stub
		this.pictures = Sets.newHashSet(pics);
	}

	@Override
	public void setProvince(int province) {
		// TODO Auto-generated method stub
		this.province = province;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

	@Override
	public void setUserAvatar(String userAvatar) {
		// TODO Auto-generated method stub
		this.userAvatar = userAvatar;
	}

	@Override
	public void setUserId(long userId) {
		// TODO Auto-generated method stub
		this.userId = userId;
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}

}
