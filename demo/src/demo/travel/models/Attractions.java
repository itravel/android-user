package demo.travel.models;

import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.itravel.server.interfaces.dal.IAttractions;

public final class Attractions implements IAttractions {

	private String address;
	private int cityCode;
	private String description;
	private long id;
	private double latitude;
	private double longitude;
	private String name;
	private String pictures;

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}

	@Override
	public int getCityCode() {
		// TODO Auto-generated method stub
		return this.cityCode;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public double getLatitude() {
		// TODO Auto-generated method stub
		return this.latitude;
	}

	@Override
	public double getLongitude() {
		// TODO Auto-generated method stub
		return this.longitude;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Collection<String> getPictures() {
		// TODO Auto-generated method stub
		if(this.pictures == null || this.pictures == ""){
			return Sets.newHashSet();
		}
		return Sets.newHashSet(this.pictures.split(","));
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address = address;
	}

	@Override
	public void setCityCode(int cityCode) {
		// TODO Auto-generated method stub
		this.cityCode = cityCode;
	}


	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
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
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setPictures(Collection<String> pictures) {
		// TODO Auto-generated method stub
		this.pictures = Joiner.on(",").join(pictures);
	}
	
	public void addPicture(String picture){
		Collection<String> pics = this.getPictures();
		pics.add(picture);
		this.pictures = Joiner.on(",").join(pics);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}

}
