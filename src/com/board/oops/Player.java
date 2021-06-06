package com.board.oops;

public class Player {
    String name;
    Box position;

    public Player(String name){
        this.name = name;
        position = new Box();
    }
}
