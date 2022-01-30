package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;

import android.content.Intent;
import android.view.View;

import android.widget.Button;

import android.view.View.OnClickListener;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.okButton);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage2();
            }
        });
    }
    public void openPage2(){
        Intent intent = new Intent(this, Page2Activity.class);
        startActivity(intent);
    }
}