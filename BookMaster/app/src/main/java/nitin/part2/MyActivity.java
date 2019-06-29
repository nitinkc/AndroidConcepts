package nitin.part2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;


public class MyActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView mainTextView; //Declaring a Text View
    Button mainButton;//Declaring a button
    EditText mainEditText;

    //next 3 are for List View
    ListView mainListView;
    //ArrayAdapter mArrayAdapter; //replacing with JSONAdapter mJSONAdapter;
    ArrayList mNameList = new ArrayList();

    JSONAdapter mJSONAdapter;

    //To include the Sharing feature, with generic Intent
    ShareActionProvider mShareActionProvider;

    //Remembering the name
    private static final String PREFS = "prefs";
    private static final String PREF_NAME = "name";
    SharedPreferences mSharedPreferences;

    //Website to search the library
    private static final String QUERY_URL = "http://openlibrary.org/search.json?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // 1. Access the TextView defined in layout XML
        // and then set its text
        mainTextView = (TextView) findViewById(R.id.main_textview);//Recognizing the text view
       // mainTextView.setText("Set via the Main Activity file"); //setting the text; the hello world
        // is not shown after this (even id it is there)

        // 2. Access the Button defined in layout XML
        // and listen for it here
        mainButton = (Button) findViewById(R.id.main_button);//access the button
        mainButton.setOnClickListener(this);

        // 3. Access the EditText defined in layout XML
        mainEditText = (EditText) findViewById(R.id.main_edittext);
        //put the text into the textview. Can be appended or Replaced

        // 4. Access the ListView
        mainListView = (ListView) findViewById(R.id.main_listview);
        // Create an ArrayAdapter for the ListView
       // mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        // Set the ListView to use the ArrayAdapter
       // mainListView.setAdapter(mArrayAdapter);

        // 5. Set this activity to react to list items being pressed
        mainListView.setOnItemClickListener(this);

        // 6. The text you'd like to share has changed,
        // and you need to update
        setShareIntent();

        // 7. Greet the user, or ask for their name if new
        displayWelcome();

        // 9. Take what was typed into the EditText and use in search
        queryBooks(mainEditText.getText().toString());

        /*
        // Create an ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);
        */

        // 10. Create a JSONAdapter for the ListView
        mJSONAdapter = new JSONAdapter(this, getLayoutInflater());

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mJSONAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);

        // Access the Share Item defined in menu XML
        MenuItem shareItem = menu.findItem(R.id.menu_item_share);

        // Access the object responsible for
        // putting together the sharing submenu
        if (shareItem != null) {
            mShareActionProvider = (ShareActionProvider) shareItem.getActionProvider();
        }

        // Create an Intent to share your content
        setShareIntent();
        return true;
    }

    /* REMOVING IN ORDER TO USE SHARE MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       // if (id == R.id.action_settings) { old menu with settings
          if (id == R.id.menu_item_share){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void onClick(View view) { // Activity takes place on the click of the button.
        //mainTextView.setText("Setting the text with the Click of the button");
        //Display the text on the top

        mainTextView.setText(mainEditText.getText().toString());

        //Add the text into the list

       /* TESTNG TO AVOID NULL DISPLAYS
        if (mainEditText.getText().toString() == "nitin")
           Toast.makeText(this,"Null Field Clicked", Toast.LENGTH_LONG).show();
        //Toast.makeText(context,"Intent Detected.", Toast.LENGTH_LONG).show();
        */

        mNameList.add(mainEditText.getText().toString());//add the data from the edittext field into list
        mainEditText.setText(null); //to clear the edit text field for the next fill
        //mArrayAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        /*
        // Log the item's position and contents
        // to the console in Debug
        Log.d("Nitin Tag", position + ": " + mNameList.get(position)); */


    }

    private void setShareIntent() {

        if (mShareActionProvider != null) {

            // create an Intent with the contents of the TextView
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Android Development");
            shareIntent.putExtra(Intent.EXTRA_TEXT, mainTextView.getText());

            // Make sure the provider knows
            // it should work with that Intent
            mShareActionProvider.setShareIntent(shareIntent);
        }
     else {

        // otherwise, show a dialog to ask for their name
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Hello!");
        alert.setMessage("What is your name?");

        // Create EditText for entry
        final EditText input = new EditText(this);
        alert.setView(input);

        // Make an "OK" button to save the name
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

                // Grab the EditText's input
                String inputName = input.getText().toString();

                // Put it into memory (don't forget to commit!)
                SharedPreferences.Editor e = mSharedPreferences.edit();
                e.putString(PREF_NAME, inputName);
                e.commit();

                // Welcome the new user
                Toast.makeText(getApplicationContext(), "Welcome, " + inputName + "!", Toast.LENGTH_LONG).show();
            }
        });

        // Make a "Cancel" button
        // that simply dismisses the alert
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {}
        });

        alert.show();
    }

    }

    public void displayWelcome() {

        // Access the device's key-value storage
        mSharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);

        // Read the user's name,
        // or an empty string if nothing found
        String name = mSharedPreferences.getString(PREF_NAME, "");

        if (name.length() > 0) {

            // If the name is valid, display a Toast welcoming them
            Toast.makeText(this, "Welcome back, " + name + "!", Toast.LENGTH_LONG).show();
        }
    }

    private void queryBooks(String searchString) {

        // Prepare your search string to be put in a URL
        // It might have reserved characters or something
        String urlString = "";

        try {
            urlString = URLEncoder.encode(searchString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // if this fails for some reason, let the user know why
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        // Create a client to perform networking
        AsyncHttpClient client = new AsyncHttpClient();

        // Have the client get a JSONArray of data
        // and define how to respond
        client.get(QUERY_URL + urlString,
                new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(JSONObject jsonObject) {
                        // Display a "Toast" message
                        // to announce your success
                        Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();

                        // 8. For now, just log results
                       // Log.d("Nitin Test", jsonObject.toString());

                        // update the data in your custom method.
                        mJSONAdapter.updateData(jsonObject.optJSONArray("docs"));
                    }

                    @Override
                    public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                        // Display a "Toast" message
                        // to announce the failure
                        Toast.makeText(getApplicationContext(), "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();

                        // Log error message
                        // to help solve any problems
                        Log.e("omg android", statusCode + " " + throwable.getMessage());
                    }
                });
    }
}
