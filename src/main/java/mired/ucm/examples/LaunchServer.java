package mired.ucm.examples;

public class LaunchServer {
	public static void main(String args[]) {
		new Thread() {
			public void run() {
				try {
					mired.ucm.examples.server.RunServer1.main(new String[]{});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();

	}
}
