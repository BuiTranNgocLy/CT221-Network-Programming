package TCP;

import java.net.*;
import java.io.*;
class server_songsong extends Thread {
	Socket s;
	public server_songsong(Socket s1) {
		s = s1;
	}
	public void run() {
		try {
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				while(true) {	// Phuc vu cho 1 Client nhieu lan
					// Nhan chuoi yeu cau tu Client
					byte b[] = new byte[1000];
					int n = is.read(b);
					// Xu ly yeu cau (doi thanh nhi phan)
					String yeucau = new String(b,0,n);
					// Kiem tra dk de thoat
					if(yeucau.equals("EXIT")) break;
					String ketqua = new String();
					try {
						int x = Integer.parseInt(yeucau);
						ketqua = Integer.toBinaryString(x);
					}
					catch(NumberFormatException e) {
						ketqua = "Khong phai la so nguyen";
					}
					// Gui ket qua cho Client
					byte b1[] = ketqua.getBytes();
					os.write(b1);
				}
				// Dong noi ket
				s.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
};
class ServerNhiPhanSS {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 2022
			ServerSocket ss = new ServerSocket(2022);
			while(true) {	// Phuc vu cho nhieu Client
				// Chap nhan cho noi ket
				Socket s = ss.accept();
				server_songsong pv = new server_songsong(s);
				pv.start();
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}

