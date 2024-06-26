package com.example.nielferreiradesousaprojet.modele;

import com.example.nielferreiradesousaprojet.modele.Position;
import com.example.nielferreiradesousaprojet.modele.Temple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Classe de test des fonctions liées aux temples (classe Temple) */
public class TempleTest {

    /**
     * Crée un objet Temple.
     * Pas d'erreur si l'objet correspond aux attentes.
     */
    @Test
    public void Temple() {
        int numTemple=2;
        int numCristal=5;
        Position positionTemple = new Position(5,5);
        Temple templeTest= new Temple(new Position(5,5),2,5);
        boolean test1 = templeTest.getPos().equals(positionTemple);
        boolean test2 = templeTest.getCristal()==numCristal;
        boolean test3 = templeTest.getNum()==numTemple;
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

}