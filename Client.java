import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket clientSocket = null;
	private String ip = "127.0.0.1";
	private int port = 4242;
	private String sendMessages = "";
	
		
	
	public void sendCode(AskCode askCode,String host, int port) throws UnknownHostException, IOException{
		Socket client = new Socket(host,port);
		/*
		 * Coder笔记：
		 * FileInputStream(里面需要输入一个目标文件)同理DataInputStream/BufferedInputStream
		 * 要求传递参数，此处借用PrintWriter类,写入一个传递进去的参数
		 */
		PrintWriter printWriter = new PrintWriter(client.getOutputStream());
		printWriter.println(askCode);
		InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
	}

}
