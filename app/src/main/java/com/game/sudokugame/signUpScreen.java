package com.game.sudokugame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class signUpScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputEditText playerName = findViewById(R.id.playerName);
        Button playButton = findViewById(R.id.playButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView profilePicture = findViewById(R.id.profilePicture);

        Intent startGame = new Intent(getApplicationContext(), startGame.class);





        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerNameValue = playerName.getText().toString();


//                if (playerNameValue.isEmpty()) {

//                }
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                sharedPreferences.edit().putString("playerName", playerNameValue).apply();


                if (sharedPreferences.getString("playerName", "").isEmpty()){
//                    Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                    if(playerNameValue.isEmpty()){
                        playerName.requestFocus();
                        playerName.setError(
                                "Please enter your name"
                        );
                    }
                }else{


                    startGame.putExtra("playerName", playerNameValue);
                    startActivity(startGame);

                }
            }
        });
    }
}