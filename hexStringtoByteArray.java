import java.math.BigInteger;

import java.util.Arrays;


import java.math.BigInteger;
import java.util.Arrays;


public abstract class hexStringtoByteArray extends Client {
	//public class hexStringtoByteArray extends TCPClient1 {

	public static byte[] hexStringToByteArray(String s) {
		int lenght = s.length();
		byte[] data = new byte[lenght / 2];
		for (int i = 0; i < lenght; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i+1), 16));
		}	

		System.out.println("SENT TO ClIENT:" + Arrays.toString(data));
		return data;

	}

	public static String bytesToHex(byte[] in) {
		final StringBuilder builder = new StringBuilder();
		for(byte b : in) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}


}
