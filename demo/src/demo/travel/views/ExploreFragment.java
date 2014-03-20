package demo.travel.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import demo.travel.R;
import demo.travel.views.explore.*;

public class ExploreFragment extends Fragment implements OnItemClickListener {
	ListView listView;
	// SimpleListViewAdapter adapter;
	SimpleAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		listView = (ListView) inflater.inflate(R.layout.fragment_explore,
				container, false);
		adapter = new SimpleAdapter(getActivity(), getData(),
				R.layout.item_explore, new String[] { "explore_funcname", "explore_funcicon" },
				new int[] { R.id.explore_funcname, R.id.explore_funcicon });
		listView.setAdapter(adapter);
		Log.d("CODE", "list view set adapter");

		listView.setOnItemClickListener(this);

		return listView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Class<?> cls = null;
		switch (position) {
		case 0:
			cls = DestActivity.class;
			break;
		case 1:
			cls = GroupActivity.class;
			break;

		}
		Intent intent = new Intent(getActivity(), cls);
		startActivity(intent);
	}

	private ArrayList<Map<String, Object>> getData() {
		ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();
		;
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("explore_funcname", getActivity().getString(R.string.explore_destination));
		item.put("explore_funcicon", R.drawable.ic_location_marker_default);
		mData.add(item);

		Map<String, Object> item1 = new HashMap<String, Object>();
		item1.put("explore_funcname", getActivity().getString(R.string.explore_group));
		item1.put("explore_funcicon", R.drawable.ic_group);
		mData.add(item1);
		Log.d("CODE", "getdata");
		return mData;
	}

}
