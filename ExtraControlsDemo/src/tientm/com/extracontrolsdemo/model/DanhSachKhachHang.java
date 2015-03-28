package tientm.com.extracontrolsdemo.model;

import java.util.ArrayList;
import java.util.List;

public class DanhSachKhachHang {

	private List<KhachHang> ds = null;
	public DanhSachKhachHang() {
		this.ds = new ArrayList<>();
	}
	
	public void themKhachHang(KhachHang kh) {
		this.ds.add(kh);
	}
	public int tongKhachHang() {
		return this.ds.size();
	}
	
	public int tongKhachHangVip() {
		int s = 0;
		for (KhachHang kh: this.ds) {
			if (kh.isVip()) {
				s++;
			}
		}
		return s;
	}
	public double tongDoanhThu() {
		double s = 0;
		for (KhachHang kh: this.ds) {
			if (kh.isVip()) {
				s += kh.getSoSach() * 2 * 0.9;
			}
			else
				s+= kh.getSoSach() * 2;
		}
		return s;
	}
}
