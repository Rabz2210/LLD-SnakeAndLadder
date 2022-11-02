package com.game.models;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.Map;

public class BoardImpl implements Board{
    Map<Integer,PlayerAction> snkAndLdr;

    BoardImpl(){
        snkAndLdr = SnakeAndLadderGenerator.generateRandomSnakeAndLadder();
    }

    @Override
    public void movePlayer(Player player) {
         snkAndLdr.get(player.getCurrentPos()).movePlayer(player);


    }


    @Override
    public boolean checkPlayerAction(int currentPos) {
        if(snkAndLdr.containsKey(currentPos))return true;
        else return false;
    }

    @Override
    public boolean checkWinner(Player player) {
        if(player.currentPos==100)return true;
        else return false;
    }
}
