package com.example.proyectodaa.Model;

import java.util.Comparator;

public class CompareCharactersStunResistance implements Comparator<Character> {
    @Override
    public int compare(Character c1, Character c2) {
        return Integer.compare(c1.getStunResistance(),c2.getStunResistance());
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
