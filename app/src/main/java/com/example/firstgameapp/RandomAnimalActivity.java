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
                R.drawable.dog1,
                R.drawable.dog2,
                R.drawable.dog3,
                R.drawable.dog4,
                R.drawable.dog5,
                R.drawable.dog6,
                R.drawable.dog7,
                R.drawable.dog8,
                R.drawable.dog9,
                R.drawable.dog10,
                R.drawable.dog11,
                R.drawable.dog12,
                R.drawable.dog13,
                R.drawable.dog14,
                R.drawable.dog15,
                R.drawable.dog16
        };

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(counter > 60000){
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

