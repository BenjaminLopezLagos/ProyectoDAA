package com.example.proyectodaa.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class Character implements Serializable {
    private String name;
    private String codeName;
    private Double defense;
    private Integer guts;
    private Integer stunResistance;
    private Float weightMultiplier;
    private LinkedHashMap<String, Attack> MoveList;

    public Character() {
        this.name = "name";
        this.codeName = "codeName";
        this.defense = 0.0;
        this.guts = 0;
        this.stunResistance = 0;
        this.weightMultiplier = 0.0f;
        MoveList = new LinkedHashMap<>();
    }

    public Character(String name, String codeName, Double defense, Integer guts, Integer stunResistance, Float weightMultiplier, LinkedHashMap<String, Attack> moveList) {
        this.name = name;
        this.codeName = codeName;
        this.defense = defense;
        this.guts = guts;
        this.stunResistance = stunResistance;
        this.weightMultiplier = weightMultiplier;
        MoveList = moveList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Double getDefense() {
        return defense;
    }

    public void setDefense(Double defense) {
        this.defense = defense;
    }

    public Integer getGuts() {
        return guts;
    }

    public void setGuts(Integer guts) {
        this.guts = guts;
    }

    public Integer getStunResistance() {
        return stunResistance;
    }

    public void setStunResistance(Integer stunResistance) {
        this.stunResistance = stunResistance;
    }

    public Float getWeightMultiplier() {
        return weightMultiplier;
    }

    public void setWeightMultiplier(Float weightMultiplier) {
        this.weightMultiplier = weightMultiplier;
    }

    public LinkedHashMap<String, Attack> getMoveList() {
        return MoveList;
    }

    public void setMoveList(LinkedHashMap<String, Attack> moveList) {
        MoveList = moveList;
    }

    @NonNull
    @Override
    public String toString() {
        return
                name + "\n" +
                        codeName + "\n" +
                        "Multiplicador de defensa:" + defense + "\n" +
                        "Guts:" + guts + "\n" +
                        "Resistencia al Aturdimiento: " + stunResistance + "\n" +
                        "Multiplicador de Peso: " + weightMultiplier;
    }
}
