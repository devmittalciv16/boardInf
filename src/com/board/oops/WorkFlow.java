package com.board.oops;


public class WorkFlow {
    public Player player1;
    public Player player2;
    public boolean turnFirstPlayer;
    public int roll;
    public Box newPosition;

    public WorkFlow(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.turnFirstPlayer = true;
        this.newPosition = new Box();
    }
}
