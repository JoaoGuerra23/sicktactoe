package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.bootcamp67.Game;
import org.academiadecodigo.bootcamp67.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp67.Grid.Grid.CELL_SIZE;
import static org.academiadecodigo.bootcamp67.Grid.Grid.PADDING;

public class Background implements Grid {

    private Rectangle background;
    private Picture image;
    private final int WIDTH = 100;
    private final int HEIGHT = 80;
    private int rows;
    private int cols;
    private Position pos;

    public Background() {
        this.background = new Rectangle(PADDING, PADDING, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        background.draw();
    }

    public double rowToY(double rows) {
        return rows * CELL_SIZE + PADDING;
    }

    public double columnToX(double cols) {
        return cols * CELL_SIZE + PADDING;
    }

    public double yToRow(double y) {
        return y / CELL_SIZE + PADDING;
    }

    public double xToCol(double x) {
        return x / CELL_SIZE + PADDING;
    }

    public double getY() {
        return this.rows * CELL_SIZE;
    }

    public double getX() {
        return this.cols * CELL_SIZE;
    }

    public double getCols() {
        return this.cols;
    }

    public double getRows() {
        return this.rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Position getPos() {
        return pos;
    }
}
