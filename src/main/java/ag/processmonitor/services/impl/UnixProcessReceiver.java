package ag.processmonitor.services.impl;

import ag.processmonitor.models.SystemProcess;
import ag.processmonitor.services.ProcessReceivable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class UnixProcessReceiver implements ProcessReceivable {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnixProcessReceiver.class.getName());

    @Override
    public List<SystemProcess> listProcess() {
        InputStream in = null;

        try {
            // Execute command (ProcessHandle doesn't have all same info, keep naive impl for now)
            String command = "ps aux";
            Process child = Runtime.getRuntime().exec(command);

            // Get the input stream and read from it
            in = child.getInputStream();
        } catch (IOException e) {
            LOGGER.error("Exception on parsing input: " + e);
        }

        return parseCommandResult(in);
    }

    private List<SystemProcess> parseCommandResult(InputStream in) {
        List<SystemProcess> processList = new ArrayList<>();

        boolean firstLine = true;
        Scanner scanner = new Scanner(in);

        //read file line by line
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            if (firstLine) {
                firstLine = false;
                scanner.nextLine();
            }

            SystemProcess process = parseLine(scanner.next());
            processList.add(process);
        }

        scanner.close();
        return processList;
    }

    private SystemProcess parseLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s+");

        String userValue = scanner.next();
        int pidValue = getIntValue(scanner.next());
        double cpuValue = getDoubleValue(scanner.next());
        double memValue = getDoubleValue(scanner.next());
        int vszValue = getIntValue(scanner.next());
        int rssValue = getIntValue(scanner.next());
        String ttyValue = scanner.next();
        String statValue = scanner.next();

        Date startValue = null;
        Date timeValue = null;
        DateFormat startTime = new SimpleDateFormat("HH:mm");

        try {
            startValue = startTime.parse(scanner.next());
            timeValue = startTime.parse(scanner.next());
        } catch (ParseException e) {
            LOGGER.error("Exception on parsing time: " + e);
        }

        String commandValue = scanner.next();
        scanner.close();

        SystemProcess process = new SystemProcess.Builder()
                .user(userValue)
                .pid(pidValue)
                .cpu(cpuValue)
                .mem(memValue)
                .vsz(vszValue)
                .rss(rssValue)
                .tty(ttyValue)
                .stat(statValue)
                .start(startValue)
                .time(timeValue)
                .command(commandValue)
                .build();

        return process;
    }

    private int getIntValue(String strValue) {
        int value = -1;

        try {
            value = Integer.parseInt(strValue);
        } catch (NumberFormatException exception) {
            LOGGER.error("Exception on parsing int value: " + exception);
        }

        return value;
    }

    private double getDoubleValue(String strValue) {
        double value = -1.0;

        if (strValue != null) {
            try {
                value = Double.parseDouble(strValue);
            } catch (NumberFormatException exception) {
                LOGGER.error("Exception on parsing double value: " + exception);
            }
        }

        return value;
    }
}
