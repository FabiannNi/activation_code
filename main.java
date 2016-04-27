import java.io.IOException;

public class Verify {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//搭建客户端平台
		Client client = new Client();
		//搭建服务器端
		Server server = new Server();
		server.server();
	
		
		//提取mac地址、ip地址、CPU主板信息
		String ip = Util.getIP();
		String macAddress = Util.getMac(ip);
		String CPUId = Util.getCPUInfo();
		//根据mac、ip地址生成验证码
		AskCode askcode = new AskCode();
		askcode.askCode = AskCode.getAskCode(macAddress, CPUId);
		//对请求码加密
		askcode.encryptedAskCode = askcode.enCrypt(askcode.askCode); 
		//将加密之后的请求码送至服务器端
		client.sendCode(askcode, server.host, server.port);
		//服务器用私钥解密，数据库记录信息（CPU、MAC地址）、生成验证码、发送到注册邮箱、完成注册
		
		//验证阶段
		//用户输入验证码，验证码与MAC地址发送至服务器端，完整授权，否则（如果MAC地址、验证码不能对应）授权无效
		
		
	}

}
