package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ShapeEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ScatterChartRenderer
    extends LineScatterCandleRadarRenderer {

    protected ScatterDataProvider mChart;

    public ScatterChartRenderer(ScatterDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        mChart = chart;
    }

    @Override
    public void initBuffers() {
    }

    @Override
    public void drawData(Canvas c) {

        ScatterData scatterData = mChart.getScatterData();

        for (IScatterDataSet set : scatterData.getDataSets()) {

            if (set.isVisible()) {
                drawDataSet(c, set);
            }
        }
    }

    private float[] mPixelBuffer = new float[2];

    protected void drawDataSet(Canvas c, IScatterDataSet dataSet) {

        if (dataSet.getEntryCount() < 1) {
            return;
        }

        ViewPortHandler viewPortHandler = mViewPortHandler;

        Transformer trans = mChart.getTransformer(dataSet.getAxisDependency());

        float phaseY = mAnimator.getPhaseY();

        IShapeRenderer renderer = dataSet.getShapeRenderer();

        int max = (int) (Math.min(
            Math.ceil((float) dataSet.getEntryCount() * mAnimator.getPhaseX()),
            (float) dataSet.getEntryCount()));

        for (int i = 0; i < max; i++) {

            Entry e = dataSet.getEntryForIndex(i);

            mPixelBuffer[0] = e.getX();
            mPixelBuffer[1] = e.getY() * phaseY;


            trans.pointValuesToPixel(mPixelBuffer);

            if (!viewPortHandler.isInBoundsRight(mPixelBuffer[0])) {
                break;
            }

            if (!viewPortHandler.isInBoundsLeft(mPixelBuffer[0])
                || !viewPortHandler.isInBoundsY(mPixelBuffer[1])) {
                continue;
            }

            if (e instanceof ShapeEntry) {
                ShapeEntry shapeEntry = (ShapeEntry) e;
                if (shapeEntry.hasLine()) {
                    mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(1));
                    mRenderPaint.setColor(shapeEntry.getLineColor());
                    // Using always the center of viewport to show entries with indicator
                    mPixelBuffer[0] = mViewPortHandler.contentWidth() / 2;
                    c.drawLine(mPixelBuffer[0], mPixelBuffer[1], mPixelBuffer[0], mViewPortHandler.contentTop(), mRenderPaint);
                }
                float iconSizePx = shapeEntry.getIconSizeInPx();
                Drawable icon = shapeEntry.getIcon();
                if (icon != null) {
                    Utils.drawImage(c,
                        icon,
                        mPixelBuffer[0],
                        mPixelBuffer[1],
                        iconSizePx,
                        iconSizePx);
                }
            } else {
                mRenderPaint.setColor(dataSet.getColor(i / 2));
                renderer.renderShape(
                    c, dataSet, mViewPortHandler,
                    mPixelBuffer[0], mPixelBuffer[1],
                    mRenderPaint);
            }
        }
    }

    @Override
    public void drawValues(Canvas c) {
        // Not used!
    }

    @Override
    public void drawValue(Canvas c, String valueText, float x, float y, int color) {
        // Not used!
    }

    @Override
    public void drawExtras(Canvas c) {
        // Not used!
    }

    @Override
    public void drawHighlighted(Canvas c, Highlight[] indices) {
        // Not used!
    }
}
