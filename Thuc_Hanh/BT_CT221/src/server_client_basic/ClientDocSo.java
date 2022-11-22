package server_client_basic;
import java.net.*;
import java.io.*;
class ClientDocSo {
	public static void main(String[] args) {
		try {
			// Noi ket den Server
			Socket s = new Socket("127.0.0.1", 7000);
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) {
				// Nhap 1 ky tu ch tu ban phim
				System.out.print("Nhap 1 ky tu: ");
				int ch = System.in.read();
				// Gui ky tu ch qua Server
				os.write(ch);
				System.in.skip(2);	// Bo 2 ky tu \r\n
				// Kiem tra dieu kien de thoat
				if(ch=='@') break;
				// Nhan ket qua tu Server
				byte b[] = new byte[100];
				int n = is.read(b);
				// Hien thi ket qua ra man hinh
				String ketqua = new String(b,0,n);
				System.out.println("Nhan duoc: " + ketqua);
			}
			// Dong noi ket
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Khong noi ket duoc voi Server");
		}
		catch(IOException e) {
			 System.out.println("Loi nhap xuat");
			//System.out.println(e);
		}
	}
}
