package com.example.michaelchheang.mathfortoys;

import android.net.Uri;
import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoPlayer extends AppCompatActivity{
    Button clk;
    VideoView videos;
    MediaController media;
    private static int videoLevel;
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoplayer);
        clk = (Button) findViewById(R.id.videoPlayButton);
        videos = (VideoView) findViewById(R.id.video);
        media = new MediaController(this);
    }

    public void videoPlay(View v){
        String videoPath;
        switch(videoLevel) {
            case 0:
                videoPath = "android.resource://com.example.michaelchheang.mathfortoys/" + R.raw.add;
                break;
            case 1:
                videoPath = "android.resource://com.example.michaelchheang.mathfortoys/" + R.raw.sub;
                break;
            case 2:
                videoPath = "android.resource://com.example.michaelchheang.mathfortoys/" + R.raw.mult;
                break;
            case 3:
                videoPath = "android.resource://com.example.michaelchheang.mathfortoys/" + R.raw.div;
                break;
            default:
                videoPath = "android.resource://com.example.michaelchheang.mathfortoys/" + R.raw.mult;

        }
        Uri uri = Uri.parse(videoPath);
        videos.setVideoURI(uri);
        videos.setMediaController(media);
        media.setAnchorView(videos);

        videos.start();
    }
    public void setVideo(int n){
        videoLevel = n;
    }

}
