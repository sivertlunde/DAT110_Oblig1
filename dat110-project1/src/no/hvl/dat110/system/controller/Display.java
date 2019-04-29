package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method

		byte[] mString = RPCUtils.marshallString(RPCID, message);
		byt[] call = rmiclient.call(mString);
		RPCUtils.unmarshall(call);
	}
}
