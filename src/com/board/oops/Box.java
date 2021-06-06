package com.board.oops;

public class Box {
    int x, y;
    boolean snakeHead = false;
    boolean ladderTail = false;
    Box snakeTail;
    Box ladderHead;
    public Box(){
        this.x = 0;
        this.y = 0;
    }
    public Box(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Box(Box old, int roll){
        this.x = old.x;
        this.y = old.y + roll;
        if(old.y + roll > 9 ){
            this.x = old.x + 1;
            this.y = (old.y + roll) % 10;
        }
    }
    public Box(Box box){
        this.x = box.x;
        this.y = box.y;
    }
}
