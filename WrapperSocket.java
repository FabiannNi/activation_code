import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WrapperSocket extends Thread {
	protected Socket socket;
	protected ServerSocket server;
	private boolean listening= true;
	public void send(String data){
		
	}
	public void receive(String str){}
		
	@Override
	public void run(){
		while(listening){
			try {
				socket = server.accept();
				OutputStream out = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(out);
				String str2 = pw.toString();
				this.receive(str2);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			
			
					
			
		}
		}
}
}

	

