import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
class Server extends WrapperSocket{
	private ServerSocket server;
	private Socket socket;
	
		public Server(String SERVER_IP, int SERVER_PORT) throws IOException {
			//创建一个监听请求，监听接口为SERVER_PORT
			server = new ServerSocket();
		} 
		//To establish a server
		public void start() {
			try {
				//创建监听接口
				socket = server.accept();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				PrintWriter wp = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}

public class ServerMain extends WrapperSocket{
	public static int SERVER_PORT = 3000;
	public static String SERVER_IP = "localhost";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Server server;
			try {
				server = new Server(SERVER_IP,SERVER_PORT);
				server.start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
