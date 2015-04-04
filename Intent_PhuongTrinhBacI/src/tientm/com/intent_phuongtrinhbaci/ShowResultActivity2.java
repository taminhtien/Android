package tientm.com.intent_phuongtrinhbaci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShowResultActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_result_activity2);
		
		//Intent in = getIntent();
		//Bundle my_bundle = in.getBundleExtra("My_Bundle");
	}
	
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "Gọi lại lấy thông tin", Toast.LENGTH_LONG).show();
		Intent in = getIntent();
		if (in != null) {
			// Lấy bundle ra
			Bundle my_bundle = in.getBundleExtra("My_Bundle");
			// Lấy a
			int a = my_bundle.getInt("aa", 1);
			int b = my_bundle.getInt("bb", 1);
			TextView txtResult = (TextView) findViewById(R.id.txtResult);
			float x = (float) (-1) * b / a;
			txtResult.setText("x = " + x);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_result_activity2, menu);
		return true;
	}

	public void btnBackClick(View v) {
		finish();
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
