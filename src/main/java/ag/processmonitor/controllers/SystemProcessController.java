package ag.processmonitor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ag.processmonitor.models.SystemProcess;
import ag.processmonitor.services.impl.SystemProcessProvider;

@RestController
public class SystemProcessController {
    private static final String template = "Hello, %s!";
    
    @Autowired
    private SystemProcessProvider processProvider;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return String.format(template, name);
    }
    
    @RequestMapping("/list")
    public List<SystemProcess> greeting() {
        return processProvider.processList();
    }
}
