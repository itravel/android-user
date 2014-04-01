package demo.travel.daos;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itravel.server.interfaces.dal.IAttractions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import demo.travel.common.AsyncHttpClientFactory;
import demo.travel.common.Constants;
import demo.travel.common.ObjectMapperFactory;
import demo.travel.models.Attractions;

public final class AttractionsDao {
	private static final class AttractionsDaoHolder {
		private static final AttractionsDao INSTANCE = new AttractionsDao();
	}
	
	private static final String ATTRACTIONS_URI = "/services/attractions";
	private static final String AROUND_ATTRACTIONS_URI = "/services/around/attractions";
	private final AsyncHttpClient asyncHttpClient = AsyncHttpClientFactory.create();
	private final ObjectMapper mapper = ObjectMapperFactory.create(); 
	
	public static IAttractions create(){
		return new Attractions();
	}
	
	public static IAttractions create(String json){
		throw new UnsupportedOperationException();
	}
	
	private AttractionsDao () {
	}
	/**
	 * 根据经纬度查询周边景点
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
		asyncHttpClient.get(Constants.ROOT_URI+AROUND_ATTRACTIONS_URI, params, asyncHttpResponseHandler);
	}
	/**
	 * 根据景点ID查询景点信息
	 * @param attractionsId
	 * @param asyncHttpResponseHandler
	 */
	public void getAttractionById(int attractionsId,AsyncHttpResponseHandler asyncHttpResponseHandler){
		asyncHttpClient.get(Constants.ROOT_URI+ATTRACTIONS_URI+"/"+attractionsId, null, asyncHttpResponseHandler);
	}
	/**
	 * 根据城市代码查询景点信息
	 * @param city
	 * @param start
	 * @param asyncHttpResponseHandler
	 */
	public void getAttractionsByCity(int city,int start,AsyncHttpResponseHandler asyncHttpResponseHandler){
		RequestParams params = new RequestParams();
		params.put("queryBy", "city");
		params.put("city", city);
		params.put("acount", start);
		params.put("count", 20);
		asyncHttpClient.get(Constants.ROOT_URI+ATTRACTIONS_URI, params, asyncHttpResponseHandler);
	}
}
