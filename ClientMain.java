import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client extends WrapperSocket{
	private  Client(){
	}
	public Client(String SERVER_IP, int SERVER_PORT){
		try {
			this.socket = new Socket(SERVER_IP,SERVER_PORT);
			this.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void receive(String str) {
		System.out.println(str);
	}

}
public class ClientMain  {
	private static String SERVER_IP = "localhost";
	private static int SERVER_PORT = 3010;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Client client = new Client(SERVER_IP, SERVER_PORT);

		Scanner sc =new Scanner(System.in);
		while (sc.hasNext()){
			client.send(sc.nextLine());
		}
	}

}
