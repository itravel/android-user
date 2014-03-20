package demo.travel.views.explore;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import demo.travel.R;



public class DestActivity extends FragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_explore_destination);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();    
	    inflater.inflate(R.menu.menu_explore_sub_actions, menu);    
	    return super.onCreateOptionsMenu(menu);
	}
}