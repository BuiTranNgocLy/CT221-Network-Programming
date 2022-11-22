package readFile;

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;
class DocFile3 {
	public static void main(String[] args) {
		try {
			// Nhap tu ban phim ten file can doc
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file can doc: ");
			String tenfile = kb.nextLine();
			// Mo file
			FileInputStream f = new FileInputStream(tenfile);
			// Chuyen doi sang Scanner
			Scanner sc = new Scanner(f);
			System.out.println("Noi dung file");
			try {
				while(true) {
					String str = sc.nextLine();
					System.out.println(str);
				}
			}
			catch(NoSuchElementException e) {
				System.out.println("Da doc den cuoi file");
			}
			f.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File khong ton tai");
		}
		catch(IOException e) {
			System.out.println("Loi khi doc file");
		}
	}
}