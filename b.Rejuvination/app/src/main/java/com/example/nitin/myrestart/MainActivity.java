package com.example.nitin.myrestart;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                System.out.println("Nitin Chaurasia");
                Log.e("TESTING 1 2 3", "Inside BroadCast Intent Method in Main Activity");
                Toast.makeText(getApplicationContext(), "Intent Detected.", Toast.LENGTH_LONG).show();

                // Toggle the Text upon click of the Button
                TextView tv = (TextView) findViewById(R.id.textView);
                if (tv.isShown()){
                    tv.setVisibility(View.INVISIBLE);
                } else {
                    tv.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
