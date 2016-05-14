import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by apple on 16/5/11.
 */
public class AskCode {
    static String askCode = "";
    String encryptedAskCode = "";
    public static String getAskCode(String macAddress, String CPUId) {
        if(macAddress != null && !"".equals(macAddress)){
            for(int i =0; i<macAddress.length();i++){
                int number = macAddress.charAt(i);
                if(number<=57&&number>=48)
                    askCode += macAddress.charAt(i);
            }
        }
        System.out.println(askCode);

        return askCode;
    }

    public static String encryptByPublicKey(String data, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
//    ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] ciphercode = cipher.doFinal(data.getBytes());
//        out.write(ciphercode);
//        String encrypedcode = out.toString();
        return ciphercode.toString();
    }
    public static String decrypeByPrivatekey(String receivedData, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] deciphercode = cipher.doFinal(receivedData.getBytes());
        return deciphercode.toString();
    }
}


