package com.github.mikephil.charting.components;

import androidx.annotation.ColorInt;

public final class TargetBackground {
    private final float targetLower;
    private final float targetUpper;
    private final int color;

    public float getTargetLower() {
        return targetLower;
    }

    public float getTargetUpper() {
        return targetUpper;
    }

    @ColorInt
    public int getColor() {
        return color;
    }

    public TargetBackground(float targetLower, float targetUpper, @ColorInt int color) {
        this.targetLower = targetLower;
        this.targetUpper = targetUpper;
        this.color = color;
    }
}
