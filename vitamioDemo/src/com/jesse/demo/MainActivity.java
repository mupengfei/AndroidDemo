package com.jesse.demo;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.widget.MediaController;
//import android.widget.VideoView;
//import android.media.MediaPlayer;



import com.jesse.vitamiodemo.R;

public class MainActivity extends Activity {
	private VideoView videoView;
	private String path = "http://live.3gv.ifeng.com/zixun.m3u8";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_video_layout);
		videoView = (VideoView) this.findViewById(R.id.video_view);
		MediaController mediaController =new MediaController(this);
		videoView.setMediaController(mediaController);
		mediaController.setMediaPlayer(videoView);
		videoView.requestFocus();
		videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {  
            
            @Override  
            public boolean onError(MediaPlayer mp, int what, int extra) {  
                Log.e("通知", "播放中出现错误"); 
                return false;  
            }  
        }); 

		videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mediaPlayer) {
				// optional need Vitamio 4.0
				mediaPlayer.setPlaybackSpeed(1.0f);
			}
		});
//		Intent intent = new Intent(this, VideoViewDemo.class);
//		this.startActivity(intent);
	}
	
	public void startPlay(View view) {
	    	videoView.setVideoPath(path);
	    	videoView.getCurrentFrame();
    }
}
