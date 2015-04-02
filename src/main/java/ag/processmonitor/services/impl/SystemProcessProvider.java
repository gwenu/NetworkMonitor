package ag.processmonitor.services.impl;

import java.util.List;

import ag.processmonitor.models.SystemProcess;
import ag.processmonitor.services.ProcessReceivable;

public class SystemProcessProvider {
	
	private ProcessReceivable processReceiver;
	
	public SystemProcessProvider(ProcessReceivable processReceiver) {
		this.processReceiver = processReceiver;
	}

	public List<SystemProcess> processList() {
		return processReceiver.listProcess();
	}
}
