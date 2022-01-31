package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Random;

public class RandomAnimalActivity extends AppCompatActivity {

    int counter = 0;
    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_animal);

        ImageView r = (ImageView) findViewById(R.id.RI);
        Random rand = new Random();
        Integer[] images = {
                R.drawable.m1,
                R.drawable.m2,
                R.drawable.m3,
                R.drawable.m4,
                R.drawable.m5,
                R.drawable.m6,
                R.drawable.m7,
                R.drawable.m8,
                R.drawable.m9
        };

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(counter > 60000){
                        System.exit(0);
                    }

                        counter = counter + time;
                        displayImage(r, images);
                        time = rand.nextInt(2000) + 1000;
                        handler.postDelayed(this, time);

                        System.out.println("In run Method"+counter);
                        handler.removeCallbacksAndMessages(null);
                        handler.postDelayed(this, time);

                }
            }, 1);

        }


    public void displayImage(ImageView r, Integer[] images){
        Random rand = new Random();
        r.setImageResource(images[rand.nextInt(images.length)]);
    }

    }

