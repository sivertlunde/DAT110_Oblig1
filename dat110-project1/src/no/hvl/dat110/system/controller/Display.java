package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		
		byte[] mString = RPCUtils.marshallString(RPCID, message);
	
		
		byte[] call = rmiclient.call(mString);
		RPCUtils.unmarshallString(call);
	}
}