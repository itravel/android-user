package demo.travel.daos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import demo.travel.common.AsyncHttpClientFactory;
import demo.travel.common.Constants;
import demo.travel.common.ObjectMapperFactory;

public final class InfoStreamDao {
	public static final class InfoStreamDaoHolder {
		private static final InfoStreamDao INSTANCE = new InfoStreamDao();
	}
	
	private final AsyncHttpClient asyncHttpClient = AsyncHttpClientFactory.create();
	private final ObjectMapper mapper = ObjectMapperFactory.create(); 
	private static final String INFOSTREAM_URI = "/services/infostreams";
	private InfoStreamDao(){
		
	}
	
	public static InfoStreamDao getInstance(){
		return InfoStreamDaoHolder.INSTANCE;
	}
	
	public void getInfoStreams(int start,int count,AsyncHttpResponseHandler asyncHttpResponseHandler){
		RequestParams params = new RequestParams();
		params.put("start", start);
		params.put("count", count);
		asyncHttpClient.get(Constants.ROOT_URI+INFOSTREAM_URI, params, asyncHttpResponseHandler);
	}
	
}
