package com.ipi.jva350.service;

import com.ipi.jva350.model.Entreprise;
import com.ipi.jva350.model.*;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalarieAideADomicileServicecalculeLimiteEntrepriseCongesPermisTest {


    @Test
    void calculeLimiteEntrepriseCongesPermis() {
            Entreprise entreprise = new Entreprise();
            SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2020, 7, 1), LocalDate.now(),0, 0, 9, 1, 0);

            double congesPayesPrisAnneeNMoins1 = 2.1;
            LocalDate premierJourDeConge = LocalDate.of(2022, 12, 1);
            LocalDate dernierJourDeConge = LocalDate.of(2022, 12, 15);

            assertEquals(SalarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(aide.getMoisEnCours(), congesPayesPrisAnneeNMoins1, aide.getMoisDebutContrat(), premierJourDeConge, dernierJourDeConge), 2);
    }
}