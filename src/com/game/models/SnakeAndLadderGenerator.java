package com.game.models;

import java.util.*;

public class SnakeAndLadderGenerator{
    public static Map<Integer, PlayerAction> generatePredefinedSnakeAndLadder() {
        Map<Integer,PlayerAction> snkAndLdr =  new HashMap<Integer,PlayerAction>();
        snkAndLdr.put(7,new Ladder(7,15));
        snkAndLdr.put(17,new Ladder(17,36));
        snkAndLdr.put(12,new Snake(12,2));
        snkAndLdr.put(29,new Snake(29,13));
        snkAndLdr.put(36,new Snake(35,1));
        return snkAndLdr;
    }

    public static Map<Integer, PlayerAction> generateRandomSnakeAndLadder(){
            Random random = new Random();
            Set<String> st = new HashSet<String>();
            Map<Integer,PlayerAction> snkAndLdr =  new HashMap<Integer,PlayerAction>();
            for(int i=0;i<10;i++){
                int snakeStart;
                int snakeEnd;
                while(true){
                    snakeStart = 7+random.nextInt(99);
                    snakeEnd = 1+random.nextInt(97);
                    if(snakeEnd>=snakeStart)continue;
                    String key = snakeStart+":"+snakeEnd;
                    if(!st.contains(key)){
                        st.add(key);
                        snkAndLdr.put(snakeStart,new Snake(snakeStart,snakeEnd));
                        break;
                    }
                }
            }

            for(int i=0;i<10;i++){
                int ladderStart;
                int ladderEnd;
                String key=null;
                st = new HashSet<String>();
                while(true){
                    ladderStart = 5+random.nextInt(95);
                    ladderEnd = random.nextInt(98);
                    if(ladderEnd<=ladderStart)continue;
                    key = ladderStart+":"+ladderEnd;
                    if(!st.contains(key)){
                        snkAndLdr.put(ladderStart,new Ladder(ladderStart,ladderEnd));
                        break;
                    }
                }
            }
            return snkAndLdr;
    }
}
