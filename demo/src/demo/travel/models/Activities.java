package demo.travel.models;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.itravel.server.interfaces.dal.IActivities;
import com.itravel.server.interfaces.dal.IUser;

public class Activities implements IActivities {

	private String pictures;
	private double longitude;
	private String name;
	private String userName;
	private long userId;
	private String userAvatar;
	private int status;
	private Date startTime;
	private double latitude;
	private long id;
	private Date endTime;
	private String description;
	private Collection<IUser> users = Sets.newConcurrentHashSet();

	@Override
	public void addActivitiesPic(String pic) {
		// TODO Auto-generated method stub
		Collection<String> pics = this.getActivitiesPics();
		pics.add(pic);
		this.pictures = Joiner.on(",").join(pics);
	}

	@Override
	public void addActivitiesPics(String... pics) {
		// TODO Auto-generated method stub
		for(String pic:pics){
			this.addActivitiesPic(pic);
		}
	}

	@Override
	public void addUser(IUser user) {
		// TODO Auto-generated method stub
		this.users.add(user);
	}

	@Override
	public Collection<String> getActivitiesPics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public Date getEndTime() {
		// TODO Auto-generated method stub
		return this.endTime;
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
	public Date getStartTime() {
		// TODO Auto-generated method stub
		return this.startTime;
	}

	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return this.status;
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
	public Collection<IUser> getUsers() {
		// TODO Auto-generated method stub
		return this.users ;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
	}

	@Override
	public void setEndTime(Date endTime) {
		// TODO Auto-generated method stub
		this.endTime = endTime;
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
		this.longitude  = longitude;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setStartTime(Date startTime) {
		// TODO Auto-generated method stub
		this.startTime = startTime;
	}

	@Override
	public void setStatus(int status) {
		// TODO Auto-generated method stub
		this.status = status;
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

	@Override
	public void setUsers(Collection<IUser> users) {
		// TODO Auto-generated method stub
		this.users = Sets.newConcurrentHashSet(users);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}

}
