package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length() + 1];

		// TODO: marshall RPC identifier and string into byte array
		encoded[0] = rpcid;
		int strlen = str.length();
		String[] split = str.split("");
		char[] castChar = new char[split.length];
		for (int i = 0; i < strlen; i++) {
			castChar[i] = split[i].charAt(0);
			encoded[i + 1] = (byte) castChar[i];
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = new String(data);
		String[] fjern = decoded.split("");

		decoded = "";
		for (int i = 1; i < fjern.length; i++) {
			decoded += fjern[i];
		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		// TODO: marshall RPC identifier in case of void type
		encoded[0] = rpcid;

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

		byte[] encoded = new byte[5];

		encoded[0] = rpcid;
		byte[] intToByte = ByteBuffer.allocate(4).putInt(x).array();
		for (int i = 0; i < intToByte.length; i++) {
			encoded[i + 1] = intToByte[i];
		}
		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;
		byte[] byteToInt = new byte[data.length];
		for (int i = 1; i < data.length; i++) {
			byteToInt[i - 1] = data[i];
		}
		decoded = ByteBuffer.wrap(byteToInt).getInt();

		return decoded;

	}
}