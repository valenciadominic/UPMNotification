package com.upm.activities;


import com.upm.upmnotification.*;
 
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;
 
public class VideoActivity extends Activity {
 
    // Declare variables
    ProgressDialog pDialog;
    VideoView videoview;
 
    // Insert your Video URL
    String VideoURL = "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from video_main.xml
        setContentView(R.layout.video_main);
        
        ActionBar ab = getActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FF8C00"));     
        ab.setBackgroundDrawable(colorDrawable);
        // Find your VideoView in your video_main.xml layout
        videoview = (VideoView) findViewById(R.id.video_view);
        // Execute StreamVideo AsyncTask
 
        // Create a progressbar
        pDialog = new ProgressDialog(VideoActivity.this);
        // Set progressbar title
        pDialog.setTitle("UPM Video");
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(true);
        // Show progressbar
        pDialog.show();
 
        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    VideoActivity.this);
            mediacontroller.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);
 
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
 
        videoview.requestFocus();
        videoview.setOnPreparedListener(new OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });
 
    }
 
}