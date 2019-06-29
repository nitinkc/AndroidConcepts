package com.example.listviewba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RowNumberAdapter extends BaseAdapter {

	private Context mContext;
	
	RowNumberAdapter(Context context){
		mContext = context;
		
	}
	@Override
	public int getCount() {
		return 15;
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
		//make it an initial view
		TextView view = null;
		
		if (convertView == null){
			//if its not recycled, initialize a new view
			view = new TextView(this.mContext);
		} else{
			//Use the Recycled view (Convert this view)
			view = (TextView) convertView;
		}
		
		view.setText(" Row " + position);
		
		
		return view;
	}

}
