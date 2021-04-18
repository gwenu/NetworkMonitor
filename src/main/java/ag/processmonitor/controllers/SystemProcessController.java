package ag.processmonitor.controllers;

import ag.processmonitor.services.impl.SystemProcessProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemProcessController {
    
    @Autowired
    private SystemProcessProvider processProvider;

    @GetMapping("/")
    public String getProcessList(Model model) {
    	model.addAttribute("processes", processProvider.processList());
    
        return "index";
    }
}
