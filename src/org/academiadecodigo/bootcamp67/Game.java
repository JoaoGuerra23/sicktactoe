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
}

