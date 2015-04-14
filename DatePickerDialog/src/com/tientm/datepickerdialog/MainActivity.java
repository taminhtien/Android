package com.tientm.datepickerdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	TextView txtDate, txtTime;
	Button btnDate, btnTime;
	DatePickerDialog dateDialog;
	TimePickerDialog timeDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addControls();
		addEvents();
	}

	private void addEvents() {
		btnDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dateDialog.show();
			}
		});

	}

	private void addControls() {
		txtDate = (TextView) findViewById(R.id.txtDate);
		txtTime = (TextView) findViewById(R.id.txtTime);
		btnDate = (Button) findViewById(R.id.btnDate);
		btnTime = (Button) findViewById(R.id.btnTime);
		OnDateSetListener callBack = new OnDateSetListener() {
			
			// Lấy ngày tháng năm người dùng thay đổi
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
				
			}
		};
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int monthOfYear = cal.get(Calendar.MONTH);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		dateDialog = new DatePickerDialog(
				MainActivity.this,
				callBack, // Lấy được thông tin mà người dùng thay đổi trên giao diện
				year, monthOfYear, dayOfMonth); // Ngày tháng năm mặc định
		
		OnTimeSetListener timeCallBack = new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				txtTime.setText(hourOfDay + ":" + minute);
				
			}
		};
		timeDialog = new TimePickerDialog(
				MainActivity.this,
				timeCallBack,
				10, 10, false);
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
}
