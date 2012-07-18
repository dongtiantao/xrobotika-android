package org.dyrio.android.application2;

import android.os.Bundle;

import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.media.MediaPlayer;
import android.net.Uri;

public class MainActivity extends Activity {

	private MediaPlayer mediaPlayer;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playMusicFromWeb();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void playMusicFromWeb() {
    	try {
    		Uri uri = Uri.parse("http://www.perlgurl.org/podcast/archives"
    				+ "/podcasts/PerlgurlPromo.mp3");
    		mediaPlayer = MediaPlayer.create(this, uri);
    		mediaPlayer.start();
    	} catch (Exception e) {
    		Log.e("Debug", "Player failed", e);
    	}
    }
    
    protected void onStop() {
    	if (mediaPlayer != null) {
    		mediaPlayer.stop();
    		mediaPlayer.release();
    	}
    	super.onStop();
    }
    
}
