package com.example.hoclifetime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Crtl + 1 để tự động ép kiểu
        Button btnCheKhuat1Phan = (Button) findViewById(R.id.btnCheKhuat1Phan);
        // Kiểu bắt sự kiện inline: tạo 1 lớp nặc danh trong đối số của làm
        btnCheKhuat1Phan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Để mở một cửa sổ mới
				// Đối số 1: Tên lớp hiện tại.this
				// Đối số 2: Là cửa sổ muốn mở
				//				tên lớp mới .class
				Intent in = new Intent(MainActivity.this, CuaSo2Activity.class);
				startActivity(in);
				
			}
		});
        
        Button btnCheHet = (Button) findViewById(R.id.btnCheHet);
        btnCheHet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this, CuaSo3Activity.class);
				startActivity(in);
			}
		});
        
    }


    @Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Toast.makeText(this, "Sự kiện onRestart xảy ra", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "Sự kiện onDestroy xảy ra", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(this, "Sự kiện onPause xảy ra", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Toast.makeText(this, "Sự kiện onStop xảy ra", Toast.LENGTH_LONG).show();
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
