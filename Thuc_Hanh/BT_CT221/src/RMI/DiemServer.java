package RMI;

import java.rmi.*;
import java.net.MalformedURLException;
class DiemServer {
	public static void main(String[] args) {
		try {
			// Khoi tao co che bao mat RMI
			if(System.getSecurityManager()==null)
				System.setSecurityManager(new RMISecurityManager());
			// Tao doi tuong goi tu xa
			DiemRMI diemA = new DiemRMI();
			DiemRMI diemB = new DiemRMI(10,20);
			DiemRMI diemC = new DiemRMI();
			// Nhap gia tri cho C
			diemC.nhap();
			System.out.print("Toa do diem C: ");
			diemC.hienThi();
			// Dang ky doi tuong goi tu xa
			Naming.rebind("dtA", diemA);
			Naming.rebind("dtB", diemB);
			Naming.rebind("dtC", diemC);
			System.out.println();
			System.out.println("Da dang ky thanh cong dtA, dtB, dtC");
		}
		catch(RemoteException e) {
			System.out.println(e);
		}
		catch(MalformedURLException e) {
			System.out.println(e);
		}
	}
}
