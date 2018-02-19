package com.example.jeno.dartstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private static final int startingScore = 501;
    private static final int maxScore = 180;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting the view elements
        Button button1 = (Button)findViewById(R.id.submit1);
        TextView scoreBoard1 = (TextView)findViewById(R.id.scoreBoard1);
        TextView scoreBoard2 = (TextView)findViewById(R.id.scoreBoard2);
        TextView number1 = (TextView)findViewById(R.id.number1);
        TextView number2 = (TextView)findViewById(R.id.number2);
        EditText input1 = (EditText)findViewById(R.id.input1);


        // and building objects based on them
        final ScoreBoard scoreBoardFirst = new ScoreBoard(scoreBoard1);
        final ScoreBoard scoreBoardSecond = new ScoreBoard(scoreBoard2);
        final ScoreHandler scoreHandler = new ScoreHandler(scoreBoardFirst, scoreBoardSecond, number1, number2, input1);

        //OK button event listener
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
            TextView number1 = (TextView)findViewById(R.id.number1);
            TextView number2 = (TextView)findViewById(R.id.number2);
            EditText input1 = (EditText)findViewById(R.id.input1);

            int originalScore1 = Integer.parseInt(number1.getText().toString());
            int originalScore2 = Integer.parseInt(number2.getText().toString());
            int input = Integer.parseInt(input1.getText().toString());

            scoreHandler.handle(originalScore1, originalScore2, input);
            input1.setText("");
            }
        });

    }
}
