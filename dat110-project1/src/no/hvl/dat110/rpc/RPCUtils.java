package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length()+1];
		System.out.println(str.length());
		
		encoded[0] = rpcid;
		
		byte[] stringToByte = str.getBytes();
		for (int i = 0; i < stringToByte.length; i++) {
			encoded[i+1] = stringToByte[i];
		}

		// TODO: marshall RPC identifier and string into byte array

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
		// TODO: unmarshall String contained in data into decoded
		String decoded;
		
		byte[] bytesToString = new byte[data.length-1];
		for (int i = 1; i < data.length; i++) {
			bytesToString[i-1] = data[i];
		}
		
		decoded = new String(bytesToString);
		System.out.println(decoded.length());
		

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		// TODO: marshall RPC identifier in case of void type
		encoded[0] = rpcid;

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[128];

		// TODO: marshall RPC identifier and string into byte array
		encoded[0] = rpcid;
		byte[] intToByte = ByteBuffer.allocate(4).putInt(x).array();
		for (int i = 0; i < intToByte.length; i++) {
			encoded[i+1] = intToByte[i];
		}

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {
		// TODO: unmarshall integer contained in data

		int decoded;
		byte[] byteToInt = new byte[data.length];
		for (int i = 1; i < data.length; i++) {
			byteToInt[i-1] = data[i];
		}
		decoded = ByteBuffer.wrap(byteToInt).getInt();
		
//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return decoded;

	}
}
