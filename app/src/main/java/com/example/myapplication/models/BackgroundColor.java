package com.example.myapplication.models;

import android.graphics.Color;

public enum BackgroundColor {
    RED("Red", Color.RED),
    BLUE("Blue", Color.BLUE),
    GREEN("Green", Color.GREEN),
    UNKNOWN_COLOR("Unknown", Color.WHITE);

    private final String colorName;
    private final int colorCode;

    BackgroundColor(String colorName, int colorCode) {
        this.colorName = colorName;
        this.colorCode = colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public int getColorCode() {
        return colorCode;
    }
}
