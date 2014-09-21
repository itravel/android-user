package com.itravel.smzdw.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.itravel.smzdw.R;
import com.itravel.smzdw.dao.NavigationMenuItem;
import com.itravel.smzdw.widgets.TypeFontTextView;


public class NaviationMenuItemAdapter extends ArrayAdapter<NavigationMenuItem> {
	
	private NavigationMenuItem[] items;

	public NaviationMenuItemAdapter(Context context, int textViewResourceId,
			NavigationMenuItem[] items) {
		super(context, textViewResourceId, items);
		this.items = items;

	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater vi = (LayoutInflater) super.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.navigation_left_menu_layout, null);
		}
		
		TypeFontTextView itemViewIcon = (TypeFontTextView) convertView.findViewById(R.id.navigation_left_item_icon);
		itemViewIcon.setText(items[position].getLabel());
		
		TextView itemView = (TextView) convertView.findViewById(R.id.navigation_left_item);
		itemView.setText(items[position].getText());
		return convertView;
	}
}
