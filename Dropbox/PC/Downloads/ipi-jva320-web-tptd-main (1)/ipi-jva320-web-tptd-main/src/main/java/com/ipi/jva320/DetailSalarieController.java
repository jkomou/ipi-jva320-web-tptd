package com.ipi.jva320;

import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class DetailSalarieController {
    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;

    @GetMapping(value = "/salaries/{id}")
    public String detailSalarie(ModelMap modelMap, @PathVariable Long id) throws Exception {
        modelMap.put("salarie", salarieAideADomicileService.getSalarie(id));
        return "detail_Salarie";
    }

    @GetMapping(value = "/salaries/aide/new")
    public String aideSalaries(ModelMap modelMap) throws Exception {
        return "detail_Salarie";
    }

    @PostMapping(value = "/salaries/save")
    public String saveSalaries(SalarieAideADomicile salarie) throws Exception {
        salarieAideADomicileService.creerSalarieAideADomicile(salarie);
        return "detail_Salarie";
    }

    @PostMapping(value = "/salaries/{id}/update")
    public String updateSalarie(@PathVariable Long id, @ModelAttribute("salarie") SalarieAideADomicile salarie) throws Exception {
        salarie.setId(id);
        salarieAideADomicileService.updateSalarieAideADomicile(salarie);
        return "redirect:/salaries/" + id;
    }

    @GetMapping(value = "/salaries")
    public String listSalarie(ModelMap modelMap) throws Exception {
        modelMap.put("salaries", salarieAideADomicileService.getSalaries());
        return "list";
    }

    @GetMapping(value = "/salaries/delete/{id}")
    public String deleteSalarie(@PathVariable Long id) throws Exception {
        salarieAideADomicileService.deleteSalarieAideADomicile(id);
        return "list";
    }

    @GetMapping(value = "/salaries/recherche")
    public String rechercheParNom(@RequestParam("nom") String nom, ModelMap modelMap) throws Exception {
        modelMap.put("salaries", salarieAideADomicileService.getSalaries(nom));
        return "list";
    }
}
