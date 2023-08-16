package com.example.recyclerview_and_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElements> elementsList;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBack = findViewById(R.id.btnAtras);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectSelectActivity();
            }
        });

        init();
    }

    public void init(){
        elementsList = new ArrayList<>();
        elementsList.add(new ListElements("#775447","Carlos","Juticalpa","Activo"));
        elementsList.add(new ListElements("#8e2913","Raul","Tegucigalpa","Inactivo"));
        elementsList.add(new ListElements("#775447","Melissa","San Jose","Activo"));
        elementsList.add(new ListElements("#5ce408","Juan","San Miguelito","Inactivo"));
        elementsList.add(new ListElements("#b50b7a","Angie","Las Colinas","Activo"));
        elementsList.add(new ListElements("#035410","Abigail","MiraFlores","Inactivo"));
        elementsList.add(new ListElements("#d3e30b","Paola","El Chimbo","Activo"));

        ListAdapter listAdapter = new ListAdapter(elementsList, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    void RedirectSelectActivity(){
        Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
        startActivity(intent);
    }
}