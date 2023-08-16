package com.example.recyclerview_and_cardview.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.recyclerview_and_cardview.R;
import com.example.recyclerview_and_cardview.SelectActivity;
import com.google.android.mediahome.video.PreviewProgram;

public class VideoViewActivity extends AppCompatActivity {

    VideoView videoView;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = findViewById(R.id.videoView);
        btnBack = findViewById(R.id.btnRegresar);

        LoadVideo();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectSelectActivity();
            }
        });

    }

    void RedirectSelectActivity(){
        Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
        startActivity(intent);
    }

    void LoadVideo(){
        String path = "android.resource://" + getPackageName() + "/" + R.raw.YOUR_VIDEO;


        Uri uri = Uri.parse(path);
        PreviewProgram.Builder builder = new PreviewProgram.Builder();

        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}