//•	Client: nhập vào từ bàn phím 1 chuỗi họ và tên và gửi cho Server
//package buoi02;
import java.net.*;
import java.io.*;
class client {
	public static void main(String[] args) {
		try {
			// Tao Socket noi ket den Server
			Socket  s = new Socket("127.0.0.1", 30000);
			// Lay ra 2 stream nhap - xuat
			InputStream   is = s.getInputStream();
			OutputStream  os = s.getOutputStream();
			BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			PrintWriter  pw = new PrintWriter (os);
			while(true) {
				// Nhap 1 chuoi ho ten tu ban phim
				System.out.print("Nhap ho ten cua ban: ");
				String hoTen = keyboard.readLine();
				// Gui chuoi qua Server
				pw.println( hoTen ); pw.flush();
				// Kiem tra dieu kien de thoat
				if(hoTen.equals("EXIT")) break;
				// Nhan chuoi ket qua tra ve tu Server
				String ketqua = br.readLine();
				// Hien thi ten da tach
				System.out.println("Ten da duoc tach: " + ketqua);
			}
			s.close();
		}
		catch(IOException e) {
			System.out.println("Loi noi ket");
		}
	}
}
