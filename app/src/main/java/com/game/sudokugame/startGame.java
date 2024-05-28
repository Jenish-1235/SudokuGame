package com.game.sudokugame;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class startGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent startGame = getIntent();
        String playerNameValue = startGame.getStringExtra("playerName");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView welcomeMessage = findViewById(R.id.welcomeMessage);

        welcomeMessage.setText("Welcome\n" + playerNameValue);

        ImageView startGameButton = findViewById(R.id.startGameButton);
        ImageView settingsButton = findViewById(R.id.settingsButton);
        ImageView soundButton = findViewById(R.id.soundButton);

        startGameButton.setOnClickListener(v -> {
            Intent intent = new Intent(startGame.this, mainGameActivity.class);
            startActivity(intent);
        });

        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(startGame.this, settings.class);
            startActivity(intent);
        });





    }
}