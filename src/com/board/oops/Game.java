package com.board.oops;



public class Game {
    // box and board are different
    private WorkFlow workFlow;
    private Box[][] board = new Box[10][10];
    public boolean isOver = false;

    // adding a variable to flag whenever  a player gets a six
    private  int countSix = 0;
    public Game(){
        System.out.println("created game");
    }

    public Game(String name1, String name2){
        Util.makeBoard(board);
        Util.makeSnakes(board);
        Util.makeLadders(board);
        workFlow = Util.intializeWorkFlow(name1, name2);
    }

    public void proceed() {
        if(this.isOver){
            System.out.println("GAME IS OVER");
            return;
        }
        int roll = Util.diceRoll(workFlow);  // workflow is passed to change the value of its roll instance.
        // increased countSix if the player is outside initial check and rolls a six
        if(workFlow.roll == 6 && !Util.initialCheck(workFlow))
        countSix++;
        else
        {
            countSix = 0; // resets countSix to be used again.
        }

        Util.log(Constants.ROLL, this.workFlow); // shows what roll it is.
        // checks if player has not exceeded the maximum limit of rolling a dice which is 2.
        if(countSix != 3) {
            makeMove(workFlow);
        }
        else
        {
            Util.log(Constants.GOT_SIX_THRICE,workFlow); // tells the user that it has exceeded the limit.
        }

        if(workFlow.newPosition.x == 9 && workFlow.newPosition.y == 9){
            this.isOver  = true;
            Util.log(Constants.WIN, workFlow);
        }
        System.out.println();
        // checks if  the player got a six and if yes, gives it a second chance.
        if(countSix == 1 || countSix == 2) // not when you are at initial position as that case has been taken care of
        {
            Util.changeTurn(workFlow); // changing the turn twice gives the same player the chance again
        }
        Util.changeTurn(workFlow);
    }

    private void makeMove(WorkFlow workFlow) {
        Util.log(Constants.BEFORE_MOVE, this.workFlow);
        /*
        * This next if segment here checks if the position of the two players is (0,0). If it is, that means
        * they would need 6 to start the game.
        * */
        if(Util.initialCheck(workFlow)){
            if(workFlow.roll != 6)return;

        // second chance after you get a six and your piece is open.
            int roll = Util.diceRoll(workFlow);
            System.out.println("You got a 6, you're good to go!!!");
            Util.log(Constants.ROLL, this.workFlow);
        }
        Box newPosition = Util.calculateNewPosition(workFlow);
        workFlow.newPosition = newPosition;
        if(Util.isOverShooting(workFlow))return;
        Util.log(Constants.SHOULD_GO, workFlow);
        Util.checkSnake(board, workFlow);//changes the new position of workflow in both cases
        Util.checkLadder(board, workFlow);


        Util.checkIfStabbed(workFlow); // checks for if the a player has been stabbed.

        // after calculating the new position, now whoever turn it is, change its new position to that.
        if(workFlow.turnFirstPlayer)workFlow.player1.position = workFlow.newPosition;
        else workFlow.player2.position = workFlow.newPosition;
        Util.log(Constants.AFTER_MOVE, this.workFlow); //tells the player his new position
    }
}
