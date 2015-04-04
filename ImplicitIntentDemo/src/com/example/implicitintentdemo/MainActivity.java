package com.example.implicitintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnCallClick(View v) {
		EditText edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
		String phoneNumber = edtPhoneNumber.getText().toString();
		// Đưa phone number về định dạng Uri
		Uri uriPhone = Uri.parse("tel:" + phoneNumber);
		Intent in = new Intent(Intent.ACTION_CALL, uriPhone);
		// Intent.ACTION_DIAL: mở màn hình quay số
		// Intent.ACTION_CALL: gọi luôn, y/c phải cấp quyền cho phép gọi
		startActivity(in);
	}

	public void btnSMSClick(View v) {
		EditText edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
		String phoneNumber = edtPhoneNumber.getText().toString();
		EditText edtSMS = (EditText) findViewById(R.id.edtSMS);
		String message = edtSMS.getText().toString();
		android.telephony.SmsManager sms = android.telephony.SmsManager.getDefault();	
		sms.sendTextMessage(phoneNumber, null, message, null, null);
		Toast.makeText(MainActivity.this, "Send completely!", Toast.LENGTH_LONG).show();
		
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
