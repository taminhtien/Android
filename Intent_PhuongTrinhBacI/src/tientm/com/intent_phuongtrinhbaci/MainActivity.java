package tientm.com.intent_phuongtrinhbaci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edtA, edtB;
	Button btnGiai1, btnGiai2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnGiai1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				btnGiai1();
			}
		});

		btnGiai2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				btnGiai2();
			}
		});
	}

	protected void btnGiai2() {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(edtA.getText().toString());
		int b = Integer.parseInt(edtB.getText().toString());
		// Bước 1: khai báo intent
		Intent in = new Intent(MainActivity.this, ShowResultActivity2.class);
		// Bước 2: đẩy dữ liệu vào Bundle
		Bundle bund = new Bundle();
		bund.putInt("aa", a);
		bund.putInt("bb", b);
		// Bước 3: đưa bundle vào intent
		in.putExtra("My_Bundle", bund);
		// Bước 4: gọi lệnh kích hoạt
		startActivity(in);
		
	}

	protected void btnGiai1() {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(edtA.getText().toString());
		int b = Integer.parseInt(edtB.getText().toString());
		// Bước 1: khia báo intent
		Intent in = new Intent(MainActivity.this, ShowResultActivity.class);
		// Bước 2: đẩy dữ liệu vào intent
		in.putExtra("hsa", a);
		in.putExtra("hsb", b);
		startActivity(in);
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		edtA = (EditText) findViewById(R.id.edtA);
		edtB = (EditText) findViewById(R.id.edtB);
		btnGiai1 = (Button) findViewById(R.id.btnGiai1);
		btnGiai2 = (Button) findViewById(R.id.btnGiai2);
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


