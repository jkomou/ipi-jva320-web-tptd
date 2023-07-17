package com.ipi.jva320;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;

    @Value("${app.welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
    public String home(Model model) {
        Long numberOfSalaries = salarieAideADomicileService.countSalaries();
        model.addAttribute("numberOfSalaries", numberOfSalaries);
        model.addAttribute("message", "Bienvenue sur mon site");
        return "home";
    }
}

