package demo.travel.views;

import uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import demo.travel.R;

public class HomeFragment extends ListFragment implements OnRefreshListener,
		AbsListView.OnScrollListener {
	private StreamAdapter mStreamAdapter = new StreamAdapter();
	private PullToRefreshLayout mPullToRefreshLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		final ListView listView = getListView();
		
		//
		// // if (getArguments() != null
		// // && getArguments().getBoolean(EXTRA_ADD_VERTICAL_MARGINS, false)) {
		// // int verticalMargin = getResources().getDimensionPixelSize(
		// // R.dimen.plus_stream_padding_vertical);
		// // if (verticalMargin > 0) {
		// // listView.setClipToPadding(false);
		// // listView.setPadding(0, verticalMargin, 0, verticalMargin);
		// // }
		// // }
		//
		// listView.setOnScrollListener(this);
		// listView.setDrawSelectorOnTop(true);
		 listView.setDivider(getResources().getDrawable(
		 android.R.color.transparent));
		 listView.setDividerHeight(getResources().getDimensionPixelSize(
		 R.dimen.page_margin_width));
		//
		// TypedValue v = new TypedValue();
		// getActivity().getTheme().resolveAttribute(
		// R.attr.activatableItemBackground, v, true);
		// listView.setSelector(v.resourceId);
		//
		setListAdapter(mStreamAdapter);
		// super.onViewCreated(view,savedInstanceState);

		// This is the View which is created by ListFragment
		ViewGroup viewGroup = (ViewGroup) view;

		// We need to create a PullToRefreshLayout manually
		mPullToRefreshLayout = new PullToRefreshLayout(viewGroup.getContext());

		// We can now setup the PullToRefreshLayout
		ActionBarPullToRefresh
				.from(getActivity())

				// We need to insert the PullToRefreshLayout into the Fragment's
				// ViewGroup
				.insertLayoutInto(viewGroup)

				// We need to mark the ListView and it's Empty View as pullable
				// This is because they are not dirent children of the ViewGroup
				.theseChildrenArePullable(listView.getId()).listener(this)
				.setup(mPullToRefreshLayout);
	}

	@Override
	public void onRefreshStarted(View view) {
		/**
		 * Simulate Refresh with 4 seconds sleep
		 */
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);

				// Notify PullToRefreshLayout that the refresh has finished
				mPullToRefreshLayout.setRefreshComplete();
			}
		}.execute();
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub

	}

	private class StreamAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (position % 2 == 0) {
				convertView = getLayoutInflater(null).inflate(
						R.layout.list_item_home_biz, parent, false);
			} else {
				convertView = getLayoutInflater(null).inflate(
						R.layout.list_item_home_companion, parent, false);
			}
			return convertView;
		}

	}
}
