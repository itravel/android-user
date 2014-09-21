package com.itravel.smzdw.dao;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageDao {
	private static final String REQUEST_ROOT_PATH = "/image";

	public Bitmap getActivityImage(String pictureUri) {
//		HttpResponse response = HttpClientHelper.getInstance().executeGet(
//				pictureUri, null);
//
//		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//		bmOptions.inSampleSize = 1;
//		Bitmap bitmap = null;
//		try {
//			InputStream stream = response.getEntity().getContent();
//			bitmap = BitmapFactory.decodeStream(stream, null, bmOptions);
//			stream.close();
//			return bitmap;
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		bmOptions.inSampleSize = 1;
		Bitmap bitmap = null;

        try {
        	InputStream stream = null;
            URL url = new URL("http://115.28.129.120"+pictureUri);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();
            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                stream = httpConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(stream, null, bmOptions);
                stream.close();
            }
            
			return bitmap;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return null;

	}

}
