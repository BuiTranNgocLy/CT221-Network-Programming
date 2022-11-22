package UDP;
import java.net.*;
import java.io.*;
class UDPEchoServer {
	public static void main(String[] args) {
		try {
			// Tao UDP Socket cong 7
			DatagramSocket ds = new DatagramSocket(7);
			// Tao ra goi UDP de nhan
			byte b[] = new byte[60000];
			int n = 60000;
			DatagramPacket goinhan = new DatagramPacket(b,n);
			while(true) {
				// Nhan goi UDP yeu cau
				ds.receive(goinhan);
				// Lay chuoi yeu cau
				InetAddress dc1 = goinhan.getAddress();
				int p1 = goinhan.getPort();
				byte b1[] = goinhan.getData();
				int n1 = goinhan.getLength();
				String yeucau = new String(b1,0,n1);
				// Xu ly yeu cau (Doi thanh chu HOA)
				String ketqua = yeucau.toUpperCase();
				// Dong goi UDP ket qua
				byte b3[] = ketqua.getBytes();
				int n3 = b3.length;
				DatagramPacket goigui = new DatagramPacket(b3,n3,dc1,p1);
				// Gui goi ket qua cho Client
				ds.send(goigui);
			}
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}