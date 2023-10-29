package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peaksoft.model.Application;
import peaksoft.service.impl.ApplicationService;

import java.util.List;
@Controller
@RequestMapping("/applications")

public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/applications/search")
    public String searchApplicationByName(@RequestParam("name") String name, Model model) {
        List<Application> applications = applicationService.searchApplicationByName(name);
        model.addAttribute("applications", applications);
        return "search_results";
    }

}
