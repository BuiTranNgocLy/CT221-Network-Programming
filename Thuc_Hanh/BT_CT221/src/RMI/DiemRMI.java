package RMI;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import java.util.Scanner;
class DiemRMI extends UnicastRemoteObject implements DiemItf {
	// Khai bao thuoc tinh
	private int x;
	private int y;
	// Ham xay dung
	public DiemRMI() throws RemoteException {
		super();
		x = y = 0;
	}
	public DiemRMI(int h, int t) throws RemoteException {
		super();
		x = h;
		y = t;
	}
	// Cac ham cuc bo
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap hoanh do: ");
		x = kb.nextInt();
		System.out.print("Nhap tung do: ");
		y = kb.nextInt();
	}
	public void hienThi() {
		System.out.print("(" + x + "," + y + ")");
	}
	// Cac ham goi tu xa
	public String layToaDo() {
		String ketqua = "(" + x + "," + y + ")";
		return ketqua;
	}
	public void ganDiem(int h, int t) {
		x = h; y = t;
	}
	public void doiDiem(int dx, int dy) {
		x += dx;
		y += dy;
	}


}

