package com.example.hoccontrolcoban;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnLongClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnClose = (Button) findViewById(R.id.btnClose);
		btnClose.setOnLongClickListener(this);
		OnClickListener event = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.btn1:
					// Toast.makeText(this, "Bạn click vào button 1",
					// Toast.LENGTH_LONG).show();
					v.setBackgroundColor(Color.RED);
					break;
				case R.id.btn2:
					v.setBackgroundColor(Color.YELLOW);
					break;
				default:
					break;
				}
			}
		};
		((Button) findViewById(R.id.btn1)).setOnClickListener(event);
		((Button) findViewById(R.id.btn2)).setOnClickListener(event);

		findViewById(R.id.btn3).setOnClickListener(new MyEvent());
		findViewById(R.id.btn3).setOnLongClickListener(new MyEvent());
	}

	// Exilicit listener class
	public class MyEvent implements OnClickListener, OnLongClickListener {

		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			if (v.getId() == R.id.btn3) {
				v.setBackgroundColor(Color.YELLOW);
			}
			return false;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v.getId() == R.id.btn3) {
				v.setBackgroundColor(Color.RED);
			}

		}

	}

	public void dangNhapHeThong(View v) {
		v.setBackgroundColor(Color.BLUE);
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

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btnClose) {
			// Ẩn nó khỏi màn hình
			v.setVisibility(View.INVISIBLE);
		}
		return false;
	}
}
