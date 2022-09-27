package buoi01;

import java.net.*;
import java.io.*;
public class server1 {
	//Method bat dau 1 server
	public void start(int port) throws IOException {
		//khoi tao cong server se lang nghe
		ServerSocket ss = new ServerSocket(port);
		// lang nghe yeu cau ket noi của client
		ClientSocket s = ss.accept();
		
		
	}
	public static void main(String[] args) {
		
	}
}