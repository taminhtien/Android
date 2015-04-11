package com.tientm.listview_arraylist;

import java.util.ArrayList;

import com.example.hoclistview_arraylist.R;
import com.tientm.model.Contact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity {

	EditText txtName,txtPhone;
	Button btnAdd;
	
	ListView lvContact;
	ArrayList<Contact> list;
	ArrayAdapter<Contact> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    public void addControls()
    {
    	txtName=(EditText) findViewById(R.id.txtName);
    	txtPhone=(EditText) findViewById(R.id.txtPhone);
    	btnAdd=(Button) findViewById(R.id.btnAdd);
    	lvContact=(ListView) findViewById(R.id.lvContact);
    	list=new ArrayList<Contact>();
    	adapter=new ArrayAdapter<Contact>
	    	(MainActivity.this,
	    	android.R.layout.simple_list_item_1,
	    	list);
    	lvContact.setAdapter(adapter);
    }
    public void addEvents()
    {
    	btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Contact c=new Contact();
				c.setName(txtName.getText()+"");
				c.setPhone(txtPhone.getText()+"");
				list.add(c);
				//ra lệnh cập nhật giao diện:
				adapter.notifyDataSetChanged();
			}
		});
    	
    	lvContact.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(
					AdapterView<?> arg0, 
					View arg1,
					int arg2, long arg3) {
				
				//xulyXoa(arg2);
				openDetail(arg2);
				return false;
			}
		});
    	
    }
    int selected_previous=-1;
    protected void openDetail(int arg2) {
    	//lưu lại vết vừa chọn là dòng nào:
    	selected_previous=arg2;
    	Intent i=new Intent
    			(MainActivity.this
    			, DetailInforActivity.class);
    	i.putExtra("SELECTED", list.get(arg2));
    	startActivityForResult(i, 1);
	}
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	if (requestCode == 1 && resultCode == 999) {
			Contact c = (Contact) data.getSerializableExtra("CONTACT_EDITED");
			// Thay giá trị tại vị trí chọn cho list
			list.set(selected_previous, c);
			adapter.notifyDataSetChanged();
		}
    }
	protected void xulyXoa(final int arg2) {
    	
    	AlertDialog.Builder builder=
    			new AlertDialog.Builder(this);
    	builder.setTitle("Hỏi xóa Contact");
    	builder.setMessage("Bạn có chắc chắn muốn xóa "
    			+list.get(arg2)+" ?");
    	builder.setIcon(android.R.drawable.ic_dialog_alert);
    	
    	builder.setPositiveButton("Có chứ", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				list.remove(arg2);
				adapter.notifyDataSetChanged();
			}
		});
    	builder.setNegativeButton("Nẩu", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
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
