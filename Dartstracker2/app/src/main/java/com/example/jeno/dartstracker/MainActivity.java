package com.example.jeno.dartstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.submit1);
        Button undoButton = findViewById(R.id.undo);
        TextView scoreBoard1 = findViewById(R.id.scoreBoard1);
        TextView scoreBoard2 = findViewById(R.id.scoreBoard2);
        TextView number1 = findViewById(R.id.number1);
        TextView number2 = findViewById(R.id.number2);
        TextView legCounter1 = findViewById(R.id.legnumber1);
        TextView legCounter2 = findViewById(R.id.legnumber2);

        final ScoreBoard scoreBoardFirst = new ScoreBoard(scoreBoard1);
        final ScoreBoard scoreBoardSecond = new ScoreBoard(scoreBoard2);
        final Player player1 = new Player("Józsi", number1, scoreBoardFirst, legCounter1);
        final Player player2 = new Player("Jenő", number2, scoreBoardSecond, legCounter2);
        final Switcher switcher = new Switcher(true, true);
        final ScoreHandler scoreHandler = new ScoreHandler(player1, player2, switcher);

        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input1 = findViewById(R.id.input1);
                int input = Integer.parseInt(input1.getText().toString());

                scoreHandler.handle(input);
                input1.setText("");
            }
        });

        undoButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}
