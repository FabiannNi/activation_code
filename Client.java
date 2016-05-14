import java.io.IOException;
import java.net.Socket;

/**
 * Created by apple on 16/5/11.
 */
public class Client extends WrapperSocket{

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
}
