package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import static org.academiadecodigo.bootcamp67.Grid.Grid.PADDING;

public class PrankGame implements MouseHandler {

    public static final int CELLSIZE = 200;
    public static final int PADDING = 10;

    private Rectangle[][] matrix = new Rectangle[3][3];
    private int cols = 3;
    private int rows = 3;

    public PrankGame () {
    }

    public void initializer() {
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        gridMatrix();
    }

    public void gridMatrix() {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[col][row] = new Rectangle(columnToX(col) + PADDING, rowToY(row) + PADDING, CELLSIZE, CELLSIZE);
                matrix[col][row].draw();
            }
        }
    }

    public int rowToY(int rows) {
        return rows * CELLSIZE;
    }

    public int columnToX(int cols) {
        return cols * CELLSIZE;
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getX() >= 0 && e.getX() <= 200) && (e.getY() >= 0 && e.getY() <= 200)) {
        }
        if ((e.getX() >= 200 && e.getX() <= 400) && (e.getY() >= 0 && e.getY() <= 200)) {
        }
        if ((e.getX() >= 400 && e.getX() <= 600) && (e.getY() >= 0 && e.getY() <= 200)) {
        }
        if ((e.getX() >= 0 && e.getX() <= 200) && (e.getY() >= 200 && e.getY() <= 400)) {
        }
        if ((e.getX() >= 200 && e.getX() <= 400) && (e.getY() >= 200 && e.getY() <= 400)) {
        }
        if ((e.getX() >= 400 && e.getX() <= 600) && (e.getY() >= 200 && e.getY() <= 400)) {
        }
        if ((e.getX() >= 0 && e.getX() <= 200) && (e.getY() >= 400 && e.getY() <= 600)) {
        }
        if ((e.getX() >= 200 && e.getX() <= 400) && (e.getY() >= 400 && e.getY() <= 600)) {
        }
        if ((e.getX() >= 400 && e.getX() <= 600) && (e.getY() >= 400 && e.getY() <= 600)) {
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
