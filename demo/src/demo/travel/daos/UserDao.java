package demo.travel.daos;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import demo.travel.common.URLs;

public class UserDao {
	private static final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

	public static void create(String cellPhone,
			AsyncHttpResponseHandler asyncHttpResponseHandler) {
		RequestParams params = new RequestParams();
		params.put("cellPhone", cellPhone);

		asyncHttpClient.post(URLs.USERS, params, asyncHttpResponseHandler);
	}

	public static void valiate(String username, String password,
			AsyncHttpResponseHandler asyncHttpResponseHandler) {
		RequestParams params = new RequestParams();
		params.put("username", username);
		params.put("password", password);

		asyncHttpClient.get(URLs.USERS, params, asyncHttpResponseHandler);
	}
}
