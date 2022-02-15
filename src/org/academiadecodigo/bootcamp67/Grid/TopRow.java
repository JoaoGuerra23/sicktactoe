package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.bootcamp67.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp67.Grid.Grid.CELL_SIZE;
import static org.academiadecodigo.bootcamp67.Grid.Grid.PADDING;

public class TopRow implements Grid {

    private Rectangle topRow;
    private Rectangle[][] cells = new Rectangle[1][6];

    private Picture[][] rowImages = new Picture[1][6];

    private final int WIDTH = 60;
    private final int HEIGHT = 10;
    private final double LEFT_LIMIT_DIST = 20;
    private final double UPPER_LIMIT_DIST = 3.5;
    private int rows;
    private int cols;
    private Position pos;

    public TopRow() {
        this.topRow = new Rectangle(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        topRow.draw();
        createCells();
    }

    public void createCells() {
        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < 6; col++) {
                cells[row][col] = new Rectangle(rowToY(20) + (10 * CELL_SIZE * col), columnToX(3.5), 10 * CELL_SIZE, 10 * CELL_SIZE);
                cells[row][col].setColor(Color.LIGHT_GRAY);
                cells[row][col].draw();
                rowImages[row][col] = new Picture(rowToY(20) + (10 * CELL_SIZE * col), columnToX(3.5),"tile1.png");
                rowImages[row][col].draw();
            }
        }
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

    public Rectangle[][] getCells() {
        return cells;
    }

}