package com.example.myapplication.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.models.BackgroundColor;

import java.util.Arrays;

public class MainActivity extends Activity {

    public final static String BACKGROUND_COLOR_KEY = "color";
    private Button bOk;
    private EditText etInputColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInputColor = findViewById(R.id.etInputColor);
        bOk = findViewById(R.id.bSubmit);
        bOk.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        Intent changeColorIntent = new Intent(this, ColorChangeActivity.class);
        changeColorIntent.putExtra(BACKGROUND_COLOR_KEY, findColorByName(etInputColor.getText().toString()));
        startActivity(changeColorIntent);
    }

    private BackgroundColor findColorByName(String colorName) {
        return Arrays.stream(BackgroundColor.values())
                .filter(color -> color.getColorName().equalsIgnoreCase(colorName))
                .findFirst().orElse(BackgroundColor.UNKNOWN_COLOR);
    }

}
