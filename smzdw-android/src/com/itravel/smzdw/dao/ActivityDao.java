package com.itravel.smzdw.dao;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ActivityDao {
	private static final String LIST_REQUEST_PATH = "/services/activities";
	private static Gson gson = new Gson();
	
	public List<ActivitySimple> getActivities(int start,int number){
		
		NameValuePair paramStart = HttpClientHelper.getInstance().createQueryParam("start", start);
		NameValuePair paramNumber = HttpClientHelper.getInstance().createQueryParam("number", number);
		HttpResponse response = HttpClientHelper.getInstance().executeGet(LIST_REQUEST_PATH,Lists.newArrayList(paramStart,paramNumber));
		try {
			
			String jsonString = EntityUtils.toString(response.getEntity());
			return gson.fromJson(jsonString, new TypeToken<List<ActivitySimple>>(){}.getType());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Lists.newArrayList();
	}
	
	public Activity getActivity(long activityId){
		HttpResponse response = HttpClientHelper.getInstance().executeGet(LIST_REQUEST_PATH+"/"+activityId,null);
		try {
			
			String jsonString = EntityUtils.toString(response.getEntity());
			return gson.fromJson(jsonString, Activity.class);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
