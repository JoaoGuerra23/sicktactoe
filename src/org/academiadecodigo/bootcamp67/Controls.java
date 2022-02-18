package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.bootcamp67.Grid.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp67.Grid.Grid.PADDING;

public class Controls implements MouseHandler, KeyboardHandler {

    private final Game game;
    private final Board board;
    private final TopRow topRow;
    private final BottomRow bottomRow;
    private final Background background;
    private Picture currentPicture;
    private int clickCounterX = 0;
    private int clickCounterO = 0;
    private int turnCounter = 0;
    private boolean playerXturn = true;
    private boolean playerOturn = false;
    private boolean Xwins = false;
    private boolean Owins = false;

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

    public Controls(Game game) {
        this.game = game;
        this.background = new Background();
        this.topRow = new TopRow();
        this.board = new Board();
        this.bottomRow = new BottomRow();
        init();
    }


    public void init() {

        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (Xwins) {
            return;
        }
        if (Owins) {
            return;
        }
        if (turnCounter == 12) {
            return;
        }

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
        if (turnCounter % 2 != 0) {
            if ((e.getX() >= 210 + PADDING && e.getX() <= 305 + PADDING) && (e.getY() >= 65 + PADDING && e.getY() <= 165 + PADDING)) {
                if (O1TopCell.equals(Piece.O_ONE.getPicture())) {
                    if (clickCounterO % 2 == 0) {
                        currentPicture = O1TopCell;
                        Picture coverUp = new Picture(O1TopCell.getX(), O1TopCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Piece.O_ONE.setPicture(new Picture(230, 45, "Tile.png"));
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
                        Piece.O_TWO.setPicture(new Picture(330, 45, "Tile.png"));
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
                        Piece.O_THREE.setPicture(new Picture(430, 45, "Tile.png"));
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
                        Piece.O_FOUR.setPicture(new Picture(530, 45, "Tile.png"));
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
                        Piece.O_FIVE.setPicture(new Picture(630, 45, "Tile.png"));
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
                        Piece.O_SIX.setPicture(new Picture(730, 45, "Tile.png"));
                        clickCounterO++;
                        return;
                    }
                }
            }
        }

        /** ----- BOTTOM ROW CELLS ----- **/
        if (turnCounter % 2 == 0) {
            if ((e.getX() >= 210 + PADDING && e.getX() <= 305 + PADDING) && (e.getY() >= 695 + PADDING && e.getY() <= 795 + PADDING)) {
                if (X1BotCell.equals(Piece.X_ONE.getPicture())) {
                    if (clickCounterX % 2 == 0) {
                        currentPicture = X1BotCell;
                        Picture coverUp = new Picture(X1BotCell.getX(), X1BotCell.getY(), "TilePop.png");
                        coverUp.draw();
                        Piece.X_ONE.setPicture(new Picture(230, 675, "Tile.png"));
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
                        Piece.X_TWO.setPicture(new Picture(330, 675, "Tile.png"));
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
                        Piece.X_THREE.setPicture(new Picture(430, 675, "Tile.png"));
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
                        Piece.X_FOUR.setPicture(new Picture(530, 675, "Tile.png"));
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
                        Piece.X_FIVE.setPicture(new Picture(630, 675, "Tile.png"));
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
                        Piece.X_SIX.setPicture(new Picture(730, 675, "Tile.png"));
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
                    }
                }
                if (Piece.X_FIVE.getValue() > row1col1BoardCellNum) {
                    if (currentPicture.equals(X5BotCell)) {
                        currentPicture = new Picture(325, 225, Piece.X_FIVE.getImageFile());
                        currentPicture.draw();
                        row1col1BoardCellType = "X";
                        row1col1BoardCellNum = Piece.X_FIVE.getValue();
                        clickCounterX++;
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
                    }
                }
                if (Piece.O_THREE.getValue() > row3col1BoardCellNum) {
                    if (currentPicture.equals(O3TopCell)) {
                        currentPicture = new Picture(325, 495, Piece.O_THREE.getImageFile());
                        row3col1BoardCellType = "O";
                        row3col1BoardCellNum = Piece.O_THREE.getValue();
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
        }
        if (turnCounter == 12) {
            System.out.println("E - É uma gravata!");
        }

        if (Xwins) {
            System.out.println("X - D Generation X - Triple X and Shawn Michaels");
        }
        if (Owins) {
            System.out.println("O - Oh madafaka oh oh ohhhhh");
        }

        System.out.println(board.xToCol(e.getX()));
        System.out.println(board.yToRow(e.getY()));
        System.out.println(turnCounter);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}