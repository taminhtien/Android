package com.example.extracontrolsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText edtTenKh, edtSlSach, edtTongKh, edtTongVip,
			edtTongDoanhThu;
	private CheckBox chkVip;
	private TextView txtThanhTien;
	private Button btnTinhTT, btnTiep, btnThongKe;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addControls();
		addEvents();
	}

	private void addControls() {
		edtTenKh = (EditText) findViewById(R.id.edtCustomerName);
		edtSlSach = (EditText) findViewById(R.id.edtNoBook);
		edtTongKh = (EditText) findViewById(R.id.edtNoCustomer);
		edtTongVip = (EditText) findViewById(R.id.edtNoVIP);
		edtTongDoanhThu = (EditText) findViewById(R.id.edtTongDoanhThu);
		chkVip = (CheckBox) findViewById(R.id.chkVIP);
		txtThanhTien = (TextView) findViewById(R.id.txtThanhTien);
		btnTinhTT = (Button) findViewById(R.id.btnTinhTT);
		btnTiep = (Button) findViewById(R.id.btnTiep);
		btnThongKe = (Button) findViewById(R.id.btnThongKe);
	}

	private void addEvents() {
		btnTinhTT.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				xuLyTinhTT();
			}
		});
		btnTiep.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				xuLyTiep();
			}
		});
		btnThongKe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				xuLyThongKe();
			}
		});
	}

	protected void xuLyThongKe() {
		// TODO Auto-generated method stub
		
	}

	protected void xuLyTiep() {
		// TODO Auto-generated method stub
		
	}

	protected void xuLyTinhTT() {
		// TODO Auto-generated method stub
		
		
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
