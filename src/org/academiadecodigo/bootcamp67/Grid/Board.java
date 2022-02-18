package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Board implements Grid {

    private final Rectangle[][] cells = new Rectangle[3][3];

    private final Picture[][] boardImages = new Picture[3][3];

    public Board() {
        int WIDTH = 45;
        int HEIGHT = 45;
        double LEFT_LIMIT_DIST = 27.5;
        double UPPER_LIMIT_DIST = 17.5;
        Rectangle board = new Rectangle(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        Picture tile = new Picture(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), "TileBigPop.png");
        board.draw();
        tile.draw();
        createCells();
    }

    public void createCells() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = new Rectangle((rowToY(28) + (35 * (col + 1)) + (10 * CELL_SIZE * col)), (columnToX(18) + (35 * (row+ 1)) + (10 * CELL_SIZE * row)), 10 * CELL_SIZE, 10 * CELL_SIZE);
                cells[row][col].setColor(Color.LIGHT_GRAY);
                cells[row][col].draw();
                boardImages[row][col] = new Picture((rowToY(28) + (35 * (col + 1)) + (10 * CELL_SIZE * col)), (columnToX(18) + (35 * (row + 1)) + (10 * CELL_SIZE * row)), "TilePop.png");
                boardImages[row][col].draw();
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
        return (y / CELL_SIZE) + PADDING;
    }

    public double xToCol(double x) {
        return (x / CELL_SIZE) + PADDING;
    }
}
