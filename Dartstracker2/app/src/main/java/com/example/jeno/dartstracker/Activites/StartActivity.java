package com.example.jeno.dartstracker.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jeno.dartstracker.Activites.MainActivity;
import com.example.jeno.dartstracker.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);

        final EditText playerName1 = findViewById(R.id.nameInput1);
        final EditText playerName2 = findViewById(R.id.nameInput2);
        Button newGame = findViewById(R.id.newgame);
        final RadioGroup radioGroup = findViewById(R.id.scoreGroup);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);

                nextScreen.putExtra("playerName1", playerName1.getText().toString());
                nextScreen.putExtra("playerName2", playerName2.getText().toString());

                //getting selected radio button
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                nextScreen.putExtra("clicked", radioButton.getText());

                startActivity(nextScreen);
            }
        });


    }
}
