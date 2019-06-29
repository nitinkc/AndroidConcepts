package android.learning.nitin.androidconcepts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nitin on 3/23/18.
 */

public class HideUIElements extends AppCompatActivity {

    TextView text;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_ui);

        text = (TextView) findViewById(R.id.theUIElement);
        image = (ImageView) findViewById(R.id.theImageelement);

    }


    public void showUIElement(View view){
        text.setVisibility(View.VISIBLE);
        image.setVisibility(View.INVISIBLE);
    }

    public void hideUIElement(View view){
        text.setVisibility(View.INVISIBLE);
        image.setVisibility(View.VISIBLE);

    }
}
