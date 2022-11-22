package TCP;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class MulticastFileClient {
	public static void main(String[] args) {
		try {
			// Tao 1 Multicast Socket cong 20000
			MulticastSocket ms = new MulticastSocket(20000);
			// Tham gia vao nhom dia chi 225.6.7.8
			InetAddress dc = InetAddress.getByName("225.6.7.8");
			ms.joinGroup(dc);
			// Nhan goi phuc vu
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			ms.receive(goinhan);
			// Hien thi thong tin
			byte b1[] = goinhan.getData();
			int n1 = goinhan.getLength();
			// Luu lai thanh file ket qua
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file can luu: ");
			String tenfile = kb.nextLine();
			FileOutputStream f = new FileOutputStream(tenfile);
			f.write(b1,0,n1);	// Ghi file
			f.close();
			System.out.println("Da ghi file thanh cong");
			// Roi khoi nhom
			ms.leaveGroup(dc);
			// Dong socket lai
			ms.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}

