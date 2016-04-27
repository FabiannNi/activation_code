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

	public String enCrypt(String askCode) {
		return askCode;
		
	}

}
