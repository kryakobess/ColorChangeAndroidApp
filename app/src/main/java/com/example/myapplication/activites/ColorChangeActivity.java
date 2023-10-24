package com.example.myapplication.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.models.BackgroundColor;

public class ColorChangeActivity extends Activity {

    private TextView warningTextView;
    private Button backButton;
    private final static String UNKNOWN_COLOR_TEXT = "You wrote unknown color!\nPlease return to the main page and try again.";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_change);
        warningTextView = findViewById(R.id.unknownColorText);
        backButton = findViewById(R.id.btBack);
        backButton.setOnClickListener(this::onClick);
        changeColor();
    }

    public void onClick(View v) {
        Intent toMainIntent = new Intent(this, MainActivity.class);
        startActivity(toMainIntent);
    }

    private void changeColor() {
        Intent intent = getIntent();
        BackgroundColor color = (BackgroundColor) intent.getExtras().get(MainActivity.BACKGROUND_COLOR_KEY);
        if (color == null || color == BackgroundColor.UNKNOWN_COLOR) {
            warningTextView.setText(UNKNOWN_COLOR_TEXT);
            return;
        }
        getWindow().getDecorView().setBackgroundColor(color.getColorCode());
    }
}
