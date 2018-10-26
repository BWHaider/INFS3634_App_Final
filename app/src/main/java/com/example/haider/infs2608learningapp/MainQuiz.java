package com.example.haider.infs2608learningapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainQuiz extends AppCompatActivity {

    TextView questionSection, questionCountSection, scoreSection;
    EditText answerSection;
    Button submitButton;
    ProgressBar topProgressBar;

    //array list of Question Model created
    ArrayList<QuestionModel> questionModelArraylist;

    //declares current position of the question
    int currentPosition = 0;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);


        questionCountSection = findViewById(R.id.noQuestion);
        questionSection = findViewById(R.id.questionBox);
        scoreSection = findViewById(R.id.score);

        answerSection = findViewById(R.id.answerBox);
        submitButton = findViewById(R.id.submitButton);
        topProgressBar = findViewById(R.id.progress);

        //initalises question array list
        questionModelArraylist = new ArrayList<>();

        setUpQuestion();

        setData();

        //checks answer upon submit button be clicked
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer();
            }
        });

        answerSection.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // If the event is a key-down event on the "enter" button
                Log.e("event.getAction()", event.getAction() + "");
                Log.e("event.keyCode()", keyCode + "");
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    checkAnswer();
                    return true;
                }
                return false;
            }
        });

    }

    //checks users response to display a "Correct!" message or an "Incorrect" answer (once the submit button is hit)
    // "Incorrect" answers are followed by feedback with the correct answer"
    public void checkAnswer() {
        String answerString = answerSection.getText().toString().trim();

// when answer is correct, number of correct answers at the top right increases
        if (answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswers())) {
            correctAnswers++;


            new SweetAlertDialog(MainQuiz.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("")
                    .setContentText("Correct!")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition++;

                            setData();
                            answerSection.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();


        } else {
//feedback provided in opo-up upon answering question incorrectly
            new SweetAlertDialog(MainQuiz.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Incorrect")
                    .setContentText("The correct answer is: " + questionModelArraylist.get(currentPosition).getAnswers())
                    .setConfirmText("Okay")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();

                            // current position of the quiz to be changed after every question
                            currentPosition++;

                            setData();
                            answerSection.setText("");
                        }
                    })
                    .show();
        }


        int x = ((currentPosition + 1) * 100) / questionModelArraylist.size();

        // progress is moved forward per question answered
        topProgressBar.setProgress(x);


    }

    //creation of 20 question and answers to be inserted into the array list for the quiz component
    public void setUpQuestion() {


        questionModelArraylist.add(new QuestionModel("True or False: DBMS stands for Database Management System ", "True"));// ch. 1
        questionModelArraylist.add(new QuestionModel("SELECT Statement Aggregates - COUNT, SUM, MIN, MAX, and? ", "AVG"));
        questionModelArraylist.add(new QuestionModel("Which step of the Database System Development Lifecycle helps identify that the features of a system work adequately? ", "Prototyping"));
        questionModelArraylist.add(new QuestionModel("What is the name of the rows in a relational model? ", "Tuples"));
        questionModelArraylist.add(new QuestionModel("Authentication or Authorisation: process of determining whether a user is, who he or she claims to be? ", "Authentication"));
        questionModelArraylist.add(new QuestionModel("True or Flase, are these the ACID properties: Atomicity, Consistency, Durability and Integrity? ", "False"));
        questionModelArraylist.add(new QuestionModel("What does XML stand for?", "Extensible Markup Language"));
        questionModelArraylist.add(new QuestionModel("True or False, competitive advantage is a benefit of data warehousing?", "True"));
        questionModelArraylist.add(new QuestionModel("True or False, are these the three V's of Big Data: Velocity, Variety and Volume? ", "True"));
        questionModelArraylist.add(new QuestionModel("What allows the user to have their own perspective of a database?", "Views"));// ch. 1
        questionModelArraylist.add(new QuestionModel("Does DML or DDL retrieve and update data? ", "DML"));
        questionModelArraylist.add(new QuestionModel("Which step of the Database System Development Lifecycle describes the scope and boundaries of the database system and the major user views?", "Systems Definition"));
        questionModelArraylist.add(new QuestionModel("What is the candidate key selected to identify tuples uniquely within a relation? ", "Primary Key"));
        questionModelArraylist.add(new QuestionModel("What does 'DAC' stand for? ", "Discretionary Access Control"));
        questionModelArraylist.add(new QuestionModel("What is the final key concept explored in concurrency control? ", "Timestamping"));
        questionModelArraylist.add(new QuestionModel("What is the term for software that mediates with other software and allows for communication between disparate applications in a heterogeneous system? ", "Middleware"));
        questionModelArraylist.add(new QuestionModel("True or false: ODS stands for Optional Data Storage", "False"));
        questionModelArraylist.add(new QuestionModel("True or false: Big data can be analysed using a RDBMS ", "False"));
        questionModelArraylist.add(new QuestionModel("What is DML?", "Data Manipulation Language"));// ch.1
        questionModelArraylist.add(new QuestionModel("True or False: Validity is an additional V of big data? ", "True"));// random chapter


    }

    // function created where we set the data
    public void setData() {

//gets question text and other data if true, otherwise a quiz complete message appears
        if (questionModelArraylist.size() > currentPosition) {

            //gets the text of current question, and the questions answer
//            questionSection.setText(questionModelArraylist.get(currentPosition).getQuestions());
            questionSection.setText(questionModelArraylist.get(currentPosition).getQuestions());

            //changes the text of the users current score and the current question number
            //as displayed on the top of the activity
            scoreSection.setText("Score :" + correctAnswers + "/" + questionModelArraylist.size());
            questionCountSection.setText("Question No: " + (currentPosition + 1));


        } else {

//provides pop-up with a final dialogue stating that the quiz is complete, with your corresponding score
// upon retrying quiz, the  score and progress in the bar is reset to 0
            new SweetAlertDialog(MainQuiz.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Quiz Complete!")
                    .setContentText("Final Score: " + correctAnswers + "/" + questionModelArraylist.size())
                    .setConfirmText("Retry Quiz")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {

                        //when retry quiz is clicked, everything set back to 0 for re-attempt
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            currentPosition = 0;
                            correctAnswers = 0;
                            topProgressBar.setProgress(0);
                            setData();
                        }
                    })

                    // quiz is closed, user sent back to previous chapter readings/menu
                    .setCancelText("Close")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            finish();
                        }
                    })
                    .show();

        }

    }


}
