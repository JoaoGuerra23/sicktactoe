package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.bootcamp67.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements Grid {

    private final int WIDTH = 100;
    private final int HEIGHT = 80;
    private Rectangle frame;
    private Picture background;
    private Picture startButton;
    private Picture quitButton;
    private Picture titleImage;
    private Picture soundOnOff;
    private Picture edition;

    public Menu() {
        frame = new Rectangle(PADDING, PADDING, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        frame.fill();
        frame.setColor(Color.BLACK);
        background = new Picture(PADDING, PADDING, "pokemon1000x800.png");
        background.draw();
        startButton = new Picture(100, 100, "startbutton.png");
        startButton.draw();
        quitButton = new Picture(100, 220, "quitbutton.png");
        quitButton.draw();
        soundOnOff = new Picture(100, 340, "soundonoff.png" );
        soundOnOff.draw();
        titleImage = new Picture(450, 30, "sicktactoe.png");
        titleImage.draw();
        edition = new Picture(650, 320, "edition.png");
        edition.draw();
    }

    public void deleteMenu() {
        background.delete();
        startButton.delete();
        quitButton.delete();
        titleImage.delete();
        soundOnOff.delete();
        edition.delete();
        frame.delete();
    }

    @Override
    public double rowToY(double rows) {
        return 0;
    }

    @Override
    public double columnToX(double cols) {
        return 0;
    }

    @Override
    public double yToRow(double y) {
        return 0;
    }

    @Override
    public double xToCol(double x) {
        return 0;
    }
}
