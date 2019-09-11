package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/**
 * This class is used to enable the usage of different icons in the same ScatterChart
 * <p>
 * When this class is used the global settings of the ScatterChart are ignored, so you should set colors, iconSize etc
 * all here and not in the chart itself.
 *
 * @author andreasguetz
 */
public class ShapeEntry
    extends Entry {

    private Drawable icon;

    private float iconSizeInPx;

    private final String tag;

    private boolean hasLine;

    private int lineColor;

    public ShapeEntry(float x, float y, Drawable icon, float iconSizeInPx, String tag) {
        super(x, y);
        this.icon = icon;
        this.iconSizeInPx = iconSizeInPx;
        this.tag = tag;
    }

    @Override
    public Drawable getIcon() {
        return icon;
    }

    @Override
    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public float getIconSizeInPx() {
        return iconSizeInPx;
    }

    public void setIconSizeInPx(float iconSizeInPx) {
        this.iconSizeInPx = iconSizeInPx;
    }

    /**
     * Can be used to group similar entries, e.g. changing the icon of a specific type
     */
    public String getTag() {
        return tag;
    }

    public void setHasLine(boolean hasLine) {
        this.hasLine = hasLine;
    }

    /**
     * BEWARE: When set, it enforces the centering of the entry along the x-axis.
     * This is needed to stop flickering of the entry while scrolling.
     *
     * @return When set, a line is drawn from the position of the entry to the top
     */
    public boolean hasLine() {
        return hasLine;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeEntry that = (ShapeEntry) o;
        return Float.compare(that.iconSizeInPx, iconSizeInPx) == 0 &&
            Float.compare(that.getX(), getX()) == 0 &&
            Float.compare(that.getY(), getY()) == 0 &&
            icon.equals(that.icon) &&
            tag.equals(that.tag);
    }

    @Override
    public int hashCode() {
        int hashCode = (int) getX() + (int) getY() + (int) getIconSizeInPx() + lineColor;
        if (icon != null) hashCode += icon.hashCode();
        if (tag != null) hashCode += tag.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "ShapeEntry{" +
            " x=" + getX() +
            ", y=" + getY() +
            ", icon=" + icon +
            ", iconSizeInPx=" + iconSizeInPx +
            ", tag='" + tag + '\'' +
            '}';
    }
}