package com.example.proyectodaa.Model;

public class Attack {
    private final String attackNotation;
    private final String damage;
    private final String guard;
    private final String attackLevel;
    private final String startupFrames;
    private final String activeFrames;
    private final String recoveryFrames;
    private final String frameAdvantage;
    private final String iFrames;

    public Attack(String attackNotation, String damage, String guard,
                  String attackLevel, String startupFrames, String activeFrames,
                  String recoveryFrames, String frameAdvantage, String iFrames) {
        this.attackNotation = attackNotation;
        this.damage = damage;
        this.guard = guard;
        this.attackLevel = attackLevel;
        this.startupFrames = startupFrames;
        this.activeFrames = activeFrames;
        this.recoveryFrames = recoveryFrames;
        this.frameAdvantage = frameAdvantage;
        this.iFrames = iFrames;
    }

    public String getAttackNotation() {
        return attackNotation;
    }

    public String getDamage() {
        return damage;
    }

    public String getGuard() {
        return guard;
    }

    public String getStartupFrames() {
        return startupFrames;
    }

    public String getActiveFrames() {
        return activeFrames;
    }

    public String getRecoveryFrames() {
        return recoveryFrames;
    }

    public String getFrameAdvantage() {
        return frameAdvantage;
    }

    public String getiFrames() {
        return iFrames;
    }

    public String getAttackLevel() {
        return attackLevel;
    }
}
