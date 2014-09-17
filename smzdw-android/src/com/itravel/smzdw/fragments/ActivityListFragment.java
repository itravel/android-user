package com.itravel.smzdw.fragments;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.google.common.collect.Lists;
import com.itravel.smzdw.R;
import com.itravel.smzdw.adapters.ActivityAdapter;
import com.itravel.smzdw.dao.ActivityDao;
import com.itravel.smzdw.dao.ActivitySimple;

public class ActivityListFragment extends ListFragment {
	private List<ActivitySimple> activities = new CopyOnWriteArrayList<ActivitySimple>();
	private ActivityAdapter adapter;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置ListFragment默认的ListView，即@id/android:list
        this.adapter = new ActivityAdapter(getActivity(),R.layout.activity_list_row, activities);
        setListAdapter(this.adapter);
        new ActivityListGetTask().execute(0,5);
        setHasOptionsMenu(true);
    }
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		this.getListView().setOnScrollListener(new OnScrollListener(){
			private boolean readyLoad = false;
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				if(this.readyLoad){
					new ActivityListGetTask().execute(activities.size()-1,5);
					this.readyLoad = false;
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				 if (firstVisibleItem + visibleItemCount >= totalItemCount-1 && totalItemCount > 0) {
					 this.readyLoad = true;
				 }
			}});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		
		return rootView;
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		ActivitySimple act = (ActivitySimple) l.getItemAtPosition(position);
		Bundle arguments = new Bundle();
		arguments.putLong("activityId", act.getId());
		Fragment detailFragment = new ActivityDetailFragment();
		detailFragment.setArguments(arguments);
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						detailFragment).addToBackStack("activity-list").commit();
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		this.getActivity().getActionBar().setTitle("发现");
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	private class ActivityListGetTask extends AsyncTask<Integer, Void, List<ActivitySimple>> {

		@Override
		protected List<ActivitySimple> doInBackground(Integer... params) {
			ActivityDao dao = new ActivityDao();
			List<ActivitySimple> ls = dao.getActivities(params[0], params[1]);
			return ls;
		}

		@Override
		protected void onPostExecute(List<ActivitySimple> result) {
			// TODO Auto-generated method stub
			activities.addAll(result);
			adapter.notifyDataSetChanged();
		}
	}

		
}
