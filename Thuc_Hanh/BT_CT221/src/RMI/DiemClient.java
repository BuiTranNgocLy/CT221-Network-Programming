package RMI;

import java.rmi.*;
import java.net.MalformedURLException;
class DiemClient {
	public static void main(String[] args) {
		try {
			// Tim doi tuong cho phep goi tu xa
			DiemItf a = (DiemItf)Naming.lookup("rmi://127.0.0.1/dtA");
			DiemItf b = (DiemItf)Naming.lookup("rmi://127.0.0.1/dtB");
			DiemItf c = (DiemItf)Naming.lookup("rmi://127.0.0.1/dtC");
			// Goi ham tu xa
			System.out.println("Gia tri hien tai A: " + a.layToaDo());
			System.out.println("Gia tri hien tai B: " + b.layToaDo());
			System.out.println("Gia tri hien tai C: " + c.layToaDo());
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
