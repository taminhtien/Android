package tien.com.devevents;

import com.example.devevents.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Phương pháp "Activity is Listener"
 * B1. Cho Activity implement interface có khả năng sinh sự kiện 
 * @author tientm
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	 /**
     * Khi control được sử dụng trong toàn bộ class, thì ta nên khai báo biến control
     * với phạm vi instance variable (tức là khai báo biến control đó ở trong class)
     * chứ không phải trong hàm
     * @param
     */
    
    EditText txtA, txtB;
    TextView tvKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        tvKq = (TextView) findViewById(R.id.tvKq);
    	
        /**
         * Phương pháp "Inline anonymous listener"
         * new _ Ctrl + space
         */
        Button btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		        int a = Integer.parseInt(txtA.getText() + "");
		    	int b = Integer.parseInt(txtB.getText() + "");
		    	tvKq.setText(a - b + "");
			}
		});
        
        /**
         * Phương pháp "Activity is Listener"
         * B2. Set click Listener cho button
         */
        Button btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        
        /**
         * Phương pháp "Listener in Variable"
         * B1. Tạo biến OnClickListener
         */
        OnClickListener myOnClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switch (arg0.getId()) {
				case R.id.btnDev: {
			        int a = Integer.parseInt(txtA.getText() + "");
			    	int b = Integer.parseInt(txtB.getText() + "");
			    	tvKq.setText(a / b + "");
					break;
				}
				case R.id.btnUsc: {
			        int a = Integer.parseInt(txtA.getText() + "");
			    	int b = Integer.parseInt(txtB.getText() + "");
			    	if (b == 0) {
						Toast.makeText(MainActivity.this, "B = 0", Toast.LENGTH_LONG).show();
						txtB.selectAll();
						txtB.requestFocus();
						tvKq.setText("Chưa làm");
						return;
					}
					break;
				}
				default:
					break;
				}
			}
		};
		/**
         * Phương pháp "Listener in Variable"
         * B2. Chia sẻ sự kiện OnClick cho các control
         */
		((Button) findViewById(R.id.btnDev)).setOnClickListener(myOnClickListener);
		((Button) findViewById(R.id.btnUsc)).setOnClickListener(myOnClickListener);
		
		/**
		 * Phương pháp "Explicit Listener Class"
		 * B2. Gán sự kiện
		 */
		Button btnExit = (Button) findViewById(R.id.btnExit);
		btnExit.setOnLongClickListener(new MyEvent());
    }
   
    /**
     * Đây là sự kiện onlick sử dụng phương pháp "OnClick in XML"
     * @param v
     */
    public void tong2So_Click(View v)
    {
        int a = Integer.parseInt(txtA.getText() + "");
    	int b = Integer.parseInt(txtB.getText() + "");
    	tvKq.setText(a + b + "");
    }
    

    /**
     * Phương pháp "Activity is Listener"
     * B3. Các control sẽ sử dụng chung sự kiện OnClick nên phải dùng Switch or Ifelse
     */
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
        int a = Integer.parseInt(txtA.getText() + "");
    	int b = Integer.parseInt(txtB.getText() + "");
		// if (arg0.getId() == R.id.)
		if (arg0.getId() == R.id.btnMul) {
	    	tvKq.setText(a * b + "");
		}
	}
	
	
	/**
	 * 
	 * Khi dự án có quy mô lớn, nên tách ra một lớp để xử lí sự kiện
	 * Phương pháp "Explicit Listener Class"
	 * B1. Tạo một class tường minh
	 * @author tientm
	 *
	 */
	public class MyEvent implements OnLongClickListener {

		@Override
		public boolean onLongClick(View arg0) {
			// TODO Auto-generated method stub
			if (arg0.getId() == R.id.btnExit) {
				finish();
			}
			return false;
		}
		
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
