package server_client_basic;
import java.net.*;
import java.io.*;
class EchoServer {
	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe yeu cau tren cong 7
			ServerSocket ss = new ServerSocket(7);
			System.out.println("Da khoi tao xong Server, lang nghe cong 7");
			while(true) {	// Phuc vu cho nhieu Client
				// Chap nhan cho noi ket
				Socket s = ss.accept();
				System.out.println("Co 1 Client noi ket");
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				while(true) {	// Phuc vu cho 1 Client nhieu lan
					// Nhan yeu cau tu Client
					int ch1 = is.read();
					System.out.println("Nhan duoc tu Client: " + ch1);
					// Kiem tra dieu kien de thoat
					if(ch1=='@') break;
					// Xu ly yeu cau
					int ketqua = ch1;
					// Gui ket qua cho Client
					os.write(ketqua);
				}
				// Dong noi ket voi Client
				s.close();
			}
			// ss.close();
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
