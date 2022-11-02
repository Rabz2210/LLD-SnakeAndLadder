package com.game.models;

public class Snake implements PlayerAction{
    private int startPos;
    private int endPos;

    public Snake(int startPos, int endPos) {
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
        if(this.startPos!=player.currentPos) return;
        System.out.println("Snake bite, You move back to "+this.endPos);
        player.setCurrentPos(player.getCurrentPos()+this.endPos);
    }
}

