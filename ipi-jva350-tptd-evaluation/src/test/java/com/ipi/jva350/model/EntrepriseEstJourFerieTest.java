package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static com.ipi.jva350.model.Entreprise.bissextile;
import static org.junit.jupiter.api.Assertions.*;

class EntrepriseEstJourFerieTest {

    public static boolean estJourFerie(LocalDate jour) {
        int monEntier = (int) Entreprise.joursFeries(jour).stream().filter(d ->
                d.equals(jour)).count();
        int test = bissextile(jour.getYear()) ? 1 : 0;
        if (test != 0 && !(monEntier > 1)) {
            test--;
        }
        return monEntier != test;
    }

    @ParameterizedTest(name = "Le jour choisi est un jour férié")

    void estJourFerie() {
        boolean res = estJourFerie(LocalDate.of(2022,12,25));
        Assertions.assertEquals(true, res);
    }
}