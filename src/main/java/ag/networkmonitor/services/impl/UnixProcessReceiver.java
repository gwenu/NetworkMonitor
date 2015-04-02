package ag.networkmonitor.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ag.networkmonitor.models.SystemProcess;
import ag.networkmonitor.services.ProcessReceivable;

public class UnixProcessReceiver implements ProcessReceivable {

	@Override
	public List<SystemProcess> listProcess() {
		try {
		    // Execute command
		    String command = "ps aux";
		    Process child = Runtime.getRuntime().exec(command);

		    // Get the input stream and read from it
		    InputStream in = child.getInputStream();
		    
		    // TODO: Implement mapper to SystemProcess and then print obj
		    int c;
		    while ((c = in.read()) != -1) {
		        System.out.print((char)c);
		    }
		    in.close();
		} catch (IOException e) {
		}
		return null;
	}

}
