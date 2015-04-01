package tientm.com.convertyearetow;

import java.util.Calendar;

import com.example.convertyearetow.R;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	/*String arrCan[] = { "Canh", "Tân", "Nhâm", "Qúy", "Giáp", "Ất", "Bính",
			"Đinh", "Mậu", "Kỷ" };*/
	String arrCan[] = null;
	/*String arrChi[] = { "Thân", "Dậu", "Tuất", "Hợi", "Tí", "Sửu", "Dần",
			"Mẹo", "Thìn", "Tỵ", "Ngọ", "Mùi" };*/
	String arrChi[] = null;

	Button btnConvert;
	EditText edtYear;
	TextView txtResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addControls();
		getDefaultData();
		addEvents();
		
		Resources res = getResources();
		arrCan = res.getStringArray(R.array.arr_CAN);
		arrChi = res.getStringArray(R.array.arr_CHI);
	}

	public void getDefaultData() {
		Calendar cal = Calendar.getInstance();
		edtYear.setText(cal.get(Calendar.YEAR) + "");
	}
	
	private void addControls() {
		// TODO Auto-generated method stub
		btnConvert = (Button) findViewById(R.id.btnConvert);
		edtYear = (EditText) findViewById(R.id.edtYear);
		txtResult = (TextView) findViewById(R.id.txtResult);
	}

	private void addEvents() {
		
		TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.sSoftTitleEN);
		btnConvert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				convertYearEtoW();
			}
		});
	}

	protected void convertYearEtoW() {
		// TODO Auto-generated method stub
		int yearW = Integer.parseInt(edtYear.getText().toString());
		int can = yearW % 10;
		int chi = yearW % 12;
		String yearE = arrCan[can] + " " + arrChi[chi];
		txtResult.setText(yearE); 
		String content = String.format(getResources().getString(R.string.message), yearW, yearE);
		Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();

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
