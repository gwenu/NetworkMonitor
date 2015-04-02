package ag.networkmonitor.services.impl;

import java.util.List;

import ag.networkmonitor.models.SystemProcess;
import ag.networkmonitor.services.ProcessReceivable;

public class SystemProcessProvider {
	
	private ProcessReceivable processReceiver;
	
	public SystemProcessProvider(ProcessReceivable processReceiver) {
		this.processReceiver = processReceiver;
	}

	public List<SystemProcess> processList() {
		return processReceiver.listProcess();
	}
}
