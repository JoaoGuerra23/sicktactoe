package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.bootcamp67.Grid.*;

public class Game {

    private Background background;
    private TopRow topRow;
    private BottomRow bottomRow;
    private Board board;

    private int player1Score;
    private int player2Score;

    public Game() {
        Controls mouse = new Controls(this);
        //this.background = new Background();
        //this.topRow = new TopRow();
        //this.bottomRow = new BottomRow();
        //this.board = new Board();
    }

    public void start() {
        /*validBoardCell();
        System.out.println("-----");
        validTopRowCell();
        System.out.println("-----");
        validBottomRowCell();*/
    }

    public void initializer() {
        //Controls mouse = new Controls(this);
        //start();
    }

    /*public void validBoardCell() {
        this.board = new Board();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < board.getCells().length; j++) {
                System.out.println(board.getCells()[0][0]);
                System.out.println(board.getCells()[0][1]);
                System.out.println(board.getCells()[0][2]);
                System.out.println(board.getCells()[1][0]);
                System.out.println(board.getCells()[1][1]);
                System.out.println(board.getCells()[1][2]);
                System.out.println(board.getCells()[2][0]);
                System.out.println(board.getCells()[2][1]);
                System.out.println(board.getCells()[2][2]);
            }
        }
    }

    public void validTopRowCell() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < topRow.getCells().length; j++) {
                System.out.println(topRow.getCells()[0][0]);
                System.out.println(topRow.getCells()[0][1]);
                System.out.println(topRow.getCells()[0][2]);
                System.out.println(topRow.getCells()[0][3]);
                System.out.println(topRow.getCells()[0][4]);
                System.out.println(topRow.getCells()[0][5]);
            }
        }
    }

    public void validBottomRowCell() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < bottomRow.getCells().length; j++) {
                System.out.println(bottomRow.getCells()[0][0]);
                System.out.println(bottomRow.getCells()[0][1]);
                System.out.println(bottomRow.getCells()[0][2]);
                System.out.println(bottomRow.getCells()[0][3]);
                System.out.println(bottomRow.getCells()[0][4]);
                System.out.println(bottomRow.getCells()[0][5]);
            }
        }
    }*/

    //WIN CONDITIONS

    /*public boolean isWinner(){
        //TOP ROW
        if((board.getRows() == 0 && board.getCols() == 0) && (board.getRows() == 0 && board.getCols() == 1) && (board.getRows() == 0 && board.getCols() == 2))
            return true;
        //MID ROW
        if((board.getRows() == 1 && board.getCols() == 0) && (board.getRows() == 1 && board.getCols() == 1) && (board.getRows() == 1 && board.getCols() == 2))
            return true;
        //BOT ROW
        if((board.getRows() == 2 && board.getCols() == 0) && (board.getRows() == 2 && board.getCols() == 1) && (board.getRows() == 2 && board.getCols() == 2))
            return true;

        //RIGHT COL
        if((board.getRows() == 0 && board.getCols() == 2) && (board.getRows() == 1 && board.getCols() == 2) && (board.getRows() == 2 && board.getCols() == 2))
            return true;
        //MID COL
        if((board.getRows() == 0 && board.getCols() == 1) && (board.getRows() == 1 && board.getCols() == 1) && (board.getRows() == 2 && board.getCols() == 1))
            return true;
        //LEFT COL
        if((board.getRows() == 0 && board.getCols() == 0) && (board.getRows() == 1 && board.getCols() == 0) && (board.getRows() == 2 && board.getCols() == 0))
            return true;

        //LEFT DIAGONAL
        if((board.getRows() == 0 && board.getCols() == 0) && (board.getRows() == 1 && board.getCols() == 1) && (board.getRows() == 2 && board.getCols() == 2))
            return true;

        //RIGHT DIAGONAL
        if((board.getRows() == 0 && board.getCols() == 2) && (board.getRows() == 1 && board.getCols() == 1) && (board.getRows() == 2 && board.getCols() == 0))
            return true;

        return false;
    }*/

   /* public Object getGrid() {
        return board;
    }*/
}

