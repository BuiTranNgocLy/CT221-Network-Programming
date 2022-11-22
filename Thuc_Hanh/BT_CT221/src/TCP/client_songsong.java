package TCP;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class client_songsong {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			// Nhap tu ban phim dia chi Server
			System.out.print("Nhap dia chi Server: ");
			String dcServer = kb.nextLine();
			// Nhap tu ban phim thu muc can	list tren Server
			System.out.print("Nhap ten thu muc tren Server can liet ke: ");
			String thumuc = kb.nextLine();
			// Noi ket den Server
			Socket s = new Socket(dcServer, 10000);
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			// Doi thanh doi tuong thuoc cac lop con
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			// Gui cau lenh LIST qua Server
			String caulenh = "LIST " + thumuc;
			pw.println(caulenh); pw.flush();
			// Nhan n la so luong thanh phan co trong thu muc yeu cau
			String str = sc.nextLine();
			int n = Integer.parseInt(str);
			if(n==-1)
				System.out.println("Thu muc khong ton tai");
			else
				if(n==0)
					System.out.println("Thu muc rong");
				else {
					// Nhan tiep n thanh phan
					for(int i=0; i<n; i++) {
						String kq = sc.nextLine();
						System.out.println(kq);
					}
				}
			// Dong noi ket
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}

