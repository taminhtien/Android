package com.tientm.adapter;

import java.util.List;

import com.example.hoclistview_arraylist.R;
import com.tientm.model.Contact;

import android.R.anim;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Nhiệm vụ của class này là hiển thị giao diện giống ý chúng ta
 * 
 * @author tientm
 * 
 */
public class MyAdapter extends ArrayAdapter<Contact> {

	Activity context;
	int resource;
	List<Contact> objects;

	public MyAdapter(
	// Context context, // Instance của activity muốn hiển thị lên, activity kế
	// thừa từ context
			Activity context, int resource, // ID của custom layout
			List<Contact> objects) // Danh sách muốn hiển thị lên giao diện
	{
		super(context, resource, objects);
		this.context = context;
		this.resource = resource;
		this.objects = objects;
	}

	/**
	 * Hàm giúp ta hiển thị giao hiện theo ý mình getView là hàm chạy real time
	 * (chạy 24/24, nếu debug sẽ chạy hoài) -> Vẽ liên tục các dòng (contact)
	 * theo đúng position
	 */
	@Override
	public View getView(int position, // Dòng hiện tại muốn vẽ
			View convertView, ViewGroup parent) {
		// Lấy contact tại vị trí đang vẽ
		Contact c = this.objects.get(position);
		// Lấy đối tượng layout ra để nhân bản đủ số dòng
		LayoutInflater flatter = this.context.getLayoutInflater();
		// Mỗi dòng chính là một view, view tổng hợp
		// --> Chính là chi tiết cho mỗi dòng mà ta đã tự thiết kế
		// Lúc nãy ta đặt tên là custom_row_item.xml
		View custom_row = flatter.inflate(this.resource, null);
		// Ta biết custom_row chỉ có 2 TextView
		TextView txtCustomName = (TextView) custom_row
				.findViewById(R.id.txtCustomName);
		TextView txtCustomPhone = (TextView) custom_row
				.findViewById(R.id.txtCustomPhone);
		// Hiển thị cho cho từng dòng theo ý mình
		txtCustomName.setTextColor(this.context.getResources().getColor(
				android.R.color.holo_blue_dark));
		txtCustomName.setTextSize(15);
		txtCustomName.setTypeface(null, Typeface.ITALIC);
		txtCustomPhone.setTextColor(this.context.getResources().getColor(
				android.R.color.holo_red_dark));
		txtCustomName.setText(c.getName());
		txtCustomPhone.setText(c.getPhone());
		// Chú ý: Nó đang quản lý theo địa chỉ
		// Nên tự động nó hiểu sự thay đổi bên trên

		return custom_row; // Trả về dòng theo định dạng của ta
	}

}
