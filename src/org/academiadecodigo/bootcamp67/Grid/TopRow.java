package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.bootcamp67.Piece;
import org.academiadecodigo.bootcamp67.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Arrays;
import java.util.Objects;

public class TopRow implements Grid {

    private Rectangle topRow;
    private Rectangle[][] cells = new Rectangle[1][6];

    private Picture[][] rowImages = new Picture[1][6];
    private Picture[][] rowPiece = new Picture[1][6];

    private final int WIDTH = 60;
    private final int HEIGHT = 10;
    private final double LEFT_LIMIT_DIST = 20;
    private final double UPPER_LIMIT_DIST = 3.5;
    private int rows;
    private int cols;
    private Piece piece;
    private Position pos;

    public TopRow() {
        this.topRow = new Rectangle(PADDING + (LEFT_LIMIT_DIST * CELL_SIZE), PADDING + (UPPER_LIMIT_DIST * CELL_SIZE), WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
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
                rowImages[row][col] = new Picture(rowToY(20) + (10 * CELL_SIZE * col), columnToX(3.5),"tile1.png");
                rowImages[row][col].draw();
            }
        }
    }

    /*public void deleteImage(int cellCol) {
        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < 6; col++) {
                if (col == 1) {
                    System.out.println(getRowPiece()[0][0]);
                    getRowPiece()[0][0].delete();
                    System.out.println(getRowPiece()[0][0]);
                }
            }
        }
    }*/

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

    public Picture[][] getRowPiece() {
        return rowPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopRow)) return false;
        TopRow topRow1 = (TopRow) o;
        return WIDTH == topRow1.WIDTH && HEIGHT == topRow1.HEIGHT && Double.compare(topRow1.LEFT_LIMIT_DIST, LEFT_LIMIT_DIST) == 0 && Double.compare(topRow1.UPPER_LIMIT_DIST, UPPER_LIMIT_DIST) == 0 && rows == topRow1.rows && cols == topRow1.cols && Objects.equals(topRow, topRow1.topRow) && Arrays.equals(cells, topRow1.cells) && Arrays.equals(rowImages, topRow1.rowImages) && Arrays.equals(rowPiece, topRow1.rowPiece) && piece == topRow1.piece && Objects.equals(pos, topRow1.pos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(topRow, WIDTH, HEIGHT, LEFT_LIMIT_DIST, UPPER_LIMIT_DIST, rows, cols, piece, pos);
        result = 31 * result + Arrays.hashCode(cells);
        result = 31 * result + Arrays.hashCode(rowImages);
        result = 31 * result + Arrays.hashCode(rowPiece);
        return result;
    }
}
