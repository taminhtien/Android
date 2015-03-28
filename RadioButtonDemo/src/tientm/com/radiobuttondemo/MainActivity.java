package tientm.com.radiobuttondemo;

import tient.com.radiobuttondemo.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	EditText edtHoTen, edtCMND, edtThongTinBoSung;
	CheckBox chkDocBao, chkDocSach, chkDocCoding;
	RadioGroup radgBangCap;
	RadioButton radCaoDang, radTrungCap, radDaiHoc;
	Button btnGoiThongTin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addControls();
		addEvents();
	}

	public void addControls() {

		edtHoTen = findEditTextId(R.id.edtHoTen);
		edtCMND = findEditTextId(R.id.edtCMND);
		edtThongTinBoSung = findEditTextId(R.id.edtThongTinBoSung);
		radgBangCap = (RadioGroup) findViewById(R.id.radgBangCap);
		chkDocBao = findCheckBoxId(R.id.chkDocBao);
		chkDocSach = findCheckBoxId(R.id.chkDocSach);
		chkDocCoding = findCheckBoxId(R.id.chkCoding);
		btnGoiThongTin = (Button) findViewById(R.id.btnGoiThongTin);
	}

	private EditText findEditTextId(int id) {
		return (EditText) findViewById(id);
	}

	private CheckBox findCheckBoxId(int id) {
		return (CheckBox) findViewById(id);
	}

	public void addEvents() {
		btnGoiThongTin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				processSendInfo();
			}
		});
	}

	protected void processSendInfo() {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

		builder.setTitle("Thông tin cá nhân");
		String message = edtHoTen.getText().toString() + "\n"
				+ edtCMND.getText().toString();

		int idChecked = radgBangCap.getCheckedRadioButtonId();
		switch (idChecked) {
		case R.id.radCaoDang:
			message += "\nCao đẳng";
			break;
		case R.id.radDaiHoc:
			message += "\nĐại học";
			break;
		case R.id.radTrungCap:
			message += "\nTrung cấp";
			break;
		default:
			break;
		}

		if (chkDocBao.isChecked()) {
			message += "\nĐọc báo";
		}
		if (chkDocSach.isChecked()) {
			message += "\nĐọc sách";
		}
		if (chkDocCoding.isChecked()) {
			message += "\nĐọc coding";
		}

		message += "\n-----------------\nThông tin bổ sung\n";
		message += edtThongTinBoSung.getText().toString();
		message += "\n-----------------";
		builder.setMessage(message);
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel(); // hủy luôn trong bộ nhớ
				// dialog.dismiss(); // còn trong bộ nhớ có thể gọi lại
			}
		});
		builder.create().show();
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
