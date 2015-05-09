package ag.processmonitor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ag.processmonitor.services.impl.SystemProcessProvider;

@RestController
public class SystemProcessController {
    private static final String INDEX_VIEW = "index";
    
    @Autowired
    private SystemProcessProvider processProvider;

    @RequestMapping("/")
    public ModelAndView getProcessList() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName(INDEX_VIEW);
    	model.addObject("list", processProvider.processList());
    
        return model;
    }
}
