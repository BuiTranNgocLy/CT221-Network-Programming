package readFile;
import java.util.Scanner;
import java.io.*;
class DocFile1 {
	public static void main(String[] args) {
		try {
			// Nhap ten file can doc
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file: ");
			String tenfile = kb.nextLine();
			// Doc file va hien thi
			FileInputStream f = new FileInputStream(tenfile);
			System.out.println("ND file text:");
			while(true) {
				int ch = f.read();
				if(ch==-1) break;
				System.out.print((char)ch);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File khong ton tai");
		}
		catch(IOException e) {
			System.out.println("Loi khi doc file");
		}
	}
}
