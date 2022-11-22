package server_client_basic;
import java.net.*;
import java.io.*;
class ServerDocSo {
	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe yeu cau tren cong 7000
			ServerSocket ss = new ServerSocket(7000);
			System.out.println("Da khoi tao xong Server, lang nghe cong 7000");
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
					String ketqua = "Khong biet";
					switch(ch1) {
						case '0': ketqua = "Khong"; break;
						case '1': ketqua = "Mot"; break;
						case '2': ketqua = "Hai"; break;
						case '3': ketqua = "Ba"; break;
						case '4': ketqua = "Bon"; break;
						case '5': ketqua = "Nam"; break;
						case '6': ketqua = "Sau"; break;
						case '7': ketqua = "Bay"; break;
						case '8': ketqua = "Tam"; break;
						case '9': ketqua = "Chin";
					}
					// Gui ket qua cho Client
					byte b[] = ketqua.getBytes();
					os.write(b);
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