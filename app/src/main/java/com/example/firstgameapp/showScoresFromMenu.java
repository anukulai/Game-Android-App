package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showScoresFromMenu extends AppCompatActivity {

    private Button Back_To_Main_Page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scores_from_menu);

        Bundle bundle = getIntent().getExtras();
        String score = bundle.getString("answerA");
        int currentscore = bundle.getInt("Score");
        String numerator = bundle.getString("num");
        String denominator = bundle.getString("deno");


        TextView yourScore = (TextView) findViewById(R.id.yourScore);
        yourScore.setText("Your Score for Game A: \n"+currentscore);

        TextView yourScoreforGameB = (TextView) findViewById(R.id.yourScoreGameB);
        yourScoreforGameB.setText("Your Score for Game B: \n"+numerator+"/"+denominator);

        Back_To_Main_Page = (Button) findViewById(R.id.BackToMainPage);

        Back_To_Main_Page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMainPage();
            }
        });




//        ShowTest.setText("Your Score is: \n"+ currentscore+ "\n\n");

    }

    public void GoToMainPage(){
        Intent i = new Intent(this, Page2Activity.class);
        startActivity(i);
    }
}