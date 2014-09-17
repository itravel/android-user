package com.itravel.smzdw.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.itravel.smzdw.R;
import com.itravel.smzdw.dao.ActivitySimple;

public class ActivityAdapter extends ArrayAdapter<ActivitySimple> {
	private List<ActivitySimple> items;
//	private ImageView image = null;
	public ActivityAdapter(Context context, int textViewResourceId,
			List<ActivitySimple> items) {
		super(context, textViewResourceId, items);
		this.items = items;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
//		View v = null;
		Log.i("com.itravel.smzdw", String.valueOf(position));
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) super.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.activity_list_row, null);
			
		}
		ActivitySimple activity = this.items.get(position);
		ImageView image = (ImageView) v.findViewById(R.id.activity_image);
		new ImageLoadTask(image).execute(activity.getImage());
		
		TextView title = (TextView) v.findViewById(R.id.activity_title);
		title.setText(activity.getTitle());
		
		Typeface font = Typeface.createFromAsset( this.getContext().getAssets(), "fontawesome-webfont.ttf" );
//		TextView button = (TextView)v.findViewById( R.id.like );
//		button.setTypeface(font);
		TextView scenerySpotLabel = (TextView) v.findViewById(R.id.activity_sceney_spot_label);
		scenerySpotLabel.setTypeface(font);
		TextView scenerySpot  = (TextView) v.findViewById(R.id.activity_sceney_spot);
		scenerySpot.setText(activity.getScenerySpot());

		return v;
	}
	
	private class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {

		private ImageView image;

		public ImageLoadTask(ImageView image) {
			// TODO Auto-generated constructor stub
			this.image = image;
		}
		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			Bitmap map = null;
           
                map = downloadImage("http://115.28.129.120"+params[0]);
            
            return map;
		}
		@Override
        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
        }
		private Bitmap downloadImage(String url) {
            Bitmap bitmap = null;
            InputStream stream = null;
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inSampleSize = 1;
 
            try {
                stream = getHttpConnection(url);
                bitmap = BitmapFactory.
                        decodeStream(stream, null, bmOptions);
                stream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return bitmap;
        }
 
        // Makes HttpURLConnection and returns InputStream
        private InputStream getHttpConnection(String urlString)
                throws IOException {
            InputStream stream = null;
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
 
            try {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();
 
                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return stream;
        }
    
	}
}
