package readFile;
import java.util.Scanner;
import java.io.*;
class DocFile2 {
	public static void main(String[] args) {
		try {
			// Nhap ten file can doc
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file: ");
			String tenfile = kb.nextLine();
			// Doc file va hien thi
			FileInputStream f = new FileInputStream(tenfile);
			File f1 = new File(tenfile);
			int len1 = (int)f1.length();
			System.out.println("Kich thuoc file: " + len1 + " byte");
			byte b[] = new byte[len1];
			int n = f.read(b);
			f.close();
			System.out.println("Doc duoc: " + n + " byte");
			System.out.println("ND file text:");
			String ketqua = new String(b);
			System.out.println(ketqua);
		}
		catch(FileNotFoundException e) {
			System.out.println("File khong ton tai");
		}
		catch(IOException e) {
			System.out.println("Loi khi doc file");
		}
	}
}