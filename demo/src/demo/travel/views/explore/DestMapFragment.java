package demo.travel.views.explore;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.LocationData;
import com.baidu.mapapi.map.MKMapStatus;
import com.baidu.mapapi.map.MKMapStatusChangeListener;
import com.baidu.mapapi.map.MKMapViewListener;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationOverlay;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.platform.comapi.basestruct.GeoPoint;

import demo.travel.R;

public class DestMapFragment extends Fragment {

	private String TAG = "HOTEL_MAIN";
	private LocationData locData = null;
	private ItemizedOverlay myMarkerOverLay;
	private MyLocationOverlay myLocationOverlay;
	private GeoPoint targetGeo = null;
	private Boolean isFirstLoc = true;
	// private HotelDao hotelDao = null;

	private View mRootView = null;

	private BMapManager mBMapMan = null;
	private MapView mMapView = null;
	private MapController mMapController = null;

	private LocationClient mLocClient = null;

	private static final int UPDATE_TIME = 1000;

	private void initMap() {
		this.mMapView = (MapView) this.mRootView
				.findViewById(R.id.baidu_map_view);
		this.mMapView.setBuiltInZoomControls(false);
		this.mMapController = this.mMapView.getController();
		this.mMapController.setZoom(14.0F);
		this.mMapController.enableClick(false);
		this.mMapController.setRotationGesturesEnabled(false);
		this.mMapController.setOverlookingGesturesEnabled(false);
		this.mMapController.setRotateWithTouchEventCenterEnabled(false);
		this.mMapController.setZoomWithTouchEventCenterEnabled(false);
		// enableMapViewControl();
		this.mLocClient = new LocationClient(getActivity()
				.getApplicationContext());

		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);
		option.setCoorType("bd09ll");
		option.setScanSpan(UPDATE_TIME);
		mLocClient.setLocOption(option);

		this.locData = new LocationData();
		this.mLocClient.registerLocationListener(new MyLocationListener());
		this.mLocClient.start();

		this.myLocationOverlay = new MyLocationOverlay(this.mMapView);
		this.myLocationOverlay
				.setLocationMode(MyLocationOverlay.LocationMode.NORMAL);
		this.myLocationOverlay.setData(this.locData);
		this.mMapView.getOverlays().add(this.myLocationOverlay);

