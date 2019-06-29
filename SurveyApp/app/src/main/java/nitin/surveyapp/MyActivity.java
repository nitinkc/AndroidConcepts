package nitin.surveyapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MyActivity extends Activity {

    private EditText mName;
    private EditText mPhone;
    private EditText memail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mName  = (EditText) findViewById(R.id.name);
        mPhone = (EditText) findViewById(R.id.phone);
        memail = (EditText) findViewById(R.id.email);
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

    public void processForm(View duck){

        String email = memail.getText().toString();
        Toast.makeText(this.getApplicationContext(),email,Toast.LENGTH_LONG).show();
        duck.setVisibility(View.INVISIBLE);
        Toast.makeText(this.getApplicationContext(),R.string.app_name,Toast.LENGTH_LONG).show();
    }
}