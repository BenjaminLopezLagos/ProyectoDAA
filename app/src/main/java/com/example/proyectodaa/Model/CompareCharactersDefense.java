package com.example.proyectodaa.Model;

import java.util.Comparator;

public class CompareCharactersDefense implements Comparator<Character> {
    @Override
    public int compare(Character c1, Character c2) {
        return Double.compare(c1.getDefense(),c2.getDefense());
    }
}
