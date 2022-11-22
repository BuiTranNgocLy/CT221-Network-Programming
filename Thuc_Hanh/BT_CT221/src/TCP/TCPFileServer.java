package TCP;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class TCPFileServer {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 20222
			ServerSocket ss = new ServerSocket(20222);
			while(true) {
				// Chap nhan cho noi ket
				Socket s = ss.accept();
				// Tao 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				// Doi thanh cac doi tuong thuoc lop con
				PrintStream ps = new PrintStream(os);
				Scanner sc = new Scanner(is);
				// Nhan cau lenh READ
				String caulenh = sc.nextLine();
				// Lay ra ten file duoc yeu cau
				String tenfile = caulenh.substring(5);
				// Doc noi dung file
				File f = new File(tenfile);
				if( f.exists() && f.isFile() ) {
					int size = (int)f.length();
					// Gui size la kich thuoc file
					ps.println(size);
					if(size > 0) {
						FileInputStream f1 = new FileInputStream(tenfile);
						DataInputStream dis = new DataInputStream(f1);
						DataOutputStream dos = new DataOutputStream(os);
						byte b[] = new byte[50000];
						int len = 0;
						while(true) {
							// Doc file
							int n = dis.read(b);	// Doc n byte tu file
							dos.write(b,0,n);		// Gui n byte qua Client
							len += n;
							System.out.println("Da gui toi " + len + " byte");
							if(len==size) break;
						}
						f1.close();
					}
				}
				else
					ps.println("-1");
				// Dong noi ket
				s.close();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}

