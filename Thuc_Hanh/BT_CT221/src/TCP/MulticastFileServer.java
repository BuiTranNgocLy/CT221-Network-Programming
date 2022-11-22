package TCP;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class MulticastFileServer {
	public static void main(String[] args) {
		try {
			// Nhap tu ban phim ten file can gui
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file can gui cho group: ");
			String tenfile = kb.nextLine();
			// Tao ra UDP Socket
			DatagramSocket ds = new DatagramSocket();
			int count=0;
			// Doc noi dung 1 file yeu cau
			File f = new File(tenfile);
			if(f.exists() && f.isFile()) {
				int len = (int)f.length();
				byte b1[] = new byte[len];
				FileInputStream f1 = new FileInputStream(tenfile);
				f1.read(b1);
				f1.close();
				System.out.println("Da doc xong noi dung file");
				// Dong goi
				InetAddress dc = InetAddress.getByName("225.6.7.8");
				int p = 20000;
				DatagramPacket goigui = new DatagramPacket(b1,len,dc,p);
				while(true) {
					// Gui goi phuc vu cho nhom dia chi lop D
					ds.send(goigui);
					System.out.println("Da gui goi thu " + ++count);
					Thread.sleep(10000);
				}
			}
			else
				System.out.println("File khong ton tai");
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
		catch(InterruptedException e) {
			System.out.println("Loi khi tam dung");
		}
	}
}

