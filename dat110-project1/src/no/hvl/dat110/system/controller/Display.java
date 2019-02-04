package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method

		byte[] mString = RPCUtils.marshallString(RPCID, message);
		RPCClient displayclient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		displayclient.connect();
		byte[] call =displayclient.call(mString);
		String svar = RPCUtils.unmarshallString(call);
		System.out.println(svar);
	}
}