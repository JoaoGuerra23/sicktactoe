package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Random;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class PrankGame implements KeyboardHandler {

    public static final int CELLSIZE = 200;

    private final Rectangle[][] matrix = new Rectangle[3][3];
    private final int cols = 3;
    private final int rows = 3;
    private Keyboard keyboard;
    private Game game;
    private boolean turn = new Random().nextBoolean();
    private boolean isFinished = false;
    private boolean used = false;

    public PrankGame () {
        this.keyboard = new Keyboard(this);
        gridMatrix();
    }

    public void init() {
        int[] keys = {KEY_1, KEY_2, KEY_3, KEY_4, KEY_5, KEY_6, KEY_7, KEY_8, KEY_9, KEY_L};
        for (int key : keys) {
            KeyboardEvent e = new KeyboardEvent();
            e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            e.setKey(key);
            keyboard.addEventListener(e);
        }
    }

    public void gridMatrix() {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[col][row] = new Rectangle(columnToX(col), rowToY(row), CELLSIZE, CELLSIZE);
                matrix[col][row].draw();
            }
        }
    }

    public void winningCondition() {
        if (matrix[0][0].getColor().equals(Color.RED) && matrix[1][0].getColor().equals(Color.RED) && matrix[2][0].getColor().equals(Color.RED)
                || matrix[0][1].getColor().equals(Color.RED) && matrix[1][1].getColor().equals(Color.RED) && matrix[2][1].getColor().equals(Color.RED)
                || matrix[0][2].getColor().equals(Color.RED) && matrix[1][2].getColor().equals(Color.RED) && matrix[2][2].getColor().equals(Color.RED)
                || matrix[0][0].getColor().equals(Color.RED) && matrix[0][1].getColor().equals(Color.RED) && matrix[0][2].getColor().equals(Color.RED)
                || matrix[1][0].getColor().equals(Color.RED) && matrix[1][1].getColor().equals(Color.RED) && matrix[1][2].getColor().equals(Color.RED)
                || matrix[2][0].getColor().equals(Color.RED) && matrix[2][1].getColor().equals(Color.RED) && matrix[2][2].getColor().equals(Color.RED)
                || matrix[0][0].getColor().equals(Color.RED) && matrix[1][1].getColor().equals(Color.RED) && matrix[2][2].getColor().equals(Color.RED)
                || matrix[0][2].getColor().equals(Color.RED) && matrix[1][1].getColor().equals(Color.RED) && matrix[2][0].getColor().equals(Color.RED)) {
            setFinished(true);
        }
        if (matrix[0][0].getColor().equals(Color.GREEN) && matrix[1][0].getColor().equals(Color.GREEN) && matrix[2][0].getColor().equals(Color.GREEN)
                || matrix[0][1].getColor().equals(Color.GREEN) && matrix[1][1].getColor().equals(Color.GREEN) && matrix[2][1].getColor().equals(Color.GREEN)
                || matrix[0][2].getColor().equals(Color.GREEN) && matrix[1][2].getColor().equals(Color.GREEN) && matrix[2][2].getColor().equals(Color.GREEN)
                || matrix[0][0].getColor().equals(Color.GREEN) && matrix[0][1].getColor().equals(Color.GREEN) && matrix[0][2].getColor().equals(Color.GREEN)
                || matrix[1][0].getColor().equals(Color.GREEN) && matrix[1][1].getColor().equals(Color.GREEN) && matrix[1][2].getColor().equals(Color.GREEN)
                || matrix[2][0].getColor().equals(Color.GREEN) && matrix[2][1].getColor().equals(Color.GREEN) && matrix[2][2].getColor().equals(Color.GREEN)
                || matrix[0][0].getColor().equals(Color.GREEN) && matrix[1][1].getColor().equals(Color.GREEN) && matrix[2][2].getColor().equals(Color.GREEN)
                || matrix[0][2].getColor().equals(Color.GREEN) && matrix[1][1].getColor().equals(Color.GREEN) && matrix[2][0].getColor().equals(Color.GREEN)) {
            setFinished(true);
        }
    }

    public int rowToY(int rows) {
        return rows * CELLSIZE;
    }

    public int columnToX(int cols) {
        return cols * CELLSIZE;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        switch (event.getKey()) {
            case KEY_1:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[0][0].setColor(Color.GREEN);
                    matrix[0][0].fill();
                }
                if (!turn) {
                    matrix[0][0].setColor(Color.RED);
                    matrix[0][0].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_2:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[1][0].setColor(Color.GREEN);
                    matrix[1][0].fill();
                }

                if (!turn) {
                    matrix[1][0].setColor(Color.RED);
                    matrix[1][0].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_3:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[2][0].setColor(Color.GREEN);
                    matrix[2][0].fill();
                }

                if (!turn) {
                    matrix[2][0].setColor(Color.RED);
                    matrix[2][0].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_4:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[0][1].setColor(Color.GREEN);
                    matrix[0][1].fill();
                }

                if (!turn) {
                    matrix[0][1].setColor(Color.RED);
                    matrix[0][1].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_5:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[1][1].setColor(Color.GREEN);
                    matrix[1][1].fill();
                }

                if (!turn) {
                    matrix[1][1].setColor(Color.RED);
                    matrix[1][1].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_6:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[2][1].setColor(Color.GREEN);
                    matrix[2][1].fill();
                }

                if (!turn) {
                    matrix[2][1].setColor(Color.RED);
                    matrix[2][1].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_7:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[0][2].setColor(Color.GREEN);
                    matrix[0][2].fill();
                }

                if (!turn) {
                    matrix[0][2].setColor(Color.RED);
                    matrix[0][2].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_8:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[1][2].setColor(Color.GREEN);
                    matrix[1][2].fill();
                }

                if (!turn) {
                    matrix[1][2].setColor(Color.RED);
                    matrix[1][2].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_9:
                if (isFinished || used) {
                    break;
                }
                if (turn) {
                    matrix[2][2].setColor(Color.GREEN);
                    matrix[2][2].fill();
                }

                if (!turn) {
                    matrix[2][2].setColor(Color.RED);
                    matrix[2][2].fill();
                }
                toggleTurn();
                winningCondition();
                break;
            case KEY_L:
                if (used) {
                    break;
                }
                for (Rectangle[] rectangles : matrix) {
                    for (Rectangle rectangle : rectangles) {
                        rectangle.delete();
                        rectangle = null;
                    }
                }
                setUsed(true);
                this.keyboard = null;
                new Game().init();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void toggleTurn() {
        this.turn = !turn;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
