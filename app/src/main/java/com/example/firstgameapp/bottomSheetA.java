package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bottomSheetA extends AppCompatActivity {

    Button backbutton, showScore;
    String numerator;
    String denominator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        backbutton = (Button) findViewById(R.id.backhomebutton);
        Bundle bundle = getIntent().getExtras();
        String ans = bundle.getString("answerA");
        int currentscore = bundle.getInt("Score");


        TextView score = (TextView) findViewById(R.id.finalanswer);
        score.setText(ans);
        TextView ShowTest = (TextView) findViewById(R.id.Score);
        ShowTest.setText("Your Score is: \n"+ currentscore+ "\n\n");

        backbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                goBackToMenuPage(ans,currentscore);
//                System.exit(0);
//                System.out.println("BackButton");
                }
            });

    }
    public void goBackToMenuPage(String ans, Integer currentscore){
        Intent intent = new Intent(this, Page2Activity.class);
        Bundle bundle = new Bundle();

        bundle.putString("answerA", ans);
        bundle.putInt("Score", currentscore);
        intent.putExtras(bundle);
        startActivity(intent);
//        setContentView(R.layout.p);
//        startActivity(intent);

    }
}