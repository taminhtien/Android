package tien.com.convertctof;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.example.convertctof.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

	TextView txtF, txtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtF = (TextView) findViewById(R.id.txtF);
        txtC = (TextView) findViewById(R.id.txtC);
        Button btnC2F = (Button) findViewById(R.id.btnC2F);
        Button btnF2C = (Button) findViewById(R.id.btnF2C);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        
        btnC2F.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double c = Double.parseDouble(txtC.getText() + "");
				double f = c * 9 / 5 + 32;
				NumberFormat fomatter = new DecimalFormat("#.##");
				txtF.setText(fomatter.format(f) + "");
			}
		});
        
        btnF2C.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double f = Double.parseDouble(txtF.getText() + "");
				double c = (f - 32) * 5/9;
				NumberFormat fomatter = new DecimalFormat("#.##");
				txtC.setText(fomatter.format(c) + "");
			}
		});
        
        btnClear.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtC.setText("");
				txtF.setText("");
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
