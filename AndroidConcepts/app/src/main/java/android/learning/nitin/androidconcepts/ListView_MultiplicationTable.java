package android.learning.nitin.androidconcepts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class ListView_MultiplicationTable extends AppCompatActivity {

    ListView listView;

    private void generateTable(int position) {
        ArrayList<Integer> table = new ArrayList<>();



        for (int i = 1 ; i <= 10 ; i++) {
            table.add(position*i);
        }

        //Fill in the List
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,table);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout_table);
        listView = (ListView) findViewById(R.id.listView);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(7);
        generateTable(7);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b) {
                Log.i("Seek Value : ", Integer.toString(position));
                generateTable(position);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}
