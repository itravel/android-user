package com.itravel.smzdw.fragments;

import java.util.concurrent.ExecutionException;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itravel.smzdw.R;
import com.itravel.smzdw.dao.Activity;
import com.itravel.smzdw.dao.ActivityDao;
import com.itravel.smzdw.dao.ActivityImageCache;

public class ActivityDetailFragment extends Fragment {
	private final ActivityImageCache imageCache = ActivityImageCache.getInstance();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		long activityId = this.getArguments().getLong("activityId");
		View rootView = inflater.inflate(R.layout.fragment_activity_detail, container,false);
		new ActivityDetailGetTask(rootView).execute(activityId);
		
		return rootView;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if(id == android.R.id.home){
			this.getFragmentManager().popBackStack();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		this.getActivity().getActionBar().setTitle("");
	}
	private class ActivityDetailGetTask extends AsyncTask<Long,Void,Activity> {
		
		private View rootView;

		public ActivityDetailGetTask(View rootView) {
			// TODO Auto-generated constructor stub
			this.rootView = rootView;
		}

		@Override
		protected Activity doInBackground(Long... params) {
			// TODO Auto-generated method stub
			ActivityDao activityDao = new ActivityDao();
			Activity activity = activityDao.getActivity(params[0]);
			return activity;
		}

		@Override
		protected void onPostExecute(Activity result) {
//			Log.i("com.itravel.smzdw", result.toString());
//			super.onPostExecute(result);
			ImageView activityImage = (ImageView) this.rootView.findViewById(R.id.activity_image);
			if(result.getImage()!=null&&!result.getImage().isEmpty()){
				Bitmap image;
				try {
					image = imageCache.get(result.getImage());
					activityImage.setImageBitmap(image);
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			TextView title = (TextView) this.rootView.findViewById(R.id.activity_detail_title);
			title.setText(result.getTitle());
			
			Typeface font = Typeface.createFromAsset( this.rootView.getContext().getAssets(), "fontawesome-webfont.ttf" );
			TextView start_end_time_label = (TextView) this.rootView.findViewById(R.id.start_end_time_label);
			start_end_time_label.setTypeface(font);
			TextView start_end_time = (TextView) this.rootView.findViewById(R.id.start_end_time);
			start_end_time.setText(result.getStartTime()+" ~ "+result.getEndTime());
			
			TextView scenerySpotLabel = (TextView) this.rootView.findViewById(R.id.activity_detail_scenery_spot_label);
			scenerySpotLabel.setTypeface(font);	
			TextView scenerySpot = (TextView) this.rootView.findViewById(R.id.activity_detail_scenery_spot);
			scenerySpot.setText(result.getScenerySpot());
			
			TextView activityDesc = (TextView) this.rootView.findViewById(R.id.activity_description);
			activityDesc.setText(result.getContent());
			
			TextView tips = (TextView) this.rootView.findViewById(R.id.activity_tips);
			tips.setText(result.getTips());
			
			
			
		}
		
		
		
	}
	
	
}
