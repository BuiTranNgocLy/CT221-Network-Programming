package buoi02;

import java.util.Arrays;
import java.util.Scanner;

public class tess {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hoTen;
		hoTen = new String();
		System.out.print("Nhap ho ten cua ban: ");
		hoTen = sc.nextLine();
		

		String[] d= hoTen.split(" ");
		//System.out.println(Arrays.toString(d));
		System.out.println("Tên: "+d[d.length-1]);
	}
		//ham lay ten
//		public String layTen(String hoTen) {
//			String layTen = new String(hoTen);
//			layTen = layTen.trim();
//			return layTen.substring(layTen.lastIndexOf(" ")+1);
//		}
//		//ham lay ho ten
//		public String lay_hoTen() {
//			return lay_hoTen();
//		}
}