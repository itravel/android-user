package demo.travel.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.itravel.server.interfaces.dal.IUser;

public class User implements IUser{
	private long id;
	private String userName;
	private String email;
	private String password;
	private String avatar;
	private String cellPhone;
	private int qq;
	private String weibo;
	private Integer province;
	private int city;
	private int district;
	private double longitude;
	private double latitude;
	@Override
	public String getAvatar() {
		// TODO Auto-generated method stub
		return this.avatar;
	}
	@Override
	public String getCellPhone() {
		// TODO Auto-generated method stub
		return this.cellPhone;
	}
	@Override
	public int getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}
	@Override
	public int getDistrict() {
		// TODO Auto-generated method stub
		return this.district;
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
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
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public int getProvince() {
		// TODO Auto-generated method stub
		return this.province;
	}
	@Override
	public int getQq() {
		// TODO Auto-generated method stub
		return this.qq;
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	@Override
	public String getWeibo() {
		// TODO Auto-generated method stub
		return this.weibo;
	}
	@Override
	public void setAvatar(String avatar) {
		// TODO Auto-generated method stub
		this.avatar = avatar;
	}
	@Override
	public void setCellPhone(String cellPhone) {
		// TODO Auto-generated method stub
		this.cellPhone = cellPhone;
		
	}
	@Override
	public void setCity(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setDistrict(int district) {
		// TODO Auto-generated method stub
		this.district = district;
	}
	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
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
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	@Override
	public void setProvince(int province) {
		// TODO Auto-generated method stub
		this.province = province;
	}
	@Override
	public void setQq(int qq) {
		// TODO Auto-generated method stub
		this.qq = qq;
	}
	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}
	@Override
	public void setWeibo(String weibo) {
		// TODO Auto-generated method stub
		this.weibo = weibo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}

	

}
