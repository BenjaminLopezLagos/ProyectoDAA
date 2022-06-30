package com.example.proyectodaa.Model;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CharacterGenerator {
    public static ArrayList<Character> generateList() {
        ArrayList<Character> l = new ArrayList<>();
        Character a = CharacterGenerator.Johnny();
        Character b = CharacterGenerator.Eddie();
        Character c = CharacterGenerator.Justice();
        Character d = CharacterGenerator.Kliff();
        Character e = CharacterGenerator.Ky();
        Character f = CharacterGenerator.RoboKy();
        Character g = CharacterGenerator.Slayer();
        Character h = CharacterGenerator.Sol();
        Character i = CharacterGenerator.Testament();

        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);
        l.add(f);
        l.add(g);
        l.add(h);
        l.add(i);
        return l;
    }

    // done
    public static Character Johnny() {
        String name = "Johnny";
        String codeName = "ACPRJO";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 1.0, 4, 70, 0.98f, MoveList);
    }

    //done
    public static Character Eddie() {
        String name = "Eddie";
        String codeName = "ACPRED";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 1.06, 0, 60, 1.0f, MoveList);
    }

    //done
    public static Character Justice() {
        String name = "Justice";
        String codeName = "ACPRJU";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 1.03, 4, 70, 1.05f, MoveList);
    }

    public static Character Kliff() {
        String name = "Kliff";
        String codeName = "ACPRKL";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 1.06, 0, 50, 1.1f, MoveList);
    }

    //done
    public static Character Ky() {
        String name = "Ky";
        String codeName = "ACPRKY";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 1.03, 2, 60, 1.0f, MoveList);
    }

    public static Character RoboKy() {
        String name = "RoboKy";
        String codeName = "ACPRRO";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 0.89, 0, 80, 0.95f, MoveList);
    }

    public static Character Slayer() {
        String name = "Slayer";
        String codeName = "ACPRSL";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 0.96, 2, 70, 1.0f, MoveList);
    }

    public static Character Sol() {
        String name = "Sol";
        String codeName = "ACPRSO";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 1.0, 1, 60, 1.0f, MoveList);
    }

    public static Character Testament() {
        String name = "Testament";
        String codeName = "ACPRTE";
        LinkedHashMap<String, Attack> MoveList = new LinkedHashMap<>();

        return new Character(name, codeName, 1.0, 0, 65, 1.0f, MoveList);
    }
}
