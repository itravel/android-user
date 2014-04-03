package demo.travel.daos;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itravel.server.interfaces.dal.IActivities;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import demo.travel.common.AsyncHttpClientFactory;
import demo.travel.common.Constants;
import demo.travel.common.ObjectMapperFactory;
import demo.travel.models.Activities;

public final class ActivitiesDao {
	/*============================================================*/
	private static final class ActivitiesDaoHolder {
		private static final ActivitiesDao INSTANCE = new ActivitiesDao();
	}
	/*============================================================*/
	private final AsyncHttpClient asyncHttpClient = AsyncHttpClientFactory.create();
	private final ObjectMapper mapper = ObjectMapperFactory.create(); 
	private static final String ACTIVITIES_URI = "/services/activites";
	private static final String AROUND_ACTIVITIES_URI = "/services/around/activities";
	/*============================================================*/
	private ActivitiesDao(){
		
	}
	
	public static ActivitiesDao getInstance(){
		return ActivitiesDaoHolder.INSTANCE;
	}
	
	public static IActivities create(){
		return new Activities();
	}
	
	public static IActivities create(String json){
		try {
			final ObjectMapper mapper = ObjectMapperFactory.create();
			return mapper.readValue(json, Activities.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void getActivities(int start,int count,AsyncHttpResponseHandler asyncHttpResponseHandler){
		RequestParams params = new RequestParams();
		params.put("start", start);
		params.put("count", count);
		asyncHttpClient.get(Constants.ROOT_URI+ACTIVITIES_URI, params, asyncHttpResponseHandler);
	}
	/**
	 * 按照经纬度搜索
	 * @param latitude
	 * @param longitude
	 * @param start
	 * @param asyncHttpResponseHandler
	 */
	public void getAttractionsByLatLnt(double latitude,double longitude,int start,AsyncHttpResponseHandler asyncHttpResponseHandler){
		RequestParams params = new RequestParams();
		params.put("latitude", latitude);
		params.put("longitude", longitude);
		params.put("start", start);
		params.put("count", 20);
		asyncHttpClient.get(Constants.ROOT_URI+AROUND_ACTIVITIES_URI, params, asyncHttpResponseHandler);
	}
	
	public void save(IActivities activities,AsyncHttpResponseHandler asyncHttpResponseHandler){
		HttpEntity entity;
		try {
			entity = new StringEntity(mapper.writeValueAsString(activities));
			asyncHttpClient.post(null, Constants.ROOT_URI+ACTIVITIES_URI, entity, "application/json", asyncHttpResponseHandler);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
