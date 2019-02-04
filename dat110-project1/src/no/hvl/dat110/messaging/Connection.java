package no.hvl.dat110.messaging;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection

	public Connection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream(socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {

		// TODO
		// encapsulate the data contained in the message and write to the output stream
		try {
			outStream.write(message.encapsulate());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("EYO");
			e.printStackTrace();
		}

//		throw new RuntimeException("not yet implemented");

	}

	public Message receive() {
		Message message = new Message();
		byte[] recvbuf = new byte[128];

		// TODO
		// read a segment from the input stream and decapsulate into message
		try {
			inStream.read(recvbuf);
			message.decapsulate(recvbuf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return message;

	}

	// close the connection by closing streams and the underlying socket
	public void close() {

		try {

			outStream.close();
			inStream.close();

			socket.close();
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}