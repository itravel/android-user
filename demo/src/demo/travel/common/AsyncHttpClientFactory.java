package demo.travel.common;

import com.loopj.android.http.AsyncHttpClient;

public final class AsyncHttpClientFactory {
	private static final class AsyncHttpClientHolder {
		private static final AsyncHttpClient INSTANCE = new AsyncHttpClient();
	}
	
	public static AsyncHttpClient create(){
		return AsyncHttpClientHolder.INSTANCE;
	}
}
