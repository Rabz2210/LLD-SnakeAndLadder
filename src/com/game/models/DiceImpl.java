package com.game.models;

import java.util.Random;

public class DiceImpl implements Dice{
     Random random;
     DiceImpl(){
         random = new Random();
     }

    @Override
    public int diceThrow() {
       return 1+random.nextInt(6);
    }
}
