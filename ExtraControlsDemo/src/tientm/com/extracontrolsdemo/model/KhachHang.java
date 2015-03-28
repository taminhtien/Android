package tientm.com.extracontrolsdemo.model;

public class KhachHang {

	private String name;
	private int soSach;
	private boolean vip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSoSach() {
		return soSach;
	}
	public void setSoSach(int soSach) {
		this.soSach = soSach;
	}
	public boolean isVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	public KhachHang(String name, int soSach, boolean vip) {
		super();
		this.name = name;
		this.soSach = soSach;
		this.vip = vip;
	}
	
	
	
}
