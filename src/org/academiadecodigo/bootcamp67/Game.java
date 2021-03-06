package org.academiadecodigo.bootcamp67;

import jdk.swing.interop.SwingInterOpUtils;
import org.academiadecodigo.bootcamp67.Grid.*;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Random;
import java.util.random.RandomGenerator;

import static org.academiadecodigo.bootcamp67.Grid.Grid.PADDING;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Game implements MouseHandler, KeyboardHandler {

    private final Background background;
    private final Board board;
    private final TopRow topRow;
    private final BottomRow bottomRow;
    private int clickCounterX = 0;
    private int clickCounterO = 0;
    private int turnCounter = 0;
    private boolean Xwins = false;
    private boolean Owins = false;
    private boolean turn = new Random().nextBoolean();
    private boolean playerOturn = turn;
    private boolean playerXturn = !turn;
    private boolean gameStarted = false;
    private boolean gameWon = false;
    private boolean gameTied = false;
    private Picture currentPicture;
    private Picture playerCharTurn;
    private Picture playerBulbTurn;
    private Sound sound;
    private Menu menu;
    private Keyboard keyboard;
    private String prefix = "resources/";
    private String row1col1BoardCellType = "";
    private String row1col2BoardCellType = "";
    private String row1col3BoardCellType = "";
    private String row2col1BoardCellType = "";
    private String row2col2BoardCellType = "";
    private String row2col3BoardCellType = "";
    private String row3col1BoardCellType = "";
    private String row3col2BoardCellType = "";
    private String row3col3BoardCellType = "";

    private int row1col1BoardCellNum = 0;
    private int row1col2BoardCellNum = 0;
    private int row1col3BoardCellNum = 0;
    private int row2col1BoardCellNum = 0;
    private int row2col2BoardCellNum = 0;
    private int row2col3BoardCellNum = 0;
    private int row3col1BoardCellNum = 0;
    private int row3col2BoardCellNum = 0;
    private int row3col3BoardCellNum = 0;

    public Game() {
        this.sound = new Sound();
        this.keyboard = new Keyboard(this);
        this.background = new Background();
        this.topRow = new TopRow();
        this.board = new Board();
        this.bottomRow = new BottomRow();
        this.menu = new Menu();
        this.playerCharTurn = new Picture(60, 330, "charmanders.png");
        this.playerBulbTurn = new Picture(60, 196, "bulbasaurs.png");
    }

    public void init() {
        int keys[] = {KEY_SPACE, KEY_R, KEY_S, KEY_Q};

        for (int key = 0; key < keys.length; key++) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(keys[key]);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }

        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

        try {
            sound.startMenuMusic();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void switchTurn() {
        if (playerOturn) {
            playerBulbTurn.delete();
            playerCharTurn.draw();
        }
        if (playerXturn) {
            playerCharTurn.delete();
            playerBulbTurn.draw();
        }
    }

    public void resetGame() {
        new Game();
        new Background();
        new Board();
        new TopRow();
        new BottomRow();
        Piece.X_ONE.setPicture(new Picture(210, 675, Piece.X_ONE.getImageFile()));
        Piece.X_ONE.getPicture().draw();
        Piece.X_TWO.setPicture(new Picture(310, 675, Piece.X_TWO.getImageFile()));
        Piece.X_TWO.getPicture().draw();
        Piece.X_THREE.setPicture(new Picture(410, 675, Piece.X_THREE.getImageFile()));
        Piece.X_THREE.getPicture().draw();
        Piece.X_FOUR.setPicture(new Picture(510, 675, Piece.X_FOUR.getImageFile()));
        Piece.X_FOUR.getPicture().draw();
        Piece.X_FIVE.setPicture(new Picture(610, 675, Piece.X_FIVE.getImageFile()));
        Piece.X_FIVE.getPicture().draw();
        Piece.X_SIX.setPicture(new Picture(710, 675, Piece.X_SIX.getImageFile()));
        Piece.X_SIX.getPicture().draw();

        Piece.O_ONE.setPicture(new Picture(210, 45, Piece.O_ONE.getImageFile()));
        Piece.O_ONE.getPicture().draw();
        Piece.O_TWO.setPicture(new Picture(310, 45, Piece.O_TWO.getImageFile()));
        Piece.O_TWO.getPicture().draw();
        Piece.O_THREE.setPicture(new Picture(410, 45, Piece.O_THREE.getImageFile()));
        Piece.O_THREE.getPicture().draw();
        Piece.O_FOUR.setPicture(new Picture(510, 45, Piece.O_FOUR.getImageFile()));
        Piece.O_FOUR.getPicture().draw();
        Piece.O_FIVE.setPicture(new Picture(610, 45, Piece.O_FIVE.getImageFile()));
        Piece.O_FIVE.getPicture().draw();
        Piece.O_SIX.setPicture(new Picture(710, 45, Piece.O_SIX.getImageFile()));
        Piece.O_SIX.getPicture().draw();

        Xwins = false;
        Owins = false;
        currentPicture = null;
        turn = new Random().nextBoolean();
        playerOturn = turn;
        playerXturn = !turn;
        System.out.println(playerOturn + "  O");
        System.out.println(playerXturn + "  X");
        if (playerOturn) {
            playerBulbTurn = new Picture(60, 196, "bulbasaurs.png");
            playerBulbTurn.draw();
        }
        if (playerXturn) {
            playerCharTurn = new Picture(60, 330, "charmanders.png");
            playerCharTurn.draw();
        }
        clickCounterO = 0;
        clickCounterX = 0;
        turnCounter = 0;

        row1col1BoardCellType = "";
        row1col2BoardCellType = "";
        row1col3BoardCellType = "";
        row2col1BoardCellType = "";
        row2col2BoardCellType = "";
        row2col3BoardCellType = "";
        row3col1BoardCellType = "";
        row3col2BoardCellType = "";
        row3col3BoardCellType = "";

        row1col1BoardCellNum = 0;
        row1col2BoardCellNum = 0;
        row1col3BoardCellNum = 0;
        row2col1BoardCellNum = 0;
        row2col2BoardCellNum = 0;
        row2col3BoardCellNum = 0;
        row3col1BoardCellNum = 0;
        row3col2BoardCellNum = 0;
        row3col3BoardCellNum = 0;

        bottomRow.getRowPiece()[0][0] = Piece.X_ONE.getPicture();
        bottomRow.getRowPiece()[0][0].draw();
        bottomRow.getRowPiece()[0][1] = Piece.X_TWO.getPicture();
        bottomRow.getRowPiece()[0][1].draw();
        bottomRow.getRowPiece()[0][2] = Piece.X_THREE.getPicture();
        bottomRow.getRowPiece()[0][2].draw();
        bottomRow.getRowPiece()[0][3] = Piece.X_FOUR.getPicture();
        bottomRow.getRowPiece()[0][3].draw();
        bottomRow.getRowPiece()[0][4] = Piece.X_FIVE.getPicture();
        bottomRow.getRowPiece()[0][4].draw();
        bottomRow.getRowPiece()[0][5] = Piece.X_SIX.getPicture();
        bottomRow.getRowPiece()[0][5].draw();

        topRow.getRowPiece()[0][0] = Piece.O_ONE.getPicture();
        topRow.getRowPiece()[0][0].draw();
        topRow.getRowPiece()[0][1] = Piece.O_TWO.getPicture();
        topRow.getRowPiece()[0][1].draw();
        topRow.getRowPiece()[0][2] = Piece.O_THREE.getPicture();
        topRow.getRowPiece()[0][2].draw();
        topRow.getRowPiece()[0][3] = Piece.O_FOUR.getPicture();
        topRow.getRowPiece()[0][3].draw();
        topRow.getRowPiece()[0][4] = Piece.O_FIVE.getPicture();
        topRow.getRowPiece()[0][4].draw();
        topRow.getRowPiece()[0][5] = Piece.O_SIX.getPicture();
        topRow.getRowPiece()[0][5].draw();

        if(gameWon) {
            sound.stopWinMusic();
        }
        if (gameTied) {
            sound.stopTieMusic();
        }
        try {
            sound.startGameMusic();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_R:
                resetGame();
                break;

            case KeyboardEvent.KEY_SPACE:
                sound.stopMenuMusic();
                try {
                    sound.startGameMusic();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                menu.deleteMenu();
                gameStarted = true;
                if (playerOturn) {
                    playerBulbTurn.draw();
                }
                if (playerXturn) {
                    playerCharTurn.draw();
                }
                break;

            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;

            case KEY_S:
                if (!gameStarted) {
                    sound.startStopMenuMusic();
                } else {
                    sound.startStopGameMusic();
                }
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (Xwins || Owins) {
            return;
        }
        if (turnCounter == 12) {
            return;
        }

        if (turnCounter == 0) {
            playerOturn = turn;
            playerXturn = !turn;
        }

        System.out.println(turnCounter);

        Picture O1TopCell = topRow.getRowPiece()[0][0];
        Picture O2TopCell = topRow.getRowPiece()[0][1];
        Picture O3TopCell = topRow.getRowPiece()[0][2];
        Picture O4TopCell = topRow.getRowPiece()[0][3];
        Picture O5TopCell = topRow.getRowPiece()[0][4];
        Picture O6TopCell = topRow.getRowPiece()[0][5];

        Picture X1BotCell = bottomRow.getRowPiece()[0][0];
        Picture X2BotCell = bottomRow.getRowPiece()[0][1];
        Picture X3BotCell = bottomRow.getRowPiece()[0][2];
        Picture X4BotCell = bottomRow.getRowPiece()[0][3];
        Picture X5BotCell = bottomRow.getRowPiece()[0][4];
        Picture X6BotCell = bottomRow.getRowPiece()[0][5];

        /** ----- TOP ROW CELLS ----- **/
        if (playerOturn) {
            if ((e.getX() >= 210 + PADDING && e.getX() <= 305 + PADDING) && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
                if (O1TopCell.equals(Piece.O_ONE.getPicture())) {
                    if (clickCounterO % 2 == 0) {
                        currentPicture = O1TopCell;
                        Picture coverUp = new Picture(O1TopCell.getX(), O1TopCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(O1TopCell.getX(), O1TopCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.O_ONE.setPicture(new Picture(210, 45, "Tile.png"));
                        clickCounterO++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 310 + PADDING && e.getX() <= 405 + PADDING) && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
                if (O2TopCell.equals(Piece.O_TWO.getPicture())) {
                    if (clickCounterO % 2 == 0) {
                        currentPicture = O2TopCell;
                        Picture coverUp = new Picture(O2TopCell.getX(), O2TopCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(O2TopCell.getX(), O2TopCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.O_TWO.setPicture(new Picture(310, 45, "Tile.png"));
                        clickCounterO++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 410 + PADDING && e.getX() <= 505 + PADDING) && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
                if (O3TopCell.equals(Piece.O_THREE.getPicture())) {
                    if (clickCounterO % 2 == 0) {
                        currentPicture = O3TopCell;
                        Picture coverUp = new Picture(O3TopCell.getX(), O3TopCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(O3TopCell.getX(), O3TopCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.O_THREE.setPicture(new Picture(410, 45, "Tile.png"));
                        clickCounterO++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 510 + PADDING && e.getX() <= 605 + PADDING) && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
                if (O4TopCell.equals(Piece.O_FOUR.getPicture())) {
                    if (clickCounterO % 2 == 0) {
                        currentPicture = O4TopCell;
                        Picture coverUp = new Picture(O4TopCell.getX(), O4TopCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(O4TopCell.getX(), O4TopCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.O_FOUR.setPicture(new Picture(510, 45, "Tile.png"));
                        clickCounterO++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 610 + PADDING && e.getX() <= 705 + PADDING) && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
                if (O5TopCell.equals(Piece.O_FIVE.getPicture())) {
                    if (clickCounterO % 2 == 0) {
                        currentPicture = O5TopCell;
                        Picture coverUp = new Picture(O5TopCell.getX(), O5TopCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(O5TopCell.getX(), O5TopCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.O_FIVE.setPicture(new Picture(610, 45, "Tile.png"));
                        clickCounterO++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 710 + PADDING && e.getX() <= 805 + PADDING) && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
                if (O6TopCell.equals(Piece.O_SIX.getPicture())) {
                    if (clickCounterO % 2 == 0) {
                        currentPicture = O6TopCell;
                        Picture coverUp = new Picture(O6TopCell.getX(), O6TopCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(O6TopCell.getX(), O6TopCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.O_SIX.setPicture(new Picture(710, 45, "Tile.png"));
                        clickCounterO++;
                        return;
                    }
                }
            }
        }

        /** ----- BOTTOM ROW CELLS ----- **/
        if (playerXturn) {
            if ((e.getX() >= 210 + PADDING && e.getX() <= 305 + PADDING) && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
                if (X1BotCell.equals(Piece.X_ONE.getPicture())) {
                    if (clickCounterX % 2 == 0) {
                        currentPicture = X1BotCell;
                        Picture coverUp = new Picture(X1BotCell.getX(), X1BotCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(X1BotCell.getX(), X1BotCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.X_ONE.setPicture(new Picture(210, 675, "Tile.png"));
                        clickCounterX++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 310 + PADDING && e.getX() <= 405 + PADDING) && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
                if (X2BotCell.equals(Piece.X_TWO.getPicture())) {
                    if (clickCounterX % 2 == 0) {
                        currentPicture = X2BotCell;
                        Picture coverUp = new Picture(X2BotCell.getX(), X2BotCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(X2BotCell.getX(), X2BotCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.X_TWO.setPicture(new Picture(310, 675, "Tile.png"));
                        clickCounterX++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 410 + PADDING && e.getX() <= 505 + PADDING) && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
                if (X3BotCell.equals(Piece.X_THREE.getPicture())) {
                    if (clickCounterX % 2 == 0) {
                        currentPicture = X3BotCell;
                        Picture coverUp = new Picture(X3BotCell.getX(), X3BotCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(X3BotCell.getX(), X3BotCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.X_THREE.setPicture(new Picture(410, 675, "Tile.png"));
                        clickCounterX++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 510 + PADDING && e.getX() <= 605 + PADDING) && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
                if (X4BotCell.equals(Piece.X_FOUR.getPicture())) {
                    if (clickCounterX % 2 == 0) {
                        currentPicture = X4BotCell;
                        Picture coverUp = new Picture(X4BotCell.getX(), X4BotCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(X4BotCell.getX(), X4BotCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.X_FOUR.setPicture(new Picture(510, 675, "Tile.png"));
                        clickCounterX++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 610 + PADDING && e.getX() <= 705 + PADDING) && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
                if (X5BotCell.equals(Piece.X_FIVE.getPicture())) {
                    if (clickCounterX % 2 == 0) {
                        currentPicture = X5BotCell;
                        Picture coverUp = new Picture(X5BotCell.getX(), X5BotCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(X5BotCell.getX(), X5BotCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.X_FIVE.setPicture(new Picture(610, 675, "Tile.png"));
                        clickCounterX++;
                        return;
                    }
                }
            }
            if ((e.getX() >= 710 + PADDING && e.getX() <= 805 + PADDING) && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
                if (X6BotCell.equals(Piece.X_SIX.getPicture())) {
                    if (clickCounterX % 2 == 0) {
                        currentPicture = X6BotCell;
                        Picture coverUp = new Picture(X6BotCell.getX(), X6BotCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Picture pokeball = new Picture(X6BotCell.getX(), X6BotCell.getY(), "Pokeball.png");
                        pokeball.draw();
                        Piece.X_SIX.setPicture(new Picture(710, 675, "Tile.png"));
                        clickCounterX++;
                        return;
                    }
                }
            }
        }

        /** ----- TOP 3 BOARD CELLS ----- **/
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 325 + PADDING && e.getX() <= 420 + PADDING) && (e.getY() >= 250 + PADDING && e.getY() <= 340 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(325, 225, Piece.X_ONE.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "X";
                        row1col1BoardCellNum = Piece.X_ONE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(325, 225, Piece.X_TWO.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "X";
                        row1col1BoardCellNum = Piece.X_TWO.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(325, 225, Piece.X_THREE.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "X";
                        row1col1BoardCellNum = Piece.X_THREE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(325, 225, Piece.X_FOUR.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "X";
                        row1col1BoardCellNum = Piece.X_FOUR.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(325, 225, Piece.X_FIVE.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "X";
                        row1col1BoardCellNum = Piece.X_FIVE.getValue();
                        clickCounterX++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        currentPicture = new Picture(325, 225, Piece.X_SIX.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "X";
                        row1col1BoardCellNum = Piece.X_SIX.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(325, 225, Piece.O_ONE.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "O";
                        row1col1BoardCellNum = Piece.O_ONE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(325, 225, Piece.O_TWO.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "O";
                        row1col1BoardCellNum = Piece.O_TWO.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(325, 225, Piece.O_THREE.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "O";
                        row1col1BoardCellNum = Piece.O_THREE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(325, 225, Piece.O_FOUR.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "O";
                        row1col1BoardCellNum = Piece.O_FOUR.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(325, 225, Piece.O_FIVE.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "O";
                        row1col1BoardCellNum = Piece.O_FIVE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(325, 225, Piece.O_SIX.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "O";
                        row1col1BoardCellNum = Piece.O_SIX.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 460 + PADDING && e.getX() <= 555 + PADDING) && (e.getY() >= 250 + PADDING && e.getY() <= 340 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(460, 225, Piece.X_ONE.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "X";
                        row1col2BoardCellNum = Piece.X_ONE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(460, 225, Piece.X_TWO.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "X";
                        row1col2BoardCellNum = Piece.X_TWO.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(460, 225, Piece.X_THREE.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "X";
                        row1col2BoardCellNum = Piece.X_THREE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(460, 225, Piece.X_FOUR.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "X";
                        row1col2BoardCellNum = Piece.X_FOUR.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(460, 225, Piece.X_FIVE.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "X";
                        row1col2BoardCellNum = Piece.X_FIVE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        System.out.println("clicou");
                        currentPicture = new Picture(460, 225, Piece.X_SIX.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "X";
                        row1col2BoardCellNum = Piece.X_SIX.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(460, 225, Piece.O_ONE.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "O";
                        row1col2BoardCellNum = Piece.O_ONE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(460, 225, Piece.O_TWO.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "O";
                        row1col2BoardCellNum = Piece.O_TWO.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(460, 225, Piece.O_THREE.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "O";
                        row1col2BoardCellNum = Piece.O_THREE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(460, 225, Piece.O_FOUR.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "O";
                        row1col2BoardCellNum = Piece.O_FOUR.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(460, 225, Piece.O_FIVE.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "O";
                        row1col2BoardCellNum = Piece.O_FIVE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row1col2BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(460, 225, Piece.O_SIX.getImageFile());
                        currentPicture.draw();
                        row1col2BoardCellType = "O";
                        row1col2BoardCellNum = Piece.O_SIX.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 595 + PADDING && e.getX() <= 690 + PADDING) && (e.getY() >= 250 + PADDING && e.getY() <= 340 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(595, 225, Piece.X_ONE.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "X";
                        row1col3BoardCellNum = Piece.X_ONE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(595, 225, Piece.X_TWO.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "X";
                        row1col3BoardCellNum = Piece.X_TWO.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(595, 225, Piece.X_THREE.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "X";
                        row1col3BoardCellNum = Piece.X_THREE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(595, 225, Piece.X_FOUR.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "X";
                        row1col3BoardCellNum = Piece.X_FOUR.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(595, 225, Piece.X_FIVE.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "X";
                        row1col3BoardCellNum = Piece.X_FIVE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        currentPicture = new Picture(595, 225, Piece.X_SIX.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "X";
                        row1col3BoardCellNum = Piece.X_SIX.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(595, 225, Piece.O_ONE.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "O";
                        row1col3BoardCellNum = Piece.O_ONE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(595, 225, Piece.O_TWO.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "O";
                        row1col3BoardCellNum = Piece.O_TWO.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(595, 225, Piece.O_THREE.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "O";
                        row1col3BoardCellNum = Piece.O_THREE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(595, 225, Piece.O_FOUR.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "O";
                        row1col3BoardCellNum = Piece.O_FOUR.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(595, 225, Piece.O_FIVE.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "O";
                        row1col3BoardCellNum = Piece.O_FIVE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row1col3BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(595, 225, Piece.O_SIX.getImageFile());
                        currentPicture.draw();
                        row1col3BoardCellType = "O";
                        row1col3BoardCellNum = Piece.O_SIX.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }

        /** ----- MIDDLE 3 BOARD CELLS ----- **/
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 325 + PADDING && e.getX() <= 420 + PADDING) && (e.getY() >= 385 + PADDING && e.getY() <= 475 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(325, 360, Piece.X_ONE.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "X";
                        row2col1BoardCellNum = Piece.X_ONE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(325, 360, Piece.X_TWO.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "X";
                        row2col1BoardCellNum = Piece.X_TWO.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(325, 360, Piece.X_THREE.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "X";
                        row2col1BoardCellNum = Piece.X_THREE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(325, 360, Piece.X_FOUR.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "X";
                        row2col1BoardCellNum = Piece.X_FOUR.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(325, 360, Piece.X_FIVE.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "X";
                        row2col1BoardCellNum = Piece.X_FIVE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        currentPicture = new Picture(325, 360, Piece.X_SIX.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "X";
                        row2col1BoardCellNum = Piece.X_SIX.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(325, 360, Piece.O_ONE.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "O";
                        row2col1BoardCellNum = Piece.O_ONE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(325, 360, Piece.O_TWO.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "O";
                        row2col1BoardCellNum = Piece.O_TWO.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(325, 360, Piece.O_THREE.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "O";
                        row2col1BoardCellNum = Piece.O_THREE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(325, 360, Piece.O_FOUR.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "O";
                        row2col1BoardCellNum = Piece.O_FOUR.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(325, 360, Piece.O_FIVE.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "O";
                        row2col1BoardCellNum = Piece.O_FIVE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row2col1BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(325, 360, Piece.O_SIX.getImageFile());
                        currentPicture.draw();
                        row2col1BoardCellType = "O";
                        row2col1BoardCellNum = Piece.O_SIX.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 460 + PADDING && e.getX() <= 555 + PADDING) && (e.getY() >= 385 + PADDING && e.getY() <= 475 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(460, 360, Piece.X_ONE.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "X";
                        row2col2BoardCellNum = Piece.X_ONE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(460, 360, Piece.X_TWO.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "X";
                        row2col2BoardCellNum = Piece.X_TWO.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(460, 360, Piece.X_THREE.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "X";
                        row2col2BoardCellNum = Piece.X_THREE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(460, 360, Piece.X_FOUR.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "X";
                        row2col2BoardCellNum = Piece.X_FOUR.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(460, 360, Piece.X_FIVE.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "X";
                        row2col2BoardCellNum = Piece.X_FIVE.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        System.out.println("clicou");
                        currentPicture = new Picture(460, 360, Piece.X_SIX.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "X";
                        row2col2BoardCellNum = Piece.X_SIX.getValue();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(460, 360, Piece.O_ONE.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "O";
                        row2col2BoardCellNum = Piece.O_ONE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(460, 360, Piece.O_TWO.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "O";
                        row2col2BoardCellNum = Piece.O_TWO.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(460, 360, Piece.O_THREE.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "O";
                        row2col2BoardCellNum = Piece.O_THREE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(460, 360, Piece.O_FOUR.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "O";
                        row2col2BoardCellNum = Piece.O_FOUR.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(460, 360, Piece.O_FIVE.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "O";
                        row2col2BoardCellNum = Piece.O_FIVE.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row2col2BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(460, 360, Piece.O_SIX.getImageFile());
                        currentPicture.draw();
                        row2col2BoardCellType = "O";
                        row2col2BoardCellNum = Piece.O_SIX.getValue();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 595 + PADDING && e.getX() <= 690 + PADDING) && (e.getY() >= 385 + PADDING && e.getY() <= 475 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(595, 360, Piece.X_ONE.getImageFile());
                        row2col3BoardCellNum = Piece.X_ONE.getValue();
                        row2col3BoardCellType = "X";
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(595, 360, Piece.X_TWO.getImageFile());
                        row2col3BoardCellNum = Piece.X_TWO.getValue();
                        row2col3BoardCellType = "X";
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(595, 360, Piece.X_THREE.getImageFile());
                        row2col3BoardCellNum = Piece.X_THREE.getValue();
                        row2col3BoardCellType = "X";
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(595, 360, Piece.X_FOUR.getImageFile());
                        row2col3BoardCellNum = Piece.X_FOUR.getValue();
                        row2col3BoardCellType = "X";
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(595, 360, Piece.X_FIVE.getImageFile());
                        row2col3BoardCellNum = Piece.X_FIVE.getValue();
                        row2col3BoardCellType = "X";
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        currentPicture = new Picture(595, 360, Piece.X_SIX.getImageFile());
                        row2col3BoardCellNum = Piece.X_SIX.getValue();
                        row2col3BoardCellType = "X";
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(595, 360, Piece.O_ONE.getImageFile());
                        row2col3BoardCellNum = Piece.O_ONE.getValue();
                        row2col3BoardCellType = "O";
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(595, 360, Piece.O_TWO.getImageFile());
                        row2col3BoardCellNum = Piece.O_TWO.getValue();
                        row2col3BoardCellType = "O";
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(595, 360, Piece.O_THREE.getImageFile());
                        row2col3BoardCellNum = Piece.O_THREE.getValue();
                        row2col3BoardCellType = "O";
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(595, 360, Piece.O_FOUR.getImageFile());
                        row2col3BoardCellNum = Piece.O_FOUR.getValue();
                        row2col3BoardCellType = "O";
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(595, 360, Piece.O_FIVE.getImageFile());
                        row2col3BoardCellNum = Piece.O_FIVE.getValue();
                        row2col3BoardCellType = "O";
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row2col3BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(595, 360, Piece.O_SIX.getImageFile());
                        row2col3BoardCellNum = Piece.O_SIX.getValue();
                        row2col3BoardCellType = "O";
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }

        /** ----- BOTTOM 3 BOARD CELLS ----- **/
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 325 + PADDING && e.getX() <= 420 + PADDING) && (e.getY() >= 520 + PADDING && e.getY() <= 610 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(325, 495, Piece.X_ONE.getImageFile());
                        row3col1BoardCellType = "X";
                        row3col1BoardCellNum = Piece.X_ONE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(325, 495, Piece.X_TWO.getImageFile());
                        row3col1BoardCellType = "X";
                        row3col1BoardCellNum = Piece.X_TWO.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(325, 495, Piece.X_THREE.getImageFile());
                        row3col1BoardCellType = "X";
                        row3col1BoardCellNum = Piece.X_THREE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(325, 495, Piece.X_FOUR.getImageFile());
                        row3col1BoardCellType = "X";
                        row3col1BoardCellNum = Piece.X_FOUR.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(325, 495, Piece.X_FIVE.getImageFile());
                        row3col1BoardCellType = "X";
                        row3col1BoardCellNum = Piece.X_FIVE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        currentPicture = new Picture(325, 495, Piece.X_SIX.getImageFile());
                        row3col1BoardCellType = "X";
                        row3col1BoardCellNum = Piece.X_SIX.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(325, 495, Piece.O_ONE.getImageFile());
                        row3col1BoardCellType = "O";
                        row3col1BoardCellNum = Piece.O_ONE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(325, 495, Piece.O_TWO.getImageFile());
                        row3col1BoardCellType = "O";
                        row3col1BoardCellNum = Piece.O_TWO.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(325, 495, Piece.O_THREE.getImageFile());
                        row3col1BoardCellType = "O";
                        row3col1BoardCellNum = Piece.O_THREE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(325, 495, Piece.O_FOUR.getImageFile());
                        row3col1BoardCellType = "O";
                        row3col1BoardCellNum = Piece.O_FOUR.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(325, 495, Piece.O_FIVE.getImageFile());
                        row3col1BoardCellType = "O";
                        row3col1BoardCellNum = Piece.O_FIVE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(325, 495, Piece.O_SIX.getImageFile());
                        row3col1BoardCellType = "O";
                        row3col1BoardCellNum = Piece.O_SIX.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 460 + PADDING && e.getX() <= 555 + PADDING) && (e.getY() >= 520 + PADDING && e.getY() <= 610 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(460, 495, Piece.X_ONE.getImageFile());
                        row3col2BoardCellType = "X";
                        row3col2BoardCellNum = Piece.X_ONE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(460, 495, Piece.X_TWO.getImageFile());
                        row3col2BoardCellType = "X";
                        row3col2BoardCellNum = Piece.X_TWO.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(460, 495, Piece.X_THREE.getImageFile());
                        row3col2BoardCellType = "X";
                        row3col2BoardCellNum = Piece.X_THREE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(460, 495, Piece.X_FOUR.getImageFile());
                        row3col2BoardCellType = "X";
                        row3col2BoardCellNum = Piece.X_FOUR.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(460, 495, Piece.X_FIVE.getImageFile());
                        row3col2BoardCellType = "X";
                        row3col2BoardCellNum = Piece.X_FIVE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        currentPicture = new Picture(460, 495, Piece.X_SIX.getImageFile());
                        row3col2BoardCellType = "X";
                        row3col2BoardCellNum = Piece.X_SIX.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(460, 495, Piece.O_ONE.getImageFile());
                        row3col2BoardCellType = "O";
                        row3col2BoardCellNum = Piece.O_ONE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(460, 495, Piece.O_TWO.getImageFile());
                        row3col2BoardCellType = "O";
                        row3col2BoardCellNum = Piece.O_TWO.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(460, 495, Piece.O_THREE.getImageFile());
                        row3col2BoardCellType = "O";
                        row3col2BoardCellNum = Piece.O_THREE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(460, 495, Piece.O_FOUR.getImageFile());
                        row3col2BoardCellType = "O";
                        row3col2BoardCellNum = Piece.O_FOUR.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(460, 495, Piece.O_FIVE.getImageFile());
                        row3col2BoardCellType = "O";
                        row3col2BoardCellNum = Piece.O_FIVE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row3col2BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(460, 495, Piece.O_SIX.getImageFile());
                        row3col2BoardCellType = "O";
                        row3col2BoardCellNum = Piece.O_SIX.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }
        if ((clickCounterX % 2 != 0) || (clickCounterO % 2 != 0)) {
            if ((e.getX() >= 595 + PADDING && e.getX() <= 690 + PADDING) && (e.getY() >= 520 + PADDING && e.getY() <= 610 + PADDING)) {

                /** ----- X PIECES ----- **/
                if (Piece.X_ONE.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(X1BotCell)) {
                        currentPicture = new Picture(595, 495, Piece.X_ONE.getImageFile());
                        row3col3BoardCellType = "X";
                        row3col3BoardCellNum = Piece.X_ONE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_TWO.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(X2BotCell)) {
                        currentPicture = new Picture(595, 495, Piece.X_TWO.getImageFile());
                        row3col3BoardCellType = "X";
                        row3col3BoardCellNum = Piece.X_TWO.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_THREE.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(X3BotCell)) {
                        currentPicture = new Picture(595, 495, Piece.X_THREE.getImageFile());
                        row3col3BoardCellType = "X";
                        row3col3BoardCellNum = Piece.X_THREE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FOUR.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(X4BotCell)) {
                        currentPicture = new Picture(595, 495, Piece.X_FOUR.getImageFile());
                        row3col3BoardCellType = "X";
                        row3col3BoardCellNum = Piece.X_FOUR.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_FIVE.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(595, 495, Piece.X_FIVE.getImageFile());
                        row3col3BoardCellType = "X";
                        row3col3BoardCellNum = Piece.X_FIVE.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.X_SIX.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(X6BotCell)) {
                        currentPicture = new Picture(595, 495, Piece.X_SIX.getImageFile());
                        row3col3BoardCellType = "X";
                        row3col3BoardCellNum = Piece.X_SIX.getValue();
                        currentPicture.draw();
                        clickCounterX++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }

                /** ----- O PIECES ----- **/
                if (Piece.O_ONE.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(O1TopCell)) {
                        currentPicture = new Picture(595, 495, Piece.O_ONE.getImageFile());
                        row3col3BoardCellType = "O";
                        row3col3BoardCellNum = Piece.O_ONE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_TWO.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(O2TopCell)) {
                        currentPicture = new Picture(595, 495, Piece.O_TWO.getImageFile());
                        row3col3BoardCellType = "O";
                        row3col3BoardCellNum = Piece.O_TWO.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_THREE.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(595, 495, Piece.O_THREE.getImageFile());
                        row3col3BoardCellType = "O";
                        row3col3BoardCellNum = Piece.O_THREE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FOUR.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(O4TopCell)) {
                        currentPicture = new Picture(595, 495, Piece.O_FOUR.getImageFile());
                        row3col3BoardCellType = "O";
                        row3col3BoardCellNum = Piece.O_FOUR.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_FIVE.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(O5TopCell)) {
                        currentPicture = new Picture(595, 495, Piece.O_FIVE.getImageFile());
                        row3col3BoardCellType = "O";
                        row3col3BoardCellNum = Piece.O_FIVE.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
                if (Piece.O_SIX.getValue() > row3col3BoardCellNum) {
                    if (currentPicture.equals(O6TopCell)) {
                        currentPicture = new Picture(595, 495, Piece.O_SIX.getImageFile());
                        row3col3BoardCellType = "O";
                        row3col3BoardCellNum = Piece.O_SIX.getValue();
                        currentPicture.draw();
                        clickCounterO++;
                        turnCounter++;
                        switchTurn();
                        toggleTurn();
                    }
                }
            }
        }

        /** TOP ROW **/
        if ((row1col1BoardCellType.equals("X") && row1col2BoardCellType.equals("X") && row1col3BoardCellType.equals("X")                // TOP ROW
                || (row2col1BoardCellType.equals("X") && row2col2BoardCellType.equals("X") && row2col3BoardCellType.equals("X"))        // MID ROW
                || (row3col1BoardCellType.equals("X") && row3col2BoardCellType.equals("X") && row3col3BoardCellType.equals("X"))        // BOT ROW
                || (row1col1BoardCellType.equals("X") && row2col1BoardCellType.equals("X") && row3col1BoardCellType.equals("X"))        // LEFT COL
                || (row1col2BoardCellType.equals("X") && row2col2BoardCellType.equals("X") && row3col2BoardCellType.equals("X"))        // MID COL
                || (row1col3BoardCellType.equals("X") && row2col3BoardCellType.equals("X") && row3col3BoardCellType.equals("X"))        // RIGHT COL
                || (row1col1BoardCellType.equals("X") && row2col2BoardCellType.equals("X") && row3col3BoardCellType.equals("X"))        // TOPLEFT DIAG
                || (row1col3BoardCellType.equals("X") && row2col2BoardCellType.equals("X") && row3col1BoardCellType.equals("X")))) {    // BOTLEFT DIAG
            Xwins = true;
            new Rectangle(PADDING + 215, PADDING + 2, 570, 797).fill();
            new Picture(PADDING + 218, PADDING + 6, "WinX.png").draw();
            System.out.println("Fire Type Wins!");
            try {
                gameWon = true;
                sound.stopGameMusic();
                sound.winGameMusic();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
            return;
        }
        if ((row1col1BoardCellType.equals("O") && row1col2BoardCellType.equals("O") && row1col3BoardCellType.equals("O")                // TOP ROW
                || (row2col1BoardCellType.equals("O") && row2col2BoardCellType.equals("O") && row2col3BoardCellType.equals("O"))        // MID ROW
                || (row3col1BoardCellType.equals("O") && row3col2BoardCellType.equals("O") && row3col3BoardCellType.equals("O"))        // BOT ROW
                || (row1col1BoardCellType.equals("O") && row2col1BoardCellType.equals("O") && row3col1BoardCellType.equals("O"))        // LEFT COL
                || (row1col2BoardCellType.equals("O") && row2col2BoardCellType.equals("O") && row3col2BoardCellType.equals("O"))        // MID COL
                || (row1col3BoardCellType.equals("O") && row2col3BoardCellType.equals("O") && row3col3BoardCellType.equals("O"))        // RIGHT COL
                || (row1col1BoardCellType.equals("O") && row2col2BoardCellType.equals("O") && row3col3BoardCellType.equals("O"))        // TOPLEFT DIAG
                || (row1col3BoardCellType.equals("O") && row2col2BoardCellType.equals("O") && row3col1BoardCellType.equals("O")))) {    // BOTLEFT DIAG
            Owins = true;
            new Rectangle(PADDING + 215, PADDING + 2, 570, 797).fill();
            new Picture(PADDING + 218, PADDING + 6, "WinO.png").draw();
            System.out.println("Leaf Type Wins!");
            try {
                gameWon = true;
                sound.stopGameMusic();
                sound.winGameMusic();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
            return;
        }

        if (turnCounter == 12) {
            O1TopCell.draw();
            O2TopCell.draw();
            O3TopCell.draw();
            O4TopCell.draw();
            O5TopCell.draw();
            O6TopCell.draw();

            X1BotCell.draw();
            X2BotCell.draw();
            X3BotCell.draw();
            X4BotCell.draw();
            X5BotCell.draw();
            X6BotCell.draw();
            new Rectangle(PADDING, PADDING, 1000, 1).fill();
            new Picture(PADDING, PADDING + 1, "Tie.png").draw();
            sound.stopGameMusic();
            try {
                gameTied = true;
                sound.tieGameMusic();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void toggleTurn() {
        playerOturn = !playerOturn;
        playerXturn = !playerOturn;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public String toString() {
        return "Game{" +
                "background=" + background +
                ", board=" + board +
                ", topRow=" + topRow +
                ", bottomRow=" + bottomRow +
                ", clickCounterX=" + clickCounterX +
                ", clickCounterO=" + clickCounterO +
                ", turnCounter=" + turnCounter +
                ", Xwins=" + Xwins +
                ", Owins=" + Owins +
                ", currentPicture=" + currentPicture +
                ", sound=" + sound +
                ", keyboard=" + keyboard +
                ", row1col1BoardCellType='" + row1col1BoardCellType + '\'' +
                ", row1col2BoardCellType='" + row1col2BoardCellType + '\'' +
                ", row1col3BoardCellType='" + row1col3BoardCellType + '\'' +
                ", row2col1BoardCellType='" + row2col1BoardCellType + '\'' +
                ", row2col2BoardCellType='" + row2col2BoardCellType + '\'' +
                ", row2col3BoardCellType='" + row2col3BoardCellType + '\'' +
                ", row3col1BoardCellType='" + row3col1BoardCellType + '\'' +
                ", row3col2BoardCellType='" + row3col2BoardCellType + '\'' +
                ", row3col3BoardCellType='" + row3col3BoardCellType + '\'' +
                ", row1col1BoardCellNum=" + row1col1BoardCellNum +
                ", row1col2BoardCellNum=" + row1col2BoardCellNum +
                ", row1col3BoardCellNum=" + row1col3BoardCellNum +
                ", row2col1BoardCellNum=" + row2col1BoardCellNum +
                ", row2col2BoardCellNum=" + row2col2BoardCellNum +
                ", row2col3BoardCellNum=" + row2col3BoardCellNum +
                ", row3col1BoardCellNum=" + row3col1BoardCellNum +
                ", row3col2BoardCellNum=" + row3col2BoardCellNum +
                ", row3col3BoardCellNum=" + row3col3BoardCellNum +
                '}';
    }

}