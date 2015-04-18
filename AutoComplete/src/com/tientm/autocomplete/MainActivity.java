package com.tientm.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends Activity {

	AutoCompleteTextView autoComplete;
	MultiAutoCompleteTextView mAutoComplete;
	TextView txtContent, txtContent2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		autoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
		txtContent = (TextView) findViewById(R.id.txtContent);
		mAutoComplete = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
		// Create resource for AutomaticCompelete
		String countries[] = { "Brunei", "Vietnam", "Singapore", "Thailand",
				"Myanma", "Lao", "Campuchia", "Philipine", "Malasia" };
		autoComplete.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, countries));
		autoComplete.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				txtContent.setText(arg0.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});

		mAutoComplete.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, countries));
		mAutoComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		txtContent2 = (TextView) findViewById(R.id.txtContent2);
		
		mAutoComplete.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				txtContent2.setText(arg0);
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
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
