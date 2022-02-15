package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.bootcamp67.Grid.Board;
import org.academiadecodigo.bootcamp67.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import static org.academiadecodigo.bootcamp67.Grid.Grid.PADDING;

public class Controls implements MouseHandler, KeyboardHandler{

    private Game game;
    private Board board;
    private Mouse mouse;
    private MouseEvent click;
    private Keyboard keyboard;
    private boolean validCell = false;


    public Controls(Game game) {
        this.game = game;
        this.board = new Board();

        init();
    }


    public void init() {

        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        // ----- TOP ROW CELLS -----
        if (((e.getX() >= 210 + PADDING && e.getX() <= 305 + PADDING)
                || (e.getX() >= 310 + PADDING && e.getX() <= 405 + PADDING)
                || (e.getX() >= 410 + PADDING && e.getX() <= 505 + PADDING)
                || (e.getX() >= 510 + PADDING && e.getX() <= 605 + PADDING)
                || (e.getX() >= 610 + PADDING && e.getX() <= 705 + PADDING)
                || (e.getX() >= 710 + PADDING && e.getX() <= 805 + PADDING))
                && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
            System.out.println("clicou");
        }

        // ----- BOTTOM ROW CELLS -----
        if (((e.getX() >= 210 + PADDING && e.getX() <= 305 + PADDING)
                || (e.getX() >= 310 + PADDING && e.getX() <= 405 + PADDING)
                || (e.getX() >= 410 + PADDING && e.getX() <= 505 + PADDING)
                || (e.getX() >= 510 + PADDING && e.getX() <= 605 + PADDING)
                || (e.getX() >= 610 + PADDING && e.getX() <= 705 + PADDING)
                || (e.getX() >= 710 + PADDING && e.getX() <= 805 + PADDING))
                && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
            System.out.println("clicou");
        }

        // ----- TOP 3 BOARD CELLS -----
        if (((e.getX() >= 325 + PADDING && e.getX() <= 420 + PADDING)
                || (e.getX() >= 460 + PADDING && e.getX() <= 555 + PADDING)
                || (e.getX() >= 595 + PADDING && e.getX() <= 690 + PADDING))
                && (e.getY() >= 250 + PADDING && e.getY() <= 340 + PADDING)) {
            System.out.println("clicou");
        }

        // ----- MIDDLE 3 BOARD CELLS -----
        if (((e.getX() >= 325 + PADDING && e.getX() <= 420 + PADDING)
                || (e.getX() >= 460 + PADDING && e.getX() <= 555 + PADDING)
                || (e.getX() >= 595 + PADDING && e.getX() <= 690 + PADDING))
                && (e.getY() >= 385 + PADDING && e.getY() <= 475 + PADDING)) {
            System.out.println("clicou");
        }

        // ----- BOTTOM 3 BOARD CELLS -----
        if (((e.getX() >= 325 + PADDING && e.getX() <= 420 + PADDING)
                || (e.getX() >= 460 + PADDING && e.getX() <= 555 + PADDING)
                || (e.getX() >= 595 + PADDING && e.getX() <= 690 + PADDING))
                && (e.getY() >= 520 + PADDING && e.getY() <= 610 + PADDING)) {
            System.out.println("clicou");
        }

        Position pos = new Position(board.xToCol((e.getX())), board.yToRow(e.getY()));

        System.out.println(pos);
    }

    public boolean isValid() {
        return validCell;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public String toString() {
        return "Controls{" +
                "board=" + board +
                ", game=" + game +
                ", mouse=" + mouse +
                ", click=" + click +
                ", keyboard=" + keyboard +
                '}';
    }
}
