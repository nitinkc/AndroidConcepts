package nitin.contentpreflearning;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MyActivity extends Activity {

    public static final String COUNT = "count";//this is the key
    private SharedPreferences mPrefs;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "OnCreate!");
        mPrefs = getPreferences(MODE_PRIVATE);
        int count = mPrefs.getInt(COUNT,0);

        count = count +1;
        Log.d("MainActivity", "Count is " + count);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putInt(COUNT,count);
        editor.commit();

        //Creating view manually
        mTextView = new TextView(this);
        setContentView(mTextView);
        mTextView.setTextSize(80);
        mTextView.setText("Count : " + count);

       //Creating view by the help of XML
       // setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
