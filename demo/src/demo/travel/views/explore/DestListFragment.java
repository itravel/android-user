package demo.travel.views.explore;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import demo.travel.R;

public class DestListFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_explore_list_destination, container, false);
	}


	public class ClickListener implements OnClickListener {
		@Override
		public void onClick(View paramView) {
			switch (paramView.getId()) {
			}
		}
	}
}