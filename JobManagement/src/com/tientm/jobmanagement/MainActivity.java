package com.tientm.jobmanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.tientm.model.Job;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edName, edContent;
	TextView tvDate, tvTime;
	Button btnDate, btnTime, btnAdd;
	ListView lvJob;
	ArrayList<Job> listJob;
	ArrayAdapter<Job> adapter;
	DatePickerDialog dateDialog;
	TimePickerDialog timeDialog;
	Date dateDeadline;
	int hourDeadline;
	int minDeadline;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addControls();
		addEvents();
	}

	private void addControls() {
		edName = (EditText) findViewById(R.id.edName);
		edContent = (EditText) findViewById(R.id.edContent);
		tvDate = (TextView) findViewById(R.id.tvDate);
		tvTime = (TextView) findViewById(R.id.tvTime);
		btnDate = (Button) findViewById(R.id.btnDate);
		btnTime = (Button) findViewById(R.id.btnTime);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		lvJob = (ListView) findViewById(R.id.lvJob);
		listJob = new ArrayList<Job>();
		adapter = new ArrayAdapter<Job>(MainActivity.this,
				android.R.layout.simple_list_item_1, listJob);
		lvJob.setAdapter(adapter);
		
		OnDateSetListener dateCallBack = new OnDateSetListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				tvDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
				dateDeadline = new Date(year - 1900, monthOfYear, dayOfMonth);
			}
		};
		
		// Lấy ngày tháng hiện tại để làm giá trị mặc định
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int monthOfYear = cal.get(Calendar.MONTH);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		
		dateDialog = new DatePickerDialog(
				MainActivity.this, 
				dateCallBack,
				year, monthOfYear, dayOfMonth);
		
		OnTimeSetListener timeCallBack = new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				tvTime.setText(hourOfDay + ":" + minute);
				hourDeadline = hourOfDay;
				minDeadline = minute;
			}
		};
		
		
		timeDialog = new TimePickerDialog(
				MainActivity.this,
				timeCallBack,
				10, 10, true);
	}

	private void addEvents() {
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String name = edName.getText().toString();
				String content = edContent.getText().toString();
			
				Job j = new Job(name, content, dateDeadline, hourDeadline, minDeadline);
				listJob.add(j);
				adapter.notifyDataSetChanged();
			}
		});
		
		btnDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dateDialog.show();
			}
		});
		
		btnTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				timeDialog.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Lưu dữ liệu trong list lại
	@Override
	// OnPause xảy ra khi có che khuất,...
	protected void onPause() {
		SharedPreferences pre = getSharedPreferences("myfile", MODE_PRIVATE);
		Editor editor = pre.edit();
		editor.putString("TITLE", edName.getText().toString());
		editor.putString("CONTENT", edContent.getText().toString());
		editor.putString("DAY", tvDate.getText().toString());
		editor.putString("TIME", tvTime.getText().toString());
		
		// Xác nhận lưu
		editor.commit(); // Lưu vào data/data/package/shared_preferences...
		// Với tên XML là tên file .xml
		Toast.makeText(MainActivity.this, "OnPause xảy ra",Toast.LENGTH_LONG).show();
		super.onPause();
	}
	
	/*@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences pre = getSharedPreferences("myfile", MODE_PRIVATE);
		edName.setText(pre.getString("TILETE", ""));
		edContent.setText(pre.getString("CONTAINT", ""));
	}*/
}
