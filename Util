import java.io.IOException;
import java.util.Scanner;

public class Util {

	public static String getIP() {
		return null;
	}

	public static String getCPUInfo() throws IOException {
			Process process = Runtime.getRuntime().exec("wmic CPU get processorID");
			process.getOutputStream();
			Scanner sc = new Scanner(process.getInputStream());
			String name = sc.next();
			String serial = sc.next();
			System.out.println(name+ "的cpu信息是： "+serial );
			return serial;
		
	}

	public static String getMac(String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String askCode(String macAdress, String cPUId) {
		String askCode = "";
		if(macAdress != null && !"".equals(macAdress)){
		for(int i =0; i<macAdress.length();i++){
			int number = macAdress.charAt(i);
			if(number<=57&&number>=48)
			 askCode += macAdress.charAt(i);
		}
		}
		System.out.println(askCode);

		return askCode;
	}

}
