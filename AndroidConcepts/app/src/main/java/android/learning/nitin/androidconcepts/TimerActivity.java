package android.learning.nitin.androidconcepts;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    TextView textView;
    MediaPlayer mp;
    public int timerValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        mp = MediaPlayer.create(this,R.raw.alarm);


        seekBar.setMax(20);
        seekBar.setProgress(10);
        textView.setText(String.valueOf(10));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(String.valueOf(i));
                timerValue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void startTimer(View view){

        new CountDownTimer(timerValue*1000,1000){
            @Override
            public void onTick(long l) {

                Log.i("Seconds Left", String.valueOf(l/1000));
                textView.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                Log.i("Timer done!!", "Countdown ends");
                textView.setText(String.valueOf(0.00));
                textView.animate().alpha(.4f);
                mp.start();
            }
        }.start();
    }
}