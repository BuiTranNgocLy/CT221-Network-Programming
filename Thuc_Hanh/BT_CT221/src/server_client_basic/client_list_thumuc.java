package server_client_basic;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class client_list_thumuc {
	public static void main(String[] args) {
		try {
			// Nhap tu ban phim
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi Server: ");
			String dcServer = kb.nextLine();
			System.out.print("Nhap ten thu muc tren Server can list: ");
			String thumuc = kb.nextLine();
			// Noi ket den Server
			Socket s = new Socket(dcServer,10001);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			// Doi thanh cac doi tuong lop con
			Scanner sc = new Scanner(is);
			PrintStream ps = new PrintStream(os);
			// Gui cau lenh LIST
			String caulenh = "LIST " + thumuc;
			ps.println(caulenh);
			// Nhan ve n (la so luong thanh phan)
			String str = sc.nextLine();
			int n = Integer.parseInt(str);
			// Nhan va hien thi n dong (thanh phan) tiep theo
			if(n==-1)
				System.out.println("Thu muc khong ton tai");
			else
				if(n==0)
					System.out.println("Thu muc rong");
				else {
					// Thu muc ton tai - Nhan va hien thi n dong
					System.out.println("ND thu muc yeu cau:");
					for(int i=0; i<n; i++) {
						String kq = sc.nextLine();
						System.out.println(kq);
					}
				}
			// Dong noi ket
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi Server");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
