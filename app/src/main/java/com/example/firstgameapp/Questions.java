//This Activity includes
//functions for 5 quiz questions
//Answers are bundled and sent using intent to the next activity

package com.example.firstgameapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;
import android.os.Bundle;

public class Questions extends AppCompatActivity {
    private TextView mainquestion,questionnumber;
    private Button optionbtn1, optionbtn2,optionbtn3,showscore,backbutton;
    private ArrayList<QuizModel> quizModelArrayList;
    private ArrayList user_input,trueanswers;
    Random random;
    int currentscore = 0, questionAttempted = 1, currentpos=0;
    private Button GameAResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final RelativeLayout relativeLayout;
        mainquestion = (TextView) findViewById(R.id.Question);
        questionnumber = (TextView) findViewById(R.id.QuestionsAttempted);
        optionbtn1 = (Button) findViewById(R.id.Option1);
        optionbtn2 = (Button) findViewById(R.id.Option2);
        optionbtn3 = (Button) findViewById(R.id.Option3);
//        showscore = (Button) findViewById(R.id.showscore);
        backbutton = (Button) findViewById(R.id.backhomebutton);
        relativeLayout = findViewById(R.id.rv);

        quizModelArrayList = new ArrayList<>();
        user_input = new ArrayList<>();
        trueanswers = new ArrayList();
        random = new Random();
        getquizquestion(quizModelArrayList);
//        currentpos = random.nextInt(quizModelArrayList.size());
//        currentpos++;
        setdatatoviews(currentpos);

        optionbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setBackgroundResource(R.color.pink);

                if (quizModelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(optionbtn1.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                    trueanswers.add("True");
                }
                else {
                    trueanswers.add("False");
                }
                user_input.add(optionbtn1.getText().toString());







                questionAttempted++;
//                currentpos = random.nextInt(quizModelArrayList.size());
                currentpos++;
                setdatatoviews(currentpos);

            }
        });
        optionbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setBackgroundResource(R.color.blue);
                if (quizModelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(optionbtn2.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                    trueanswers.add("True");
                }
                else {
                    trueanswers.add("False");
                }
                user_input.add(optionbtn2.getText().toString());

                questionAttempted++;
                currentpos++;
//                currentpos = random.nextInt(quizModelArrayList.size());
                setdatatoviews(currentpos);
//                currentpos++;

            }
        });

        optionbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setBackgroundResource(R.color.yellow);
                if (quizModelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(optionbtn3.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                    trueanswers.add("True");

                }
                else {
                    trueanswers.add("False");
                }
                user_input.add(optionbtn3.getText().toString());

                questionAttempted++;
//                currentpos = random.nextInt(quizModelArrayList.size());
                currentpos++;
                setdatatoviews(currentpos);


            }
        });




    }

    private void finalanswers (){
        String s = "";

        for (int i=0; i<user_input.size(); i++){
            s = s+ user_input.get(i)+ " "+ trueanswers.get(i)+ "\n";
        }
    }
    private void showResults(){
//        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Questions.this);
//        View DisplayScores = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.LLScore));
//        TextView scoreTV = DisplayScores.findViewById(R.id.Score);
//        TextView finalans = DisplayScores.findViewById(R.id.finalanswer);
        String s = "";

        for (int i=0; i<user_input.size(); i++){
            s = s+ user_input.get(i)+ " "+ trueanswers.get(i)+ "\n";
        }
        s = "Correct Answers Your Answers T/F \n";
        ArrayList<String> correctans = new ArrayList<String>();
        correctans.add("FileServer");
        correctans.add("STP");
        correctans.add("Sun");
        correctans.add("Pacific Ocean");
        correctans.add("Agoraphobia");


        for (int i=0; i<user_input.size(); i++){
            s = s.concat(correctans.get(i)+" "+ user_input.get(i)+ " " + trueanswers.get(i).toString()+ "\n");
            System.out.println("answers: "+s);
        }

        Intent i = new Intent(getApplicationContext(), bottomSheetA.class);
        Bundle bundle = new Bundle();

        bundle.putString("answerA", s);
        bundle.putInt("Score", currentscore);
        i.putExtras(bundle);
        startActivity(i);
        setContentView(R.layout.activity_bottom_sheet);
//
//        GameAResult = (Button) findViewById(R.id.startGameB);
//        GameAResult.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openScoreForA();
//            }
//        });
//
//        scoreTV.setText("Your Score is \n" +currentscore+"/5");
//        finalans.setText(s);




//        bottomSheetDialog.setCancelable(false);
//        bottomSheetDialog.setContentView(DisplayScores);
////        bottomSheetDialog.show();
//
//        if(user_input.size()== 5){
//            backbutton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                goBackToMenuPage();
////                System.exit(0);
////                System.out.println("BackButton");
//                }
//            });
//        }

    }

//    public void backbuttonpage(){
//        Intent i = new Intent(this, Backbutton.class);
//        startActivity(i);
//    }

    private void setdatatoviews(int currentpos) {
        /*questionnumber.setText("Questions Attempted:"+questionAttempted+"/5");*/

        if (questionAttempted == 6) {
            showResults();
            System.out.println(user_input.get(0));
//            backbutton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                goBackToMenuPage();
////                System.exit(0);
////                System.out.println("BackButton");
//                }
//            });
        }
        else {
            mainquestion.setText(quizModelArrayList.get(currentpos).getQuestion());
            optionbtn1.setText(quizModelArrayList.get(currentpos).getOption1());
            optionbtn2.setText(quizModelArrayList.get(currentpos).getOption2());
            optionbtn3.setText(quizModelArrayList.get(currentpos).getOption3());
        }



    }
    private void getquizquestion(ArrayList<QuizModel> quizModelArrayList) {

        quizModelArrayList.add(new QuizModel("The main computer that stores the files that can be sent to computers that are networked together is:","MotherBoard","Peripheral","FileServer","FileServer"));
        quizModelArrayList.add(new QuizModel("Which is not an Internet protocol?","HTTP","STP","FTP","STP"));
        quizModelArrayList.add(new QuizModel("Which company created the most used networking software in the 1980's?","Microsoft","IBM","Sun","Sun"));
        quizModelArrayList.add(new QuizModel("In 1768, Captain James Cook set out to explore which ocean?","PacificOcean","AtlanticOcean","IndianOcean","PacificOcean"));
        quizModelArrayList.add(new QuizModel("Which of the following disorders is the fear of being alone?","Aerophobia","Acrophobia","Agoraphobia","Agoraphobia"));

    }

//    public void goBackToMenuPage(){
//        Intent intent = new Intent(this, Page2Activity.class);
//        startActivity(intent);
//    }
    public void openScoreForA(){
        Intent intent = new Intent(this, RandomAnimalActivity.class);
        startActivity(intent);
    }

}

