package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.bootcamp67.Piece;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BottomRow implements Grid {

    private final Rectangle[][] cells = new Rectangle[1][6];
    private final Picture[][] rowImages = new Picture[1][6];
    private final Picture[][] rowPiece = new Picture[1][6];

    public BottomRow() {
        int WIDTH = 60;
        int HEIGHT = 10;
        double LEFT_LIMIT_DIST = 20;
        double UPPER_LIMIT_DIST = 66.5;
        Rectangle bottomRow = new Rectangle(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        bottomRow.draw();
        createCells();
        getRowPiece()[0][0] = Piece.X_ONE.getPicture();
        getRowPiece()[0][0].draw();
        getRowPiece()[0][1] = Piece.X_TWO.getPicture();
        getRowPiece()[0][1].draw();
        getRowPiece()[0][2] = Piece.X_THREE.getPicture();
        getRowPiece()[0][2].draw();
        getRowPiece()[0][3] = Piece.X_FOUR.getPicture();
        getRowPiece()[0][3].draw();
        getRowPiece()[0][4] = Piece.X_FIVE.getPicture();
        getRowPiece()[0][4].draw();
        getRowPiece()[0][5] = Piece.X_SIX.getPicture();
        getRowPiece()[0][5].draw();
    }

    public void createCells() {
        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < 6; col++) {
                cells[row][col] = new Rectangle(rowToY(20) + (10 * CELL_SIZE * col), columnToX(66.5), 10 * CELL_SIZE, 10 * CELL_SIZE);
                cells[row][col].setColor(Color.LIGHT_GRAY);
                cells[row][col].draw();
                rowImages[row][col] = new Picture(rowToY(20) + (10 * CELL_SIZE * col), columnToX(66.5), "Tile.png");
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