package com.example.proyectodaa.Model;

import java.util.Comparator;

public class CompareCharactersName implements Comparator<Character> {
    @Override
    public int compare(Character c1, Character c2) {
        return c1.getName().compareTo(c2.getName());
    }
}
