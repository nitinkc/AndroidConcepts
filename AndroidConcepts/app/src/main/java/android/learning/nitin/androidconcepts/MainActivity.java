package android.learning.nitin.androidconcepts;

import android.content.Intent;
import android.learning.nitin.androidconcepts.basics.AudioActivity;
import android.learning.nitin.androidconcepts.basics.ImageActivity;
import android.learning.nitin.androidconcepts.basics.TemperatureConverter;
import android.learning.nitin.androidconcepts.basics.VideoActivity;
import android.learning.nitin.androidconcepts.mapsNgeoLocations.GoogleMapsActivity;
import android.learning.nitin.androidconcepts.mapsNgeoLocations.LocationActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/*
* This is where the Main App Starts running.
*
* */

public class MainActivity extends AppCompatActivity {

    ArrayList<String> concepts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        concepts.add("Images");
        concepts.add("Buttons and Text Box");
        concepts.add("Video");
        concepts.add("Audio");
        concepts.add("Grid Layout");
        concepts.add("List Layout/Multiplication Table");
        concepts.add("Timer - Egg Timer" );
        concepts.add("Intents - Message Passing");
        concepts.add("Show/Hide UI Elements");
        concepts.add("Google Maps Demo");
        concepts.add("Locations Demo");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, concepts);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        // Keeping intents separate for each case - Knowingly
                        Intent intent1 = new Intent(MainActivity.this, TemperatureConverter.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, VideoActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, AudioActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, GridViewActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(MainActivity.this, ListView_MultiplicationTable.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(MainActivity.this, TimerActivity.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(MainActivity.this, IntentMessageActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(MainActivity.this, HideUIElements.class);
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(MainActivity.this, GoogleMapsActivity.class);
                        startActivity(intent9);
                    case 10:
                        Intent intent10 = new Intent(MainActivity.this, LocationActivity.class);
                        startActivity(intent10);
                    default:
                        break;

                }

                Log.i("Person Clicked : ", concepts.get(position));

                Toast.makeText(MainActivity.this, "Hello " + concepts.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
