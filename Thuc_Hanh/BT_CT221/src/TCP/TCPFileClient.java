package TCP;
import java.net.*;
import java.io.*;
import java.util.Scanner;
class TCPFileClient {
	public static void main(String[] args) {
		try {
			// Nhap tu ban phim: dia chi Server, ten file can lay, ten file save
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi Server: ");
			String dcServer = kb.nextLine();
			System.out.print("Nhap ten file tren Server can lay: ");
			String tenfile = kb.nextLine();
			System.out.print("Nhap ten file can luu: ");
			String tenfileluu = kb.nextLine();
			// Noi ket den Server
			Socket s = new Socket(dcServer, 20222);
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			// Doi thanh cac doi tuong thuoc lop con
			PrintStream ps = new PrintStream(os);
			Scanner sc = new Scanner(is);
			// Gui cau lenh READ qua Server
			String caulenh = "READ " + tenfile;
			ps.println(caulenh);
			// Nhan dong chua size la kich thuoc file
			String str = sc.nextLine();
			int size = Integer.parseInt(str);
			if(size<0)
				System.out.println("File khong ton tai");
			else
				if(size==0)
					System.out.println("File rong");
				else {
					FileOutputStream f = new FileOutputStream(tenfileluu);
					DataOutputStream dos = new DataOutputStream(f); 
					DataInputStream dis = new DataInputStream(is);
					// Nhan tiep size byte
					byte b[] = new byte[50000];
					int len = 0;
					while(true) {
						int n = dis.read(b);	// Doc n byte
						if(n>0) {
							dos.write(b,0,n);		// Ghi vao file ket qua
							len += n;
							System.out.println("Da nhan toi " + len + " byte");
						}
						if(len==size)	break;
					}
					f.close();
					System.out.println("Da ghi file thanh cong");
				}
			// Dong noi ket
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println(e);
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
