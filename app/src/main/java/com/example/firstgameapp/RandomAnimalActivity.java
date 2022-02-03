package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Random;

public class RandomAnimalActivity extends AppCompatActivity {

    int counter = 0;
    int time = 0;
    int answer = 0;

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

                    if(counter > 60){
                        System.out.println(answer-1);
                        Intent i = new Intent(getApplicationContext(), GameBUserInput.class);
                        Bundle bundle = new Bundle();
                        String ans = String.valueOf(answer);
                        bundle.putString("answer", ans);
                        i.putExtras(bundle);
                        startActivity(i);
                        setContentView(R.layout.activity_game_buser_input);
                        handler.removeCallbacksAndMessages(null);

                    }
                    else {
                        counter = counter + time;
                        answer = answer + 1;
                        displayImage(r, images);
                        time = rand.nextInt(2000) + 1000;
                        handler.postDelayed(this, time);

                        System.out.println("In run Method" + counter);
                        handler.removeCallbacksAndMessages(null);
                        handler.postDelayed(this, time);
                    }
//                        System.out.println(answer);

                }
            }, 1);

            System.out.println(answer);

        }


    public void displayImage(ImageView r, Integer[] images){
        Random rand = new Random();
        r.setImageResource(images[rand.nextInt(images.length)]);
    }

    }

