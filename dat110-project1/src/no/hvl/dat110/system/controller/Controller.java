package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCServerStopStub;

public class Controller {

	private static int N = 5;

	public static void main(String[] args) {

		Display display;
		Sensor sensor;

		RPCClient displayclient, sensorclient;

		System.out.println("Controller starting ...");

		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();

		displayclient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST, Common.SENSORPORT);

		// TODO
		// create display and sensor object

		// register RPC methods in the RPC layer

		display = new Display();
		sensor = new Sensor();

		displayclient.register(display);
		sensorclient.register(sensor);
		// register stop methods in the RPC middleware
		displayclient.register(stopdisplay);
		sensorclient.register(stopsensor);
		
		
		
		boolean stop = false;
		while (!stop) {
			
			String i = Integer.toString(sensor.read());
			display.write(i);
			
			
			if(i.equals("5")) {
				stop = true;
			}

		}
		// TODO:
		// loop while reading from sensor and write to display via RPC

		stopdisplay.stop();
		stopsensor.stop();

		displayclient.disconnect();
		sensorclient.disconnect();

		System.out.println("Controller stopping ...");

	}
}