package com.game.models;

public interface Board {
    public void movePlayer(Player player);
    public boolean checkPlayerAction(int currentPos);
    public boolean checkWinner(Player player);

}
