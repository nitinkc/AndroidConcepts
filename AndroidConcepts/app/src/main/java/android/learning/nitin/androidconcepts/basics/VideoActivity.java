package android.learning.nitin.androidconcepts.basics;

import android.learning.nitin.androidconcepts.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView v = (VideoView) findViewById(R.id.videoView);
        v.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.christmas);

        //v.setVideoPath("https://www.youtube.com/watch?v=C94ZthnZcvQ");

        MediaController mc = new MediaController(this);

        mc.setAnchorView(v);

        v.setMediaController(mc);
        v.start();
    }
}
