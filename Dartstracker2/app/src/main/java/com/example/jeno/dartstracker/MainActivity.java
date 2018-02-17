package com.example.jeno.dartstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int startingScore = 501;
    private static final int scoreBoardLength = 5;
    private static List<Integer> scoreBoardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting the view elements

        Button button1 = (Button)findViewById(R.id.submit1);

        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView number1 = (TextView)findViewById(R.id.number1);
                EditText input1 = (EditText)findViewById(R.id.input1);
                TextView scoreBoard1 = (TextView)findViewById(R.id.scoreBoard1);
                int originalNumber = Integer.parseInt(number1.getText().toString());
                int inputNumber = Integer.parseInt(input1.getText().toString());

                scoreHandler(number1, scoreBoard1, originalNumber, inputNumber);
                input1.setText("");
            }
        });

    }

    // handles score calculations and
    // sets text field values accordingly
    public void scoreHandler(TextView scoreTextView, TextView scoreBoard, int originalScore, int inputScore){
        int result = originalScore - inputScore;
        if (result == 0){
            scoreTextView.setText(String.valueOf(startingScore));
            scoreBoardList.clear();
        } else if (result > 1 && inputScore <= 180){
            scoreTextView.setText(String.valueOf(result));
            scoreBoardList.add(inputScore);
        }
        buildScoreBoard(scoreBoard, scoreBoardList);
    }

    // clears scoreboard view
    public void clearScoreBoard(TextView scoreBoard){
        scoreBoard.setText("");
    }

    // builds up scoreboard view based on the current scores
    // makes sure we only show only the last 5 scores
    public void buildScoreBoard(TextView scoreBoard, List<Integer> scores){
        clearScoreBoard(scoreBoard);
        if (scores.size() < scoreBoardLength){
            for (Integer score: scores){
                scoreBoard.append(String.valueOf(score) + "\n");
            }
        } else {
            for (int i = scores.size() - scoreBoardLength; i < scores.size(); i++){
                scoreBoard.append(String.valueOf(scores.get(i)) + "\n");
            }
        }
    }

}
