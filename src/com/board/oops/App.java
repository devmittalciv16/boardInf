package com.board.oops;

public class App {
    public static void main(String[] args) {

        Game game = new Game("Sanket", "Vinit");

        while (!game.isOver){
            game.proceed();
        }
    }
}
