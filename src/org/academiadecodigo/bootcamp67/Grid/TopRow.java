package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.bootcamp67.Piece;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class TopRow implements Grid {

    private final Rectangle[][] cells = new Rectangle[1][6];
    private final Picture[][] rowImages = new Picture[1][6];
    private final Picture[][] rowPiece = new Picture[1][6];

    public TopRow() {
        int WIDTH = 60;
        int HEIGHT = 10;
        double LEFT_LIMIT_DIST = 20;
        double UPPER_LIMIT_DIST = 3.5;
        Rectangle topRow = new Rectangle(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        topRow.draw();
        createCells();
        getRowPiece()[0][0] = Piece.O_ONE.getPicture();
        getRowPiece()[0][0].draw();
        getRowPiece()[0][1] = Piece.O_TWO.getPicture();
        getRowPiece()[0][1].draw();
        getRowPiece()[0][2] = Piece.O_THREE.getPicture();
        getRowPiece()[0][2].draw();
        getRowPiece()[0][3] = Piece.O_FOUR.getPicture();
        getRowPiece()[0][3].draw();
        getRowPiece()[0][4] = Piece.O_FIVE.getPicture();
        getRowPiece()[0][4].draw();
        getRowPiece()[0][5] = Piece.O_SIX.getPicture();
        getRowPiece()[0][5].draw();
    }

    public void createCells() {
        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < 6; col++) {
                cells[row][col] = new Rectangle(rowToY(20) + (10 * CELL_SIZE * col), columnToX(3.5), 10 * CELL_SIZE, 10 * CELL_SIZE);
                cells[row][col].setColor(Color.LIGHT_GRAY);
                cells[row][col].draw();
                rowImages[row][col] = new Picture(rowToY(20) + (10 * CELL_SIZE * col), columnToX(3.5),"Tile.png");
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

    public Picture[][] getRowPiece() {
        return rowPiece;
    }
}