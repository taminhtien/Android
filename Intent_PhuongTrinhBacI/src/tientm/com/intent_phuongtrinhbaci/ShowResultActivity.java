package tientm.com.intent_phuongtrinhbaci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_result);

		// Để lấy được intent kích hoạt ta viết trong
		// onCreate hoặc onResume
		Intent inFromMain = getIntent();
		// Luôn kiểm tra null để biết rằng có intent kích hoạt nó
		if (inFromMain == null) {
			Toast.makeText(this, "Lỗi không có intent", Toast.LENGTH_LONG)
					.show();
		} else {
			// Lấy hệ số a
			// Đối số 1 là tên biến đặt bên MainActivity
			// Đối số 2 là giá trị mặc định cho biến nếu không tìm thấy
			int a = inFromMain.getIntExtra("hsa", 1);
			int b = inFromMain.getIntExtra("hsb", 1);
			TextView txtResult = (TextView) findViewById(R.id.txtResult);
			float x = (float) (-1) * b / a;
			txtResult.setText("x = " + x);
		}	

	}

	public void btnBackClick(View v) {
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_result, menu);
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
