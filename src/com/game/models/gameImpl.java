package com.game.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gameImpl {
    int noOfPlayers;
    Board board;
    List<Player> players;
    Dice dice;
    GameStatus status;


    public gameImpl(String[] names){
        this.noOfPlayers = names.length;
        board = new BoardImpl();
        players = new ArrayList<Player>(noOfPlayers);
        dice = new DiceImpl();
        for(String each: names){
            players.add(new Player(each));
        }
        status = GameStatus.STARTED;
    }

    public void start(){
    Scanner scan = new Scanner(System.in);
    Player player = players.get(0);
    int playerNo=1;
    String dummy = "";
    status = GameStatus.PROGRESSING;
        while(true){
            playerNo = playerNo%noOfPlayers;
            player = players.get(playerNo);
            System.out.println("Player "+player.playerName+", its your chance. Press a key to throw dice");
            dummy = scan.nextLine();

            throwDiceAndUpdatePlayer(player);

            if(board.checkPlayerAction(player.getCurrentPos())){
                board.movePlayer(player);
            }
            if(board.checkWinner(player))break;
            ++playerNo;
        }
        status = GameStatus.ENDED;
        System.out.println("Player "+player.getPlayerName()+" won the game");

    }


    private void throwDiceAndUpdatePlayer(Player player){
        int noOnDice = 0;
        int six_count = 0;
        do {
             noOnDice = dice.diceThrow();
            if(noOnDice==6)six_count++;
            System.out.println("Dice for player " + player.playerName + ", :" + noOnDice);
            if(!validMove(player.getCurrentPos(),noOnDice)){
                System.out.println("No Enough no of steps to move forward");
                return;
            }
            player.setCurrentPos(player.getCurrentPos() + noOnDice);
            System.out.println("New Position for player " + player.getPlayerName() + " , :"+player.getCurrentPos());
        }while(noOnDice==6 && six_count<3);
    }


    private boolean validMove(int pos, int dice){
        if(pos+dice>100)return false;
        return true;
    }






}
