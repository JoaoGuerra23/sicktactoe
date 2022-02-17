package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.bootcamp67.Piece;
import org.academiadecodigo.bootcamp67.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Arrays;

import static org.academiadecodigo.bootcamp67.Grid.Grid.CELL_SIZE;
import static org.academiadecodigo.bootcamp67.Grid.Grid.PADDING;

public class Board implements Grid {

    private Rectangle board;
    private Rectangle[][] cells = new Rectangle[3][3];

    private Picture tile;
    private Picture[][] boardImages = new Picture[3][3];
    private String[][] boardPiece = new String[3][3];

    private final int WIDTH = 45;
    private final int HEIGHT = 45;
    private final double LEFT_LIMIT_DIST = 27.5;
    private final double UPPER_LIMIT_DIST = 17.5;
    private int rows;
    private int cols;
    private Piece piece;
    private Position pos;

    public Board() {
        this.board = new Rectangle(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        this.tile = new Picture(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), "tile1bigger.png");
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
                boardImages[row][col] = new Picture((rowToY(28) + (35 * (col + 1)) + (10 * CELL_SIZE * col)), (columnToX(18) + (35 * (row + 1)) + (10 * CELL_SIZE * row)), "tile1.png");
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
        return this.pos;
    }

    public Rectangle[][] getCells() {
        return cells;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                ", cells=" + Arrays.toString(cells) +
                ", tile=" + tile +
                ", boardImages=" + Arrays.toString(boardImages) +
                ", WIDTH=" + WIDTH +
                ", HEIGHT=" + HEIGHT +
                ", LEFT_LIMIT_DIST=" + LEFT_LIMIT_DIST +
                ", UPPER_LIMIT_DIST=" + UPPER_LIMIT_DIST +
                ", rows=" + rows +
                ", cols=" + cols +
                ", pos=" + pos +
                '}';
    }

    public String[][] getBoardPiece() {
        return boardPiece;
    }
}
