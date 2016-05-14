import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
public class ClientMain  {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String SERVER_IP = "localhost";
        int SERVER_PORT = 3010;
        //获取Mac地址和CPU信息来获得请求码
        String macAddress = Util.getMacAddress();
        String CPUId = Util.getCPUInfo();
        String askcode = AskCode.getAskCode(macAddress,CPUId);
        //建立客户端
        Client client = new Client(SERVER_IP, SERVER_PORT);
        client.start();
        //加密请求码发送
        Keys keys = new Keys();
        keys.generateKey();
        client.send(AskCode.encryptByPublicKey(askcode, keys.publicKey));
    }

}
