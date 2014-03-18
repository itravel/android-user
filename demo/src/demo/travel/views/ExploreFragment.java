package demo.travel.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import demo.travel.R;
import demo.travel.views.explore.*;

public class ExploreFragment extends Fragment implements OnItemClickListener{
	ListView listView;
	SimpleListViewAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		listView = (ListView) inflater.inflate(R.layout.fragment_explore,
				container, false);
		adapter = new SimpleListViewAdapter(getActivity(),
				R.layout.fragment_explore, getData());
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
			cls = FriendsActivity.class;
			break;
		case 2:
			cls = RomanceActivity.class;
			break;
		case 3:
			cls = GroupActivity.class;
			break;

		}
		Intent intent = new Intent(getActivity(), cls);
		startActivity(intent);
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		data.add(getActivity().getString(R.string.explore_destination));
		data.add(getActivity().getString(R.string.explore_friends));
		data.add(getActivity().getString(R.string.explore_romance));
		data.add(getActivity().getString(R.string.explore_group));
		Log.d("CODE", "getdata");
		return data;
	}

	class SimpleListViewAdapter extends ArrayAdapter<String> {

		public SimpleListViewAdapter(Context context, int textViewResourceId,
				List<String> objects) {
			super(context, textViewResourceId, objects);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View view = convertView;
			view = LayoutInflater.from(getContext()).inflate(
					R.layout.item_explore, null);
			TextView textView = (TextView) view
					.findViewById(R.id.explore_funcname);
			textView.setText(getItem(position));
			return view;
		}
	}


}
