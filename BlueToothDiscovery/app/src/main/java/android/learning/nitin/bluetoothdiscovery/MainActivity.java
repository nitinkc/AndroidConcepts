package android.learning.nitin.bluetoothdiscovery;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends Activity {

    //Bluetooth adapter to be used for turning on and Off
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        setContentView(R.layout.activity_main);

        if(null != bluetoothAdapter){
            //if(b!luetoothAdapter.isEnabled()){
            if (bluetoothAdapter.getState() == BluetoothAdapter.STATE_ON) {
                Toast.makeText(getApplicationContext(), "Bluetooth is already ON", Toast.LENGTH_LONG).show();
            } else {
                Intent bluetoothRequestIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(bluetoothRequestIntent);
                Toast.makeText(getApplicationContext(), "Bluetooth was not ON, Turning ON at app startup", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void toggleBluetooth (View view) {
        if(bluetoothAdapter.isEnabled()){
            bluetoothAdapter.disable();
            Toast.makeText(getApplicationContext(), "Bluetooth turned OFF", Toast.LENGTH_LONG).show();
        }else {
            bluetoothAdapter.enable();
            Toast.makeText(getApplicationContext(), "Bluetooth turned ON", Toast.LENGTH_LONG).show();
        }
    }

    public void findDiscoverableDevices (View view) {
        Intent bluetoothRequestIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        //Force the app to be discoverable for 600 secs/10 mins
        bluetoothRequestIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,600);

        startActivity(bluetoothRequestIntent);
    }

    public void viewPairedDevices (View view) {
        if(!bluetoothAdapter.isEnabled()){
            Toast.makeText(getApplicationContext(), "Bluetooth turned off... Please turn it ON", Toast.LENGTH_LONG).show();
        }
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        ListView pairedDevicesListView = (ListView) findViewById(R.id.pairedDevicesListView);

        ArrayList pairedDevicesArrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : pairedDevices) {

            pairedDevicesArrayList.add(bluetoothDevice.getName());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pairedDevicesArrayList);

        pairedDevicesListView.setAdapter(arrayAdapter);
    }
}