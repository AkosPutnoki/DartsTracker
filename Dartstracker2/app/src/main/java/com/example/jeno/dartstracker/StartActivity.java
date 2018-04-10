package com.example.jeno.dartstracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);

        final EditText playerName1 = findViewById(R.id.nameInput1);
        final EditText playerName2 = findViewById(R.id.nameInput2);
        Button newGame = findViewById(R.id.newgame);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);

                nextScreen.putExtra("playerName1", playerName1.getText().toString());
                nextScreen.putExtra("playerName2", playerName2.getText().toString());

                startActivity(nextScreen);
            }
        });


    }
}
