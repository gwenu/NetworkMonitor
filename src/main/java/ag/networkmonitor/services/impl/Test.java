package ag.networkmonitor.services.impl;

public class Test {
	public static void main(String[] args) {
		UnixProcessReceiver receiver = new UnixProcessReceiver();
		SystemProcessProvider provider = new SystemProcessProvider(receiver);
		
		provider.processList();
	}
}
