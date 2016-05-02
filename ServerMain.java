import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
class Server extends WrapperSocket{
	private ServerSocket server;
	
	public Server(int SERVER_PORT){
		//创建一个监听请求，监听接口为SERVER_PORT
		try {
			server = new ServerSocket(SERVER_PORT);
			socket = server.accept();
			this.init();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//To establish a server

	@Override
	public void receive(String str) {
		System.out.println("do something");
		System.out.println(str);
	}
}

public class ServerMain{
	public static int SERVER_PORT = 3010;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Server server = new Server(SERVER_PORT);
			server.start();
	}

}
