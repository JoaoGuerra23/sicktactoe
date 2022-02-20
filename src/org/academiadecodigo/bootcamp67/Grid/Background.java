package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background implements Grid {

    public Background() {
        Picture backgroundPic = new Picture(PADDING, PADDING,"Background.png");
        backgroundPic.draw();
        Picture soundButton = new Picture(870, 50, "soundbuttonsmall.png");
        soundButton.draw();
        Picture quitButton = new Picture(870,150,"quitbuttonsmall.png");
        quitButton.draw();
        Picture resetButton = new Picture(870, 100,"resetbutton.png");
        resetButton.draw();
        Picture turn = new Picture(80, 250,"turnbuttonblue.png");
        turn.draw();
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
