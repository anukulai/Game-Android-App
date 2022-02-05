package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page2Activity extends AppCompatActivity {

    private Button btnGameB;
    private Button btnGameA;
    private Button ShowScore;
    private Button BacktoFirstPage;
    private String score = "", numerator = "", denominator = "";
    private int currentscore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);


        Bundle bundle = getIntent().getExtras();
//        String score = bundle.getString("answerA");
//        int currentscore = bundle.getInt("Score");
//        String numerator = bundle.getString("num");
//        String denominator = bundle.getString("deno");
        if (bundle != null) {
            if (bundle.get("answerA") != null)
                score = bundle.getString("answerA");
            if (bundle.get("Score")!=null)
                currentscore = bundle.getInt("Score");
            if(bundle.getString("num")!=null)
                numerator = bundle.getString("num");
            if(bundle.getString("deno")!=null)
                denominator = bundle.getString("deno");
    }
//

        btnGameB = (Button) findViewById(R.id.gameB);
        btnGameB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameBStartPage();
            }
        });

        btnGameA = (Button) findViewById(R.id.gameA);
        btnGameA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameAStartPage();
            }
        });

        ShowScore = (Button) findViewById(R.id.showScore);
        ShowScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScorePage(score, currentscore, numerator, denominator);
            }
        });

        BacktoFirstPage = (Button) findViewById(R.id.backfromPage2);
        BacktoFirstPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BacktoFirstPage();
            }
        });
    }
    public void openGameBStartPage(){
        Intent intent = new Intent(this, GamebActivity.class);
        startActivity(intent);
    }

    public void openGameAStartPage(){
        Intent i = new Intent(this, Questions.class);
        startActivity(i);
    }

    public void openScorePage(String score, Integer currentscore, String numerator, String denominator){
        Intent i = new Intent(this, showScoresFromMenu.class);
        Bundle bundle = new Bundle();
        bundle.putString("answerA", score);
        bundle.putInt("Score", currentscore);
        bundle.putString("num", numerator);
        bundle.putString("deno", denominator);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void BacktoFirstPage(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}