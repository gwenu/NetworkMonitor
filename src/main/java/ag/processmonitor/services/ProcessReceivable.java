package ag.processmonitor.services;

import java.util.List;

import ag.processmonitor.models.SystemProcess;


public interface ProcessReceivable {
	
	public List<SystemProcess> listProcess();

}
