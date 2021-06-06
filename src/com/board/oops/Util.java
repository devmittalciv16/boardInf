package com.board.oops;

import java.util.Random;


public class Util {
    public static int diceRoll(WorkFlow workFlow){
        int num = Math.abs(new Random().nextInt())%6+1;
        workFlow.roll = num;
        return num;
    }

    public static void log(final String event, WorkFlow workFlow) {
        if(event.equals(Constants.ROLL)){
            logRoll(workFlow);
        }
        if(event.equals(Constants.BEFORE_MOVE)){
            logBeforeMove(workFlow);
        }
        if(event.equals(Constants.SHOULD_GO)){
            logShouldGo(workFlow);
        }
        if(event.equals(Constants.SNAKE)){
            logSnake(workFlow);
        }
        if(event.equals(Constants.SNAKE_MOVE)){
            logSnakeMove(workFlow);
        }
        if(event.equals(Constants.LADDER)){
            logLadder(workFlow);
        }
        if(event.equals(Constants.LADDER_MOVE)){
            logLadderMove(workFlow);
        }
        if(event.equals(Constants.WIN)){
            logWin(workFlow);
        }
        if(event.equals(Constants.INVALID_MOVE)){
            logInvalidMove(workFlow);
        }
    }

    private static void logInvalidMove(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " got an invalid move, it is overshooting the board's "
                    + "dimensions. Hence this move won't be counted, changing the turn to next player");
        }else{
            System.out.println(workFlow.player2.name + " got an invalid move, it is overshooting the board's "
                    + "dimensions. Hence this move won't be counted, changing the turn to next player");
        }
    }

    private static void logWin(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println( "!!!!! " + workFlow.player1.name + " WON !!!!!");
        }else{
            System.out.println( "!!!!! " + workFlow.player2.name + " WON !!!!!");
        }
        System.out.println("__GAME IS OVER__");
    }

    private static void logLadderMove(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " will now go to ladder's head, which is at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }else{
            System.out.println(workFlow.player2.name + " will now go to ladder's head, which is at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }
    }

    private static void logLadder(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " reached at a ladder's bottom at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }else{
            System.out.println(workFlow.player2.name + " reached at a ladder's bottom at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }
    }

    private static void logSnake(WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " got bit by snake at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }else{
            System.out.println(workFlow.player2.name + " got bit by snake at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }
    }

    private static void logSnakeMove(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " will now go to snake's tail, which is at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }else{
            System.out.println(workFlow.player2.name + " will now go to snake's tail, which is at "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }
    }

    private static void logShouldGo(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " should go to  "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }else{
            System.out.println(workFlow.player2.name + " should go to  "
                    + workFlow.newPosition.x + ", " + workFlow.newPosition.y);
        }
        System.out.println("Checking for snake and ladders ... ");
    }

    private static void logBeforeMove(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " was at "
                    + workFlow.player1.position.x + ", " + workFlow.player1.position.y);
        }else{
            System.out.println(workFlow.player2.name + " was at "
                    + workFlow.player2.position.x + ", " + workFlow.player2.position.y);
        }
    }

    private static void logAfterMove(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " is now at "
                    + workFlow.player1.position.x + ", " + workFlow.player1.position.y);
        }else{
            System.out.println(workFlow.player2.name + " is now at "
                    + workFlow.player2.position.x + ", " + workFlow.player2.position.y);
        }
    }

    private static void logRoll(WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " got " + workFlow.roll);
        }else{
            System.out.println(workFlow.player2.name + " got " + workFlow.roll);
        }
    }

    public static WorkFlow intializeWorkFlow(String name1, String name2) {
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        return new WorkFlow(player1, player2);
    }

    public static void makeSnakes(Box[][] board) {
        board[3][5].snakeHead = true;
        board[3][5].snakeTail = new Box(0, 6);

        board[5][7].snakeHead = true;
        board[5][7].snakeTail = new Box(2, 9);

        board[8][3].snakeHead = true;
        board[8][3].snakeTail = new Box(1, 1);

        board[9][8].snakeHead = true;
        board[9][8].snakeTail = new Box(3, 7);

        board[5][1].snakeHead = true;
        board[5][1].snakeTail = new Box(2, 0);
    }

    public static void makeLadders(Box[][] board) {
        board[0][7].ladderTail = true;
        board[0][7].ladderHead = new Box(3,4);

        board[2][2].ladderTail = true;
        board[2][2].ladderHead = new Box(4,3);

        board[4][8].ladderTail = true;
        board[4][8].ladderHead = new Box(7,4);

        board[6][6].ladderTail = true;
        board[6][6].ladderHead = new Box(8,1);

        board[7][3].ladderTail = true;
        board[7][3].ladderHead = new Box(9,2);
    }

    public static Box calculateNewPosition(WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            return new Box(workFlow.player1.position, workFlow.roll);
        }
        return new Box(workFlow.player2.position, workFlow.roll);
    }

    public static void checkSnake(final Box[][] board, WorkFlow workFlow) {
        if(!board[workFlow.newPosition.x][workFlow.newPosition.y].snakeHead){
            System.out.println("No snake found");
            return;
        }
        log(Constants.SNAKE, workFlow);
        workFlow.newPosition = board[workFlow.newPosition.x][workFlow.newPosition.y].snakeTail;
        log(Constants.SNAKE_MOVE, workFlow);
    }

    public static void checkLadder(final Box[][] board, WorkFlow workFlow) {
        if(!board[workFlow.newPosition.x][workFlow.newPosition.y].ladderTail){
            System.out.println("No Ladder found");
            return;
        }
        log(Constants.LADDER, workFlow);
        workFlow.newPosition = board[workFlow.newPosition.x][workFlow.newPosition.y].ladderHead;
        log(Constants.LADDER_MOVE, workFlow);
    }

    public static void makeBoard(Box[][] board) {
        for (int i = 0; i < 10; i++) {
            for(int j=0; j < 10; j++){
                board[i][j] = new Box(i, j);
            }
        }
    }

    public static void changeTurn(WorkFlow workFlow) {
        workFlow.turnFirstPlayer = !workFlow.turnFirstPlayer;
    }

    public static boolean isOverShooting(WorkFlow workFlow) {
        if(workFlow.newPosition.x<=9 )return false;
        log(Constants.INVALID_MOVE, workFlow);
        return true;
    }

    public static boolean initialCheck(final WorkFlow workFlow) {
        if(workFlow.turnFirstPlayer){
            if(workFlow.player1.position.x == 0 && workFlow.player1.position.y == 0){
                return true;
            }
        }else{
            if(workFlow.player2.position.x == 0 && workFlow.player2.position.y == 0){
                return true;
            }
        }
        return false;
    }
}
