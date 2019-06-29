package android.learning.nitin.androidconcepts.basics;

import android.learning.nitin.androidconcepts.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    // To be able to toggle between two images.
    static int imageCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    public void buttonClick(View view){

        changeImage( view);
        currencyConvertor();

    }

    private void currencyConvertor() {
        EditText text = (EditText) findViewById(R.id.editText);
        String str = String.valueOf(text.getText());

        Double initCurr = 0.0;
        try{
            initCurr = Double.parseDouble(str);
        }catch (NumberFormatException e){
            Log.e("str = ", str);
            //e.printStackTrace();
        }

        Double ret = initCurr/4.5;
        Toast.makeText(this, String.format("%.2f", ret), Toast.LENGTH_SHORT).show();
    }


    private void changeImage(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageButton);
        if (imageCount%2 == 0){
            image.setImageResource(R.drawable.bart);
            imageCount++;
        } else {
            image.setImageResource(R.drawable.homer);
            imageCount++;
        }

//        int id = view.getId();
//        String ourId = view.getResources().getResourceEntryName(id);
//
//        Log.i("id : ", ourId);
    }
}
