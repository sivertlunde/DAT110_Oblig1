package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp = 0;

		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		byte[] mInt = RPCUtils.marshallInteger(RPCID, temp);
		byte[] call = rmiclient.call(mInt);
		temp = RPCUtils.unmarshallInteger(call);

		return temp;
		
	}
}