package com.game.models;

public class Player {
    int currentPos;
    String playerName;

    public Player(String playerName) {
        this.currentPos = 0;
        this.playerName = playerName;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }
}
