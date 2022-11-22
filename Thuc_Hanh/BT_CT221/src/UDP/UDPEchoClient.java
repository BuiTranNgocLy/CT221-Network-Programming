package UDP;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class UDPEchoClient {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			// Tao ra UDP Socket cho Client
			DatagramSocket ds = new DatagramSocket();
			// Nhap 1 chuoi str tu ban phim
			while(true) {
				System.out.print("Nhap chuoi: ");
				String str = kb.nextLine();
				// Kiem tra dk de thoat
				if(str.equals("EXIT")) break;
				// Dong goi UDP chuoi str
				byte b[] = str.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName("127.0.0.1");
				int p = 7;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				// Gui goi UDP qua Server
				ds.send(goigui);
				// Tao ra goi UDP de nhan
				byte b1[] = new byte[60000];
				int n1 = 60000;
				DatagramPacket goinhan = new DatagramPacket(b1,n1);
				// Nhan goi UDP tra ve tu Server
				ds.receive(goinhan);
				// Lay ra chuoi ket qua
				byte b2[] = goinhan.getData();
				int n2 = goinhan.getLength();
				String ketqua = new String(b2,0,n2);
				// Hien thi ket qua ra man hinh
				System.out.println("Ket qua nhan duoc: " + ketqua);
			}
			// Dong socket UDP
			ds.close();
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
