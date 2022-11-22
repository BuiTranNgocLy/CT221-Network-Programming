package Basic;
import java.util.Scanner;
class TachTen {
	public static void main(String[] args) {
		// Nhap chuoi ho ten
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
		String hoten = kb.nextLine();
		// Tach ten
		hoten = hoten.trim();
		int i = hoten.lastIndexOf(' ');
		String ten = hoten.substring(i+1);
		// Hien thi
		System.out.println("Ten sau khi tach la: " + ten);
	}
}
