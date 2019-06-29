package android.learning.nitin.androidconcepts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
    }

    public void buttonClicked(View view){

        Button button = (Button)findViewById(R.id.bringImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(
                        GridViewActivity.this,
                        DisplayMessageActivity.class);
                startActivity(i);
            }
        });
    }
}
