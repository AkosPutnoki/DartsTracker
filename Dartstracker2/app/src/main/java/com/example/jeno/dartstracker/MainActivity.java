package com.example.jeno.dartstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int startingScore = 501;

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
                int originalNumber = Integer.parseInt(number1.getText().toString());
                int inputNumber = Integer.parseInt(input1.getText().toString());

                scoreHandler(number1, originalNumber, inputNumber);
            }
        });

    }

    public void scoreHandler(TextView scoreTextView, int originalScore, int inputScore){
        int result = originalScore - inputScore;
        if (result == 0){
            scoreTextView.setText(String.valueOf(startingScore));
        } else if (result > 0){
            scoreTextView.setText(String.valueOf(result));
        }
    }
}