package com.board.oops;

public class Player {
    String name;
    Box position;

    public Player(String name){
        this.name = name;
        position = new Box(); // this constructor gives the starting position as 0,0;
    }
}
