package com.example.recyclerview_and_cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview_and_cardview.videoview.VideoViewActivity;

public class SelectActivity extends AppCompatActivity {

    Button btnRecyclerView_and_CardView, btnVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        btnRecyclerView_and_CardView = findViewById(R.id.btnRC);
        btnVideoView = findViewById(R.id.btnV);

        btnVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectVideoView();
            }
        });

        btnRecyclerView_and_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectRecyclerAndCard_view();
            }
        });
    }

    void RedirectVideoView(){
        Intent intent = new Intent(getApplicationContext(), VideoViewActivity.class);
        startActivity(intent);
    }

    void RedirectRecyclerAndCard_view(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}