package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GamebActivity extends AppCompatActivity {

    private Button startGameB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameb);

        startGameB = (Button) findViewById(R.id.startGameB);
        startGameB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameB();
            }
        });
    }
    public void openGameB(){
        Intent intent = new Intent(this, RandomAnimalActivity.class);
        startActivity(intent);
    }
}
