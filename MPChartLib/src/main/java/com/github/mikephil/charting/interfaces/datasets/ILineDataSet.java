package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;

/**
 * Created by Philpp Jahoda on 21/10/15.
 */
public interface ILineDataSet
    extends ILineRadarDataSet<Entry> {

    /**
     * Returns the drawing mode for this line dataset
     *
     * @return
     */
    LineDataSet.Mode getMode();

    /**
     * Returns the intensity of the cubic lines (the effect intensity).
     * Max = 1f = very cubic, Min = 0.05f = low cubic effect, Default: 0.2f
     *
     * @return
     */
    float getCubicIntensity();

    @Deprecated
    boolean isDrawCubicEnabled();

    @Deprecated
    boolean isDrawSteppedEnabled();

    /**
     * Returns the size of the drawn circles.
     */
    float getCircleRadius();

    /**
     * Returns the hole radius of the drawn circles.
     */
    float getCircleHoleRadius();

    /**
     * Returns the color at the given index of the DataSet's circle-color array.
     * Performs a IndexOutOfBounds check by modulus.
     *
     * @param index
     * @return
     */
    int getCircleColor(int index);

    /**
     * Returns the number of colors in this DataSet's circle-color array.
     *
     * @return
     */
    int getCircleColorCount();

    /**
     * Returns true if drawing circles for this DataSet is enabled, false if not
     *
     * @return
     */
    boolean isDrawCirclesEnabled();

    /**
     * Returns the color of the inner circle (the circle-hole).
     *
     * @return
     */
    int getCircleHoleColor();

    /**
     * Returns true if drawing the circle-holes is enabled, false if not.
     *
     * @return
     */
    boolean isDrawCircleHoleEnabled();

    /**
     * Returns the DashPathEffect that is used for drawing the lines.
     *
     * @return
     */
    DashPathEffect getDashPathEffect();

    /**
     * Returns true if the dashed-line effect is enabled, false if not.
     * If the DashPathEffect object is null, also return false here.
     *
     * @return
     */
    boolean isDashedLineEnabled();

    /**
     * Returns the IFillFormatter that is set for this DataSet.
     *
     * @return
     */
    IFillFormatter getFillFormatter();

    int[] getRangeColors();
    
    /**
	 * CAUTION: Experimental API, not everything might work as you expect it!
     * Colors are set as gradient as according to our use case only.
     *
     * Always call {@link #setRangeValues} too!
     *
     * @param rangeColors 3 colors have to be set, which are used for the linear gradient.
     */
    void setRangeColors(int[] rangeColors);
    
    float[] getRangeValues();
    
    /**
     * CAUTION: Experimental API, not everything might work as you expect it!
	 * Colors are set as gradient as according to our use case only.
     * Calling this method on a dataset ignores its {@link #getColor()} and draws the gradient
     * colors of {@link #getRangeColors()} instead.
     *
     * Always call {@link #setRangeColors} too!
     *
     * @param rangeValues 4 range values have to be set the correspond to ranges on the y axis
     */
    void setRangeValues(float[] rangeValues);
    
    /**
     * @return cap specifies how the start and end of lines are drawn
     */
    Paint.Cap getStrokeCap();
    
    void setStrokeCap(Paint.Cap strokeCap);
}