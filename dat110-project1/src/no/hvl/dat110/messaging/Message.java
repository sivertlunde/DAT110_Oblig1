package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {
		// encapsulate/encode the payload of the message
		byte[] encoded = new byte[128];
		int lengdePayload = payload.length;
		encoded[0] = (byte) lengdePayload;
		for (int i = 1; i < payload.length + 1; i++) {
			encoded[i] = payload[i - 1];
		}

//				if (true) {
//					throw new RuntimeException("not yet implemented");
//				}

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		int payloadlength = (int) received[0];
		payload = new byte[payloadlength];
		for(int i = 0; i < payloadlength; i++) {
			payload[i] = received[i+1];
		}

		// throw new RuntimeException("not yet implemented");

	}
}
