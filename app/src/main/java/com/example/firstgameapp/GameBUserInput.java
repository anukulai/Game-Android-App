package com.example.firstgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameBUserInput extends AppCompatActivity {

    EditText submitted_answer;
    Button submitButton, backbutton;
    String numerator;
    String denominator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_buser_input);

        submitted_answer = (EditText) findViewById(R.id.textInputId);
        submitButton = (Button) findViewById(R.id.submitButton);
        Bundle bundle = getIntent().getExtras();
        denominator = bundle.getString("answer");

        backbutton = (Button) findViewById(R.id.GoToMenu);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        numerator = submitted_answer.getText().toString();
                        System.out.println(numerator);
                        TextView score = (TextView) findViewById(R.id.answerDisplay);
                        score.setText("Your Score is : "+numerator+"/"+denominator);
                    }
                }
        );

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMenuPage(numerator, denominator);
            }
        });



    }

    public void goBackToMenuPage(String numerator, String denominator){
        Intent intent = new Intent(this, Page2Activity.class);
        Bundle bundle = new Bundle();

        bundle.putString("num", numerator);
        bundle.putString("deno", denominator);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}