		// this.myMarkerOverLay = new
		// ItemizedOverlay(getResources().getDrawable(
		// R.drawable.marker), mMapView);
		// this.mMapView.getOverlays().add(this.myMarkerOverLay);
		this.mMapView.refresh();
	}

	private void initUI() {
		OnClickListener clickListener = new ClickListener();

		ImageButton locationButton = ((ImageButton) mRootView
				.findViewById(R.id.location_button));
		locationButton.setOnClickListener(clickListener);
		ImageButton zoomInButton = ((ImageButton) mRootView
				.findViewById(R.id.zoom_in));
		zoomInButton.setOnClickListener(clickListener);
		ImageButton zoomOutButton = ((ImageButton) mRootView
				.findViewById(R.id.zoom_out));
		zoomOutButton.setOnClickListener(clickListener);

	}

	private void addItemToMyOverLay(double paramDouble1, double paramDouble2,
			String paramString, Object paramObject) {
		OverlayItem localOverlayItem = new OverlayItem(new GeoPoint(
				(int) (paramDouble1 * 1E6), (int) (paramDouble2 * 1E6)),
				paramString, "");
		localOverlayItem.setMarker(new BitmapDrawable(getResources(),
				getViewBitmap(getView(paramString))));
		this.myMarkerOverLay.addItem(localOverlayItem);
	}

	public static Bitmap getViewBitmap(View paramView) {
		paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0),
				View.MeasureSpec.makeMeasureSpec(0, 0));
		paramView.layout(0, 0, paramView.getMeasuredWidth(),
				paramView.getMeasuredHeight());
		paramView.buildDrawingCache();
		return paramView.getDrawingCache();
	}

	private View getView(String paramString) {
		View localView = getActivity().getLayoutInflater().inflate(
				R.layout.marker, null);
		// TextView localTextView = (TextView) localView
		// .findViewById(R.id.hotel_brand);
		String str = paramString;
		if (paramString.length() >= 6)
			str = paramString.substring(0, 6);
		// localTextView.setText(str);
		// localTextView.setTextColor(-1);
		return localView;
	}

	private void searchTargetAroundHotel() {
		Double latitude = targetGeo.getLatitudeE6() / 1E6;
		Double longtitude = targetGeo.getLongitudeE6() / 1E6;
		searchAroundHotel(latitude, longtitude);
	}

	private void searchAroundHotel(Double latitude, Double longtitude) {
		// hotelDao.getAroundHotel(latitude, longtitude,
		// new AsyncHttpResponseHandler() {
		//
		// @Override
		// public void onSuccess(String response) {
		// myMarkerOverLay.removeAll();
		// try {
		// JSONArray ja = new JSONArray(response);
		// for (int i = 0; i < ja.length() && i < 20; i++) {
		// JSONObject jo = ja.getJSONObject(i);
		// addItemToMyOverLay(jo.getDouble("latitude"),
		// jo.getDouble("longtitude"),
		// jo.getString("name"), null);
		// }
		// mMapView.refresh();
		// } catch (JSONException e) {
		// e.printStackTrace();
		// }
		// }
		//
		// @Override
		// public void onStart() {
		// super.onStart();
		// Log.d(TAG, "Start searchAroundHotel");
		// }
		//
		// @Override
		// public void onFinish() {
		// super.onFinish();
		// Log.d(TAG, "Finish searchAroundHotel");
		// }
		//
		// });
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mBMapMan = new BMapManager(getActivity().getApplication());
		mBMapMan.init("y5qvr6Apv4vC3t9SzlteXARS", null);

		mRootView = inflater.inflate(R.layout.fragment_explore_map_destination,
				container, false);

		this.initMap();
		this.initUI();

		// hotelDao = new HotelDao();

		MKMapViewListener mapViewListener = new MKMapViewListener() {

			@Override
			public void onMapMoveFinish() {
			}

			@Override
			public void onClickMapPoi(MapPoi arg0) {
			}

			@Override
			public void onGetCurrentMap(Bitmap b) {
			}

			@Override
			public void onMapAnimationFinish() {
				searchTargetAroundHotel();
			}

			@Override
			public void onMapLoadFinish() {
			}
		};
		mMapView.regMapViewListener(mBMapMan, mapViewListener);
		MKMapStatusChangeListener listener = new MKMapStatusChangeListener() {
			@Override
			public void onMapStatusChange(MKMapStatus mapStatus) {
				targetGeo = mapStatus.targetGeo;
			}
		};
		mMapView.regMapStatusChangeListener(listener);

		return mRootView;
	}

	@Override
	public void onDestroy() {
		mMapView.destroy();
		if (mBMapMan != null) {
			mBMapMan.destroy();
			mBMapMan = null;
		}
		super.onDestroy();

		if (mLocClient != null && mLocClient.isStarted()) {
			mLocClient.stop();
			mLocClient = null;
		}
	}

	@Override
	public void onPause() {
		mMapView.onPause();
		if (mBMapMan != null) {
			mBMapMan.stop();
		}
		super.onPause();
	}

	@Override
	public void onResume() {
		mMapView.onResume();
		if (mBMapMan != null) {
			mBMapMan.start();
		}
		super.onResume();
	}

	public class MyLocationListener implements BDLocationListener {

		public MyLocationListener() {
		}

		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null) {
				return;
			}
			Double latitude = location.getLatitude();
			Double longtitude = location.getLongitude();

			DestMapFragment.this.locData.latitude = latitude;
			DestMapFragment.this.locData.longitude = longtitude;
			DestMapFragment.this.myLocationOverlay
					.setData(DestMapFragment.this.locData);
			DestMapFragment.this.mMapView.refresh();

			GeoPoint point = new GeoPoint((int) (latitude * 1E6),
					(int) (longtitude * 1E6));

			targetGeo = point;
			if (DestMapFragment.this.isFirstLoc.booleanValue()) {
				DestMapFragment.this.mMapController.setZoom(14.0F);
				DestMapFragment.this.mMapController.animateTo(point);
				searchTargetAroundHotel();
				DestMapFragment.this.isFirstLoc = Boolean.valueOf(false);
			}
		}

		@Override
		public void onReceivePoi(BDLocation location) {
		}
	}

	public class ClickListener implements OnClickListener {
		@Override
		public void onClick(View paramView) {
			switch (paramView.getId()) {
			case R.id.zoom_in:
				DestMapFragment.this.mMapController.zoomIn();
				return;
			case R.id.zoom_out:
				DestMapFragment.this.mMapController.zoomOut();
				return;
			}
		}
	}
}