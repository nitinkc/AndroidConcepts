package com.example.listviewba;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ListView myListView = (ListView) findViewById(R.id.my_list_view);
		final Button addViewButton = (Button) findViewById(R.id.add_view_button);
		
		//create adapter
		RowNumberAdapter rowNumberAdapter = new RowNumberAdapter(this);
		
		//Bind Adapter
		myListView.setAdapter(rowNumberAdapter);
		
		addViewButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		
		
	}

}
