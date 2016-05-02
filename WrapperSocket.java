import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class WrapperSocket extends Thread {
	protected Socket socket = null;
	protected OutputStream out;
	protected InputStream in;
//	protected ServerSocket server;
//	private boolean listening= true;
	public void send(String data){
		if(socket == null){
			return;
		}
		PrintWriter pw = new PrintWriter(out);
		pw.println(data);
		pw.flush();
	}
	public abstract void receive(String str);

	protected void init() {
		try {
			this.in = socket.getInputStream();
			this.out = socket.getOutputStream();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run(){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		while(this.socket != null){
			try {
				String str = bufferedReader.readLine();
				if(str != null) {
					this.receive(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
}

	

