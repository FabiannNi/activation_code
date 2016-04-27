import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;


public class Keys {
	PublicKey publicKey = null;
	PrivateKey privateKey = null;
	KeyPairGenerator generateKey = null;
	KeyPair keyPair = null;
	
	public void generateKey(){
		try {
			//生成RSA算法中的公钥和私钥
			generateKey = KeyPairGenerator.getInstance("RSA");
			generateKey.initialize(1024);
			keyPair = generateKey.generateKeyPair();
			publicKey = keyPair.getPublic();
			privateKey = keyPair.getPrivate();
			//保存公钥
			FileOutputStream outPublicKey = new FileOutputStream("E://publicKey.dat");
			ObjectOutputStream outPublicKey1 = new ObjectOutputStream(outPublicKey);
			outPublicKey1.writeObject(publicKey);
			//保存私钥
			FileOutputStream outPrivateKey = new FileOutputStream("E://privateKey.dat");
			ObjectOutputStream outPrivateKey1 = new ObjectOutputStream(outPrivateKey);
			outPrivateKey1.writeObject(privateKey);
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
