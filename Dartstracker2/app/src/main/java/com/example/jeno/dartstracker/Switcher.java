package com.example.jeno.dartstracker;

public class Switcher {

    private boolean playerSwitch;
    private boolean legSwitch;

    public Switcher(boolean playerSwitch, boolean legSwitch) {
        this.playerSwitch = playerSwitch;
        this.legSwitch = legSwitch;
    }

    public void playerSwitcher(){
        playerSwitch = !playerSwitch;
    }

    public void legSwitcher(){
        legSwitch = !legSwitch;
    }

    public boolean isPlayerSwitch() {
        return playerSwitch;
    }

    public void setPlayerSwitch(boolean playerSwitch) {
        this.playerSwitch = playerSwitch;
    }

    public boolean isLegSwitch() {
        return legSwitch;
    }
}
