//package buoi02;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
class server {
	public static void main(String[] args) {
		try {
			// Tao ServerSocket lang nghe tren cong so 30000
			ServerSocket  ss = new ServerSocket(30000);
			System.out.println("Da tao ra ServerSocket tren cong 30000");
			while(true) {  // Cho phep phuc vu nhieu client lien tuc
				// Chap nhan cho noi ket
				Socket  s1 = ss.accept();
				System.out.println("Co 1 Client " + s1.getInetAddress().toString() 
					+ " tai cong " + s1.getPort()+ " noi ket");
				PhucVu  pv = new PhucVu(s1);
				pv.start();
				//s1.close();
			}
		}
		catch(IOException e) {
			System.out.println("Co loi khi phuc vu noi ket cua 1 client");
		}
	}
}

class PhucVu extends Thread {
	Socket  s;
	public PhucVu(Socket  s1) {
		s = s1;
	}
	public void run() {
		try {
			// Tao 2 stream nhap-xuat
			InputStream   is = s.getInputStream();
			OutputStream  os = s.getOutputStream();
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			PrintWriter  pw = new PrintWriter (os);
			while(true) {  // Phuc vu yeu cau cua 1 Client
				// Nhan chuoi tu Client
				Scanner sc = new Scanner(System.in);
				String hoTen, ketqua;
				hoTen = new String();
				//String str1 = br.readLine();
				// Kiem tra dieu kien de thoat
				if(hoTen.equals("EXIT")) break;
				// Xu ly
				try {
					//nhap thong tin
//					Scanner sc = new Scanner(System.in);
//					String hoTen, ketqua;
//					hoTen = new String();
					System.out.print("Nhap ho ten cua ban: ");
					hoTen = sc.nextLine();
					//Tach ten
					String[] d= hoTen.split(" ");
					hoTen = d[d.length-1];
				}
				catch(NumberFormatException e) {
					System.out.println("Co loi khi phuc vu 1 client");
				}
				
				//Gui ket qua
				System.out.println("Ten sau khi tach: "+ hoTen);
				pw.flush();
			}
			s.close();
		}
		catch(IOException e) {
			System.out.println("Co loi khi phuc vu 1 client");
		}
	}
};