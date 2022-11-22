package CopyFile_NhiPhan;
import java.util.Scanner;
import java.io.*;
class CopyFile3 {
	public static void main(String[] args) {
		try {
			// Nhap tu ban phim ten file doc va ten file can ghi
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file can doc: ");
			String tenfiledoc = kb.nextLine();
			System.out.print("Nhap ten file can ghi: ");
			String tenfileghi = kb.nextLine();
			// Mo file
			FileInputStream f1 = new FileInputStream(tenfiledoc);
			FileOutputStream f2 = new FileOutputStream(tenfileghi);
			// Tao ra buffer
			File f = new File(tenfiledoc);
			int len = (int)f.length();
			System.out.println("Kich thuoc file: " + len);
			byte b[] = new byte[50000];
			int tongbytedadoc = 0;
			while(true) {
				int n = f1.read(b);		// Doc duoc n byte
				tongbytedadoc += n;
				System.out.println("Da doc den vi tri " + tongbytedadoc);
				f2.write(b,0,n);		// Ghi n byte
				if(tongbytedadoc==len) break;
			}
			// Dong file
			f1.close();
			f2.close();
			System.out.println("Da copy file thanh cong");
		}
		catch(FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat file");
		}
	}
}