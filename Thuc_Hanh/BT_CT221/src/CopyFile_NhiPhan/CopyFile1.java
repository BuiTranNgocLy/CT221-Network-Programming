package CopyFile_NhiPhan;
import java.util.Scanner;
import java.io.*;
class CopyFile1 {
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
			// Doc noi dung file
			while(true) {
				int ch = f1.read();
				if(ch==-1) break;
				f2.write(ch);
			}
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