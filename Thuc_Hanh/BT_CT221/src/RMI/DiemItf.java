package RMI;
import java.rmi.*;
interface  DiemItf extends Remote {
	// Khai bao cac ham goi tu xa
	public String layToaDo() throws RemoteException;
	public void ganDiem(int h, int t) throws RemoteException;
	public void doiDiem(int dx, int dy) throws RemoteException;
}
