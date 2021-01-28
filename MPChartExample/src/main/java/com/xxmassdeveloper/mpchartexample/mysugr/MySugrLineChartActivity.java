
package com.xxmassdeveloper.mpchartexample.mysugr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;
import com.xxmassdeveloper.mpchartexample.R;
import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;

/**
 * Example of a heavily customized {@link LineChart} with limit lines, custom line shapes, etc.
 *
 * @version 3.1.0
 * @since 1.7.4
 */
public class MySugrLineChartActivity extends DemoBase {
	
	private LineChart chart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_linechart);
		
		setTitle("MySugr line charts");
		
		{   // // Chart Style // //
			chart = findViewById(R.id.chart1);
			
			// background color
			chart.setBackgroundColor(Color.WHITE);
			
			// disable description text
			chart.getDescription().setEnabled(false);
			
			// enable touch gestures
			chart.setTouchEnabled(true);
			
			chart.setDrawGridBackground(false);
			
			
			// enable scaling and dragging
			chart.setDragEnabled(true);
			chart.setScaleEnabled(true);
			// chart.setScaleXEnabled(true);
			// chart.setScaleYEnabled(true);
			
		}
		
		
		YAxis yAxis;
		{   // // Y-Axis Style // //
			yAxis = chart.getAxisLeft();
			
			// disable dual axis (only use LEFT axis)
			chart.getAxisRight().setEnabled(false);
			
			// axis range
			yAxis.setAxisMinimum(0f);
			yAxis.setAxisMaximum(100f);
		}
		
		XAxis xAxis = chart.getXAxis();
		xAxis.setAxisMinimum(0f);
		xAxis.setAxisMaximum(100f);
		
		// add data
		setData(45, 180);
		
		// draw points over time
		chart.animateX(1500);
	}
	
	@Override
	protected void saveToGallery() {
	
	}
	
	private void setData(int count, float range) {
		
		ArrayList<ILineDataSet> dataSets = new ArrayList<>();
		List<Entry> entries = getDashedEntries();
		LineDataSet dashedDataSet = createDashedDataSet(entries);
		dataSets.add(dashedDataSet);
		
		List<Entry> gradientEntries = getDashedEntries();
		LineDataSet gradientDataSet = createGradientDataSet(gradientEntries);
		//dataSets.add(gradientDataSet);
		
		// create a data object with the data sets
		LineData data = new LineData(dataSets);
		
		// set data
		chart.setData(data);
	}
	
	private LineDataSet createDashedDataSet(List<Entry> entries) {
		LineDataSet dashedDataSet = new LineDataSet(entries, "dashed");
		dashedDataSet.enableDashedLine(1f, 35f, 0f);
		dashedDataSet.setColor(Color.GRAY);
		dashedDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
		dashedDataSet.setLineWidth(3f);
		return dashedDataSet;
	}
	
	private LineDataSet createGradientDataSet(List<Entry> entries) {
		LineDataSet gradientDataSet = new LineDataSet(entries, "gradient");
		gradientDataSet.setColor(Color.GRAY);
		gradientDataSet.setLineWidth(4f);
		int[] colors = new int[]{Color.RED, Color.YELLOW, Color.GREEN};
		//gradientDataSet.setRangeColors(colors);
		float[] rangeValues = new float[]{80, 60, 40, 20};
		//gradientDataSet.setRangeValues(rangeValues);
		gradientDataSet.setColor(Color.GREEN);
		gradientDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
		gradientDataSet.setCubicIntensity(0.35f);
		return gradientDataSet;
	}
	
	private List<Entry> getDashedEntries() {
		float multiplier = 10f;
		List<Entry> entries = new ArrayList();
		for (int index = 1; index < 10; index++) {
			double y = Math.random() * 100;
			Entry entry = new Entry(index * multiplier, (float) y);
			entries.add(entry);
		}
		return entries;
	}
	
	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {
	
	}
}
