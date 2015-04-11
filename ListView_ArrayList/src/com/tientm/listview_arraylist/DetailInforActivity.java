package com.tientm.listview_arraylist;

import com.example.hoclistview_arraylist.R;
import com.tientm.model.Contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class DetailInforActivity extends Activity {

	EditText txtName, txtPhone;
	ImageButton btnEdit, btnCall, btnSms;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_infor);
		addControls();
		addEvents();
	}

	private void addEvents() {

		btnEdit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				xulyGuiVe();
			}
		});
	}

	protected void xulyGuiVe() {
		Intent newIntent = new Intent();
		Contact c = new Contact();
		c.setName(txtName.getText().toString());
		c.setPhone(txtPhone.getText().toString());
		newIntent.putExtra("CONTACT_EDITED", c);
		setResult(999, newIntent);
		finish();
	}

	private void addControls() {
		txtName = (EditText) findViewById(R.id.txtName);
		txtPhone = (EditText) findViewById(R.id.txtPhone);
		btnCall = (ImageButton) findViewById(R.id.btnCall);
		btnEdit = (ImageButton) findViewById(R.id.btnEdit);
		btnSms = (ImageButton) findViewById(R.id.btnSms);
		Intent i = getIntent(); // Get intent call it
		Contact c = (Contact) i.getSerializableExtra("SELECTED");
		txtName.setText(c.getName());
		txtPhone.setText(c.getPhone());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_infor, menu);
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
