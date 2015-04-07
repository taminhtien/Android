package tientm.com.listview_1array;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView txtSelected;
	Button btnShowListView;

	ListView lvData;
	String arrData[] = { "Hà Nội", "Đà Nẵng", "TP HCM" };
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addControls();
		addEvents();
	}

	public void addControls() {
		txtSelected = (TextView) findViewById(R.id.txtSelected);
		btnShowListView = (Button) findViewById(R.id.btnShowListView);
		lvData = (ListView) findViewById(R.id.lvData);
		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, arrData);
		lvData.setAdapter(adapter);
	}

	public void addEvents() {
		lvData.setOnItemClickListener(new OnItemClickListener() {

			// arg2: position of selected item
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				txtSelected.setText(arrData[arg2]);
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
}
