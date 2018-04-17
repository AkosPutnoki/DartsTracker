package com.example.jeno.dartstracker.Util;

public class Switcher {

    private boolean playerSwitch;
    private boolean legSwitch;
    private boolean scoreSwitch;

    public Switcher(boolean playerSwitch, boolean legSwitch, boolean scoreSwitch) {
        this.playerSwitch = playerSwitch;
        this.legSwitch = legSwitch;
        this.scoreSwitch = scoreSwitch;
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

    public boolean isScoreSwitch() {
        return scoreSwitch;
    }

    public void setScoreSwitch(boolean scoreSwitch){
        this.scoreSwitch = scoreSwitch;
    }


}
