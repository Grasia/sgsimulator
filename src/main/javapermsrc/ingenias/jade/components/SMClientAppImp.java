/**
 *
 *
 *  Description of the task /
 *
 * 
 *@author     Jorge J. Gomez
 *@version    1.0
 */

package ingenias.jade.components;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.*;

import mired.ucm.remote.client.SGClientImp;
import mired.ucm.remote.orders.RemoteOrder;
import mired.ucm.remote.server.RemoteSGServer;
import mired.ucm.simulator.SensorIDS;
import ingenias.jade.exception.*;
import ingenias.jade.mental.*;
import ingenias.jade.components.*;
import ingenias.jade.smachines.*;

public class SMClientAppImp extends SMClientApp {

	private class InternalClient extends SGClientImp {
		public InternalClient(String clientID) throws RemoteException,
				AlreadyBoundException {
			super(clientID);
		}

		@Override
		public void serverStopped() throws RemoteException {

		}
	}

	InternalClient client = null;

	public SMClientAppImp() {
		super();
		new Thread() {
			public void run() {
				try {
					while (getOwner() == null)
						Thread.currentThread().sleep(1000);
					String host = getOwner().getMSM()
							.getMentalEntityByType(AssociatedUnit.class)
							.firstElement().getdevice();
					client = new InternalClient(host);
					mired.ucm.examples.clients.RunClient.launch(client);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public Hashtable<SensorIDS, Float> getSubstationSensors()
			throws RemoteException {
		try {
			if (client != null)
				return client.getServer().getSubstationSensors();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Hashtable<SensorIDS, Float>();

	}

	public Hashtable<SensorIDS, Float> getTransformationCentreSensors()
			throws RemoteException {
		if (client != null)
			try {
				return client.getServer().getTransformerSensors(
						client.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		return new Hashtable<SensorIDS, Float>();
	}

	@Override
	public void sendOrder(RemoteOrder order) throws RemoteException {
		if (client != null)
			client.getServer().executeOrder(client.getName(), order);
	}

}
