package demo.travel.daos;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itravel.server.interfaces.dal.IUser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import demo.travel.common.AsyncHttpClientFactory;
import demo.travel.common.Constants;
import demo.travel.common.ObjectMapperFactory;
import demo.travel.common.URLs;
import demo.travel.models.User;
/**
 * 单例
 * @author william.wangwm
 *
 */
public final class UserDao {
	private static final class UserDaoHolder {
		private static final UserDao INSTANCE = new UserDao();
	}
	private static final String USER_URI = "/services/users";
	private static final String AUTH_URI = "/auth/users";
	private final ObjectMapper mapper = ObjectMapperFactory.create(); 
	private final AsyncHttpClient asyncHttpClient = AsyncHttpClientFactory.create();
	public static UserDao getInstance(){
		return UserDaoHolder.INSTANCE;
	}
	
	public IUser create(){
		return new User();
	}
	
	private UserDao(){
		
	}
	
	public void save(IUser user,
			AsyncHttpResponseHandler asyncHttpResponseHandler) {
		
		HttpEntity entity;
		try {
			entity = new StringEntity(mapper.writeValueAsString(user));
			asyncHttpClient.post(null, Constants.ROOT_URI+AUTH_URI, entity, "application/json", asyncHttpResponseHandler);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void valiate(String username, String password,
			AsyncHttpResponseHandler asyncHttpResponseHandler) {
		RequestParams params = new RequestParams();
		params.put("username", username);
		params.put("password", password);
		asyncHttpClient.get(Constants.ROOT_URI+USER_URI, params, asyncHttpResponseHandler);
	}
}
