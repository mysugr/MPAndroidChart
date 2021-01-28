
package com.xxmassdeveloper.mpchartexample.mysugr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.github.mikephil.charting.utils.Utils;
import com.xxmassdeveloper.mpchartexample.LineChartActivity1;
import com.xxmassdeveloper.mpchartexample.R;
import com.xxmassdeveloper.mpchartexample.notimportant.ContentItem;
import com.xxmassdeveloper.mpchartexample.notimportant.MyAdapter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MySugrActivity
		extends AppCompatActivity
		implements OnItemClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		setTitle("MySugr examples");
		
		// initialize the utilities
		Utils.init(this);
		
		ArrayList<ContentItem> objects = new ArrayList<>();
		
		objects.add(0, new ContentItem("Line Charts"));
		objects.add(1, new ContentItem("Basic", "Test."));
		
		MyAdapter adapter = new MyAdapter(this, objects);
		
		ListView lv = findViewById(R.id.listView1);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> av, View v, int pos, long arg3) {
		
		Intent i = null;
		
		switch (pos) {
			case 1:
				i = new Intent(this, LineChartActivity1.class);
				break;
		}
		
		if (i != null) startActivity(i);
		
		overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
	}
	
}
