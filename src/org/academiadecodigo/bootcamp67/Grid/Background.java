package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background implements Grid {

    public Background() {
        int WIDTH = 100;
        int HEIGHT = 80;
        Rectangle background = new Rectangle(PADDING, PADDING, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        background.draw();
        Picture backgroundPic = new Picture(PADDING, PADDING, "Background1.png");
        backgroundPic.draw();
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

}
