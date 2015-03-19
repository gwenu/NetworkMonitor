package ag.networkmonitor.services.impl;

import java.util.List;

import ag.networkmonitor.models.SystemProcess;
import ag.networkmonitor.services.ProcessReceiver;

public class NetworkProcess {
	
	private ProcessReceiver processReceiver;
	
	public NetworkProcess(ProcessReceiver processReceiver) {
		this.processReceiver = processReceiver;
	}

	public List<SystemProcess> processList() {
		return processReceiver.processList();
	}
}
