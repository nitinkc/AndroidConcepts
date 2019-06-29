package android.learning.nitin.androidconcepts.basics;

import android.content.Context;
import android.learning.nitin.androidconcepts.R;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class AudioActivity extends AppCompatActivity {

    MediaPlayer mp;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

      mp = MediaPlayer.create(this, R.raw.kid_laugh);
      audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
      int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
      int currVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

      SeekBar volBar = (SeekBar) findViewById(R.id.volBar);
      volBar.setMax(maxVol);
      volBar.setProgress(currVol);
      volBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Log.i("Volume Value : ", Integer.toString(i));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
                // Toast.makeText(MainActivity.this, "Volume : " + Integer.toString(i), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

      final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
      seekBar.setMax(mp.getDuration());
      new Timer().scheduleAtFixedRate(new TimerTask() {
          @Override
          public void run() {
              seekBar.setProgress(mp.getCurrentPosition());
          }
      },0, 100);

      seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
              //Log.i("Volume Value : ", Integer.toString(i));
              mp.seekTo(i);

          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });




    }

    public void playAudio(View v){
        mp.start();
    }

    public void pauseAudio(View v){
        mp.pause();
    }
}
