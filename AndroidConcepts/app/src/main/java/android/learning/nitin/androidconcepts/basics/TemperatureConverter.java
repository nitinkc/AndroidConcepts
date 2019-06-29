package android.learning.nitin.androidconcepts.basics;

import android.learning.nitin.androidconcepts.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nitin on 3/19/18.
 */

public class TemperatureConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
    }

    public void convertTemperature(View view) {

        EditText tempC = (EditText) findViewById(R.id.degreeC);
        EditText tempF = (EditText) findViewById(R.id.degreeF);

        String celciusString = String.valueOf(tempC.getText());
        String fString = String.valueOf(tempF.getText());

        //Initialized to Default Value to avoid Number format exception
        Double celciusDouble = 0.0;
        Double fDouble = 0.0;

        try {
            celciusDouble = Double.parseDouble(celciusString);
            fDouble = Double.parseDouble(fString);
        }catch (NumberFormatException e){
            Log.i("Value" , fString);
        }
        // Celcius to Ferenheit : F = (9/5)*C + 32
        Double c2f = ((9 / 5) * celciusDouble) + 32;
        tempF.setText(Double.toString(c2f));

        // Ferenheit to Celcius (F - 32) x 5/9
        Double f2c = (fDouble - 32) * (5/9);

        Toast.makeText(this, String.format("%.2f", f2c), Toast.LENGTH_SHORT).show();

    }
}
