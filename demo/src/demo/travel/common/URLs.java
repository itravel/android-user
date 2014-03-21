package demo.travel.common;

public class URLs {
	public final static String HTTP = "http://";
	public final static String HTTPS = "https://";
	public final static String HOST = "115.28.129.120";
	public final static String PORT = "8080";

	private final static String URL_SPLITTER = "/";
	private final static String URL_UNDERLINE = "_";

	private final static String URL_API_HOST = HTTP + HOST + ':' + PORT
			+ URL_SPLITTER;
	
	public final static String USERS = URL_API_HOST + "web/services/users";
	
	public final static String AROUND_HOTEL = URL_API_HOST
			+ "travel/services/around/hotels";
	public final static String QUERY_COMPETITIONS =  URL_API_HOST
			+ "/api/orders/%d/competitions/";
}
