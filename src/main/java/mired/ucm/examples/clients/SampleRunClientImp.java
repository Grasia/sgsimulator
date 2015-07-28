package mired.ucm.examples.clients;

import java.rmi.RemoteException;

import mired.ucm.remote.client.SGClient;
import mired.ucm.remote.orders.RemoteSwitchOff;
import mired.ucm.remote.orders.RemoteSwitchOn;
import mired.ucm.remote.server.RemoteSGServer;
import mired.ucm.simulator.SensorContainerNotFound;

public class SampleRunClientImp {
	public static void main(String args[]) throws Exception {
		RunClient.launchAndWaitForServerShutdown(new SGClient() {

			boolean finished = false;

			@Override
			public String getName() throws RemoteException {
				return "transformerCT1";
			}

			@Override
			public void serverStopped() throws RemoteException {
				// invoked when the server has stopped
			}

			@Override
			public void serverStarted(RemoteSGServer server)
					throws RemoteException {
				System.out.println(server.getSubstationSensors());
				try {
					System.out.println(server.getTransformerSensors(this
							.getName()));
					System.out.println(server.getControllableDevices(this
							.getName()));
					server.executeOrder(this.getName(), new RemoteSwitchOn(
							"Solar_11"));
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					server.executeOrder(this.getName(), new RemoteSwitchOn(
							"Solar_11"));
					finished = true;
				} catch (SensorContainerNotFound e) {
					e.printStackTrace();
				}
			}

			@Override
			public boolean isFinished() {
				return finished;
			}
		});
	}
}
