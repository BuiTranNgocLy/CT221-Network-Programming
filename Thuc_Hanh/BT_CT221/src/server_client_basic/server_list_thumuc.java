package server_client_basic;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class server_list_thumuc {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 10001
			ServerSocket ss = new ServerSocket(10001);
			while(true) {
				// Chap nhan cho Client noi ket
				Socket s = ss.accept();
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				// Doi thanh cac doi tuong lop con
				Scanner sc = new Scanner(is);
				PrintStream ps = new PrintStream(os);
				// Nhan cau lenh LIST tu Client
				String caulenh = sc.nextLine();
				String thumuc = caulenh.substring(5);
				// Xu ly yeu cau - Gui ket qua cho Client
				File f = new File(thumuc);
				if(f.exists() && f.isDirectory()) {
					String kq[] = f.list();
					int n = kq.length;
					ps.println(n);	// Gui so luong thanh phan
					// Gui tiep n thanh phan trong thu muc
					for(int i=0; i<n; i++) {
					File f1 = new File(thumuc + "/" + kq[i]);
						if(f1.isDirectory())
							ps.println("[" + kq[i] + "]");
						else
							ps.println(kq[i]);
					}
				}
				else
					ps.println("-1");
				// Dong noi ket
				s.close();
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}

