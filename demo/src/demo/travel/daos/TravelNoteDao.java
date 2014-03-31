package demo.travel.daos;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;







import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itravel.server.interfaces.dal.ITravelNote;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import demo.travel.common.AsyncHttpClientFactory;
import demo.travel.common.Constants;
import demo.travel.common.ObjectMapperFactory;
import demo.travel.models.TravelNote;
/**
 * 
 * @author william.wangwm
 *	
 */
public final class TravelNoteDao  {
	private static final class TravelNoteDaoHolder {
		private static final TravelNoteDao INSTANCE = new TravelNoteDao();
	}
	private static final String TRAVEL_NOTE_URI = "/services/travelnotes";
	private final AsyncHttpClient asyncHttpClient = AsyncHttpClientFactory.create();
	private final ObjectMapper mapper = ObjectMapperFactory.create(); 
	
	public static TravelNoteDao newInstance(){
		return TravelNoteDaoHolder.INSTANCE;
	}
	public static ITravelNote create() {
		// TODO Auto-generated method stub
		return new TravelNote();
	}

	public static ITravelNote create(String json) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void get(long id,AsyncHttpResponseHandler asyncHttpResponseHandler) {
		asyncHttpClient.get(Constants.ROOT_URI+TRAVEL_NOTE_URI+"/"+id, null, asyncHttpResponseHandler);
	}

	public void getRange(int start, int count,AsyncHttpResponseHandler asyncHttpResponseHandler) {
		RequestParams params = new RequestParams();
		params.put("start", start);
		params.put("count", count);
		asyncHttpClient.get(Constants.ROOT_URI+TRAVEL_NOTE_URI, params, asyncHttpResponseHandler);
	}

	public void save(ITravelNote travelNote,AsyncHttpResponseHandler asyncHttpResponseHandler) {
		HttpEntity entity;
		try {
			entity = new StringEntity(mapper.writeValueAsString(travelNote));
			asyncHttpClient.post(null, Constants.ROOT_URI+TRAVEL_NOTE_URI, entity, "application/json", asyncHttpResponseHandler);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	



}
