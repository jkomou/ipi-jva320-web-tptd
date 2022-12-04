package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseEstDansLaPlageTest {
    public static boolean estDansPlage(LocalDate d, LocalDate debut, LocalDate fin) {
        // à implémenter en TDD !
        return d.isAfter(debut) || d.isBefore(fin);
    }

    @Test
    void estDansPlage() {
        boolean res = estDansPlage(LocalDate.of(2020, 5, 10), LocalDate.of(2019,6,10), LocalDate.of(2022,6,1));
    }

    @Test
    void estDansPlageTrue() {
        boolean res = estDansPlage(LocalDate.of(2020, 5, 10), LocalDate.of(2019,6,10), LocalDate.of(2022,6,1));
        Assertions.assertEquals(true, res);
    }

    @Test
    void estDansPlageFalse() {
        boolean res = estDansPlage(LocalDate.of(2020, 5, 10), LocalDate.of(2019,6,10), LocalDate.of(2017,6,1));
        Assertions.assertEquals(false, res);
    }

    @Test
    void estDansPlageEgalite() {
        boolean res = estDansPlage(LocalDate.of(2020, 5, 10), LocalDate.of(2020, 5, 10), LocalDate.of(2022,6,1));
        Assertions.assertEquals(true, res);
    }


}