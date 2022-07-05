package com.board.oops;

import java.util.Random;


public class Util {
    public static int diceRoll(WorkFlow workFlow){
        int num = Math.abs(new Random().nextInt())%6+1;
        workFlow.roll = num;
        return num;
    }

    public static void log(final String event, WorkFlow workFlow) {
        if(event.equals(Constants.ROLL)){ //tells what was the roll
            logRoll(workFlow);
        }
        if(event.equals(Constants.BEFORE_MOVE)){ // what was the position before the roll
            logBeforeMove(workFlow);
        }
        // inserted this code for the logAfterMoveMethod which was already written but not called.
        if(event.equals(Constants.AFTER_MOVE)){ //tells what was the roll
            logAfterMove(workFlow);
        }
        if(event.equals(Constants.SHOULD_GO)){ //// what will be  the position after the roll
            logShouldGo(workFlow);
        }
        if(event.equals(Constants.SNAKE)){ // player is bit by snake
            logSnake(workFlow);
        }
        if(event.equals(Constants.SNAKE_MOVE)){ //new position after player is bitten
            logSnakeMove(workFlow);
        }
        if(event.equals(Constants.LADDER)){ // player got the ladder
            logLadder(workFlow);
        }
        if(event.equals(Constants.LADDER_MOVE)){ //new position after getting the ladder
            logLadderMove(workFlow);
        }
        if(event.equals(Constants.WIN)){ // whoever wins is shown
            logWin(workFlow);
        }
        if(event.equals(Constants.INVALID_MOVE)){ // if the input move is invalid
            logInvalidMove(workFlow);
        }
        // event for if the current player has the same position as the earlier player
        if(event.equals(Constants.STABBED)){ // if the input move is invalid
            logStabbed(workFlow);
        }
        // event if a player is stabbed
        if(event.equals(Constants.RESTART_AGAIN)){
            logRestartAgain(workFlow);
        }
        if(event.equals(Constants.GOT_SIX_THRICE)){
            logThreeSixes(workFlow);
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

    private static void logStabbed(WorkFlow workFlow){
        if(workFlow.turnFirstPlayer){
            System.out.println(workFlow.player1.name + " stabbed " + workFlow.player2.name);
        }else{
            System.out.println(workFlow.player2.name + " stabbed " + workFlow.player1.name);
        }
    }

    private static void logRestartAgain(WorkFlow workFlow)
    {
        if(workFlow.turnFirstPlayer)
        {
            System.out.println(workFlow.player2.name + " needs to restart his journey from start!");
        }
        else
        {
            System.out.println(workFlow.player1.name + " needs to restart his journey from start!");
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
        log(Constants.SNAKE, workFlow);  // tell the user it is bitten by a snake
        workFlow.newPosition = board[workFlow.newPosition.x][workFlow.newPosition.y].snakeTail;
        log(Constants.SNAKE_MOVE, workFlow); // show what are his new position
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
// checks if your new position already has the other player

    public static void checkIfStabbed(WorkFlow workFlow) {
        // if the turn is of the first player
        if(workFlow.turnFirstPlayer)
        {
            if(workFlow.newPosition.x == workFlow.player2.position.x && workFlow.newPosition.y == workFlow.player2.position.y) {
                Util.log(Constants.STABBED, workFlow); // displays what just happens
                System.out.println(workFlow.player2.name + " now moves to the initial position");
                // player 2 now moves to 0
                workFlow.player2.position.x = 0;
                workFlow.player2.position.y = 0;
                Util.log(Constants.RESTART_AGAIN, workFlow);
                return;

            }
        }
        //if its the second players turn
        if(workFlow.newPosition.x == workFlow.player1.position.x && workFlow.newPosition.y == workFlow.player1.position.y) {
            Util.log(Constants.STABBED, workFlow); // displays what just happens
            System.out.println(workFlow.player1.name + "now moves to the initial position");
            // player 1 now moves  to 0
            workFlow.player1.position.x = 0;
            workFlow.player1.position.y = 0;
            Util.log(Constants.RESTART_AGAIN, workFlow);

        }
    }

    // checks if you have got three sixes in a row
    private static void logThreeSixes(WorkFlow workFlow){
        if(workFlow.turnFirstPlayer)
        {
            System.out.println(workFlow.player1.name + " got three sixes in a row and so his chance is gone!");
        }
        else
        {
            System.out.println(workFlow.player2.name + " got three sixes in a row and so his chance is gone!");
        }

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
// this is to check if the players are still at the initial position.
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
