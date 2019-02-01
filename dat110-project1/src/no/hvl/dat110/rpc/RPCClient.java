package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() {
		
		// TODO: connect using the underlying messaging layer connection
		connection = msgclient.connect();
		
//	    throw new RuntimeException("not yet implemented");
			
	}
	
	public void disconnect() {
		
		// TODO: disconnect/close the underlying messaging connection
		connection.close();
		
//		throw new RuntimeException("not yet implemented");
		
	}
	
	public byte[] call(byte[] rpcrequest) {
		
		byte[] rpcreply;
		
		/* TODO: 
		
		Make a remote call on the RPC server by sending a request message
		and receive a reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		
		Message request = new Message(rpcrequest);
		connection.send(request);
		
		Message reply = connection.receive();
		rpcreply = reply.getData();
		
//		if (true) {
//		  throw new RuntimeException("not yet implemented");
//		}
		
		return rpcreply;
		
	}

}
