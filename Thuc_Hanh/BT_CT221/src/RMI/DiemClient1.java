package RMI;

import java.rmi.*;
import java.net.MalformedURLException;
class DiemClient1 {
	public static void main(String[] args) {
		try {
			// Tim doi tuong cho phep goi tu xa
			DiemItf a = (DiemItf)Naming.lookup("rmi://127.0.0.1/dtA");
			DiemItf b = (DiemItf)Naming.lookup("rmi://127.0.0.1/dtB");
			DiemItf c = (DiemItf)Naming.lookup("rmi://127.0.0.1/dtC");
			// Goi ham tu xa
			a.ganDiem(9,9);
			b.doiDiem(20,10);
			c.doiDiem(8,8);
			System.out.print("Da thuc hien xong");
		}
		catch(NotBoundException e) {
			System.out.println("Khong tim thay doi tuong");
		}
		catch(RemoteException e) {
			System.out.println(e);
		}
		catch(MalformedURLException e) {
			System.out.println(e);
		}

	}
}
