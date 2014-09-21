package com.itravel.smzdw.adapters;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.itravel.smzdw.R;
import com.itravel.smzdw.dao.ActivityImageCache;
import com.itravel.smzdw.dao.ActivitySimple;
import com.itravel.smzdw.dao.ImageDao;

public class ActivityAdapter extends ArrayAdapter<ActivitySimple> {
	private class ViewHolder {
		private ImageView image;
		private TextView title;
		private TextView scenerySpot;
	}
	private static final ExecutorService service = Executors.newFixedThreadPool(10);
	private List<ActivitySimple> items;
//	private ImageView image = null;
	private final ActivityImageCache imageCache = ActivityImageCache.getInstance();
	public ActivityAdapter(Context context, int textViewResourceId,
			List<ActivitySimple> items) {
		super(context, textViewResourceId, items);
		this.items = items;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		View v = convertView;
//		View v = null;
		ViewHolder holder;
		Log.i("com.itravel.smzdw", String.valueOf(position));
		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) super.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.activity_list_row, null);
			holder = new ViewHolder();
			ImageView image = (ImageView) convertView.findViewById(R.id.activity_image);
			TextView title = (TextView) convertView.findViewById(R.id.activity_title);
			TextView scenerySpot  = (TextView) convertView.findViewById(R.id.activity_sceney_spot);
			holder.image = image;
			holder.title = title;
			holder.scenerySpot = scenerySpot;
			convertView.setTag(holder);
		}
		
		else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.image.setImageResource(R.drawable.act_1);
		ActivitySimple activity = this.items.get(position);
		if(activity.getImages().size() > 0){
			
			new ImageLoadTask(holder.image).executeOnExecutor(service,activity.getImages().get(0));
		}
		
		holder.title.setText(activity.getTitle());
		
		Typeface font = Typeface.createFromAsset( this.getContext().getAssets(), "fontawesome-webfont.ttf" );
		TextView scenerySpotLabel = (TextView) convertView.findViewById(R.id.activity_sceney_spot_label);
		scenerySpotLabel.setTypeface(font);
		holder.scenerySpot.setText(activity.getScenerySpot());

		return convertView;
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
			Bitmap map  = null;
			try {
				if(params==null || params[0] == null){
					return null;
				}
				map = imageCache.get(params[0]);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
            
            return map;
		}
		@Override
        protected void onPostExecute(Bitmap result) {
			if(result==null){
				image.setImageResource(R.drawable.act_1);
				return ;
			}
            image.setImageBitmap(result);
        }
	/*	private Bitmap downloadImage(String url) {
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
        }*/
    
	}
}
