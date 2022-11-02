package com.game.models;

public class Ladder implements PlayerAction{
    int startPos;
    int endPos;

    public Ladder(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void movePlayer(Player player){
        if(this.startPos!=player.currentPos)return;
        System.out.println("You climb ladder to "+endPos);
        player.setCurrentPos(player.getCurrentPos()+this.endPos);
    }
}
