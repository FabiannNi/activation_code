import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

class Client extends WrapperSocket{
	private Socket server;
	private PrintWriter out;
	private BufferedReader in;
	public  Client(){
	}
	public Client(String SERVER_IP, int SERVER_PORT) throws IOException{
		this.connect(SERVER_IP, SERVER_PORT);
	}
	public void send(String sendMessage){
		out.println(sendMessage);
		out.flush();
	}
	public void connect(String SERVER_IP, int SERVER_PORT) throws IOException{
		this.socket = new Socket(SERVER_IP,SERVER_PORT);
		this.out = new PrintWriter(server.getOutputStream());
		this.in = new BufferedReader(new InputStreamReader(server.getInputStream()));
	}	
}
public class ClientMain  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String SERVER_IP = "localhost";
		int SERVER_PORT = 3000;		
		Client client = new Client();
		try {
			client.connect(SERVER_IP,SERVER_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		client.send(AskCode.encryptedAskCode);
	}

}
