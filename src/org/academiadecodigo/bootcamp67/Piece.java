package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Piece {

    O_ONE(1, new Picture(210, 45, "O1.png")),
    O_TWO(2, new Picture( 310, 45, "O2.png")),
    O_THREE(3, new Picture( 410, 45, "O3.png")),
    O_FOUR(4, new Picture( 510, 45, "O4.png")),
    O_FIVE(5, new Picture( 610, 45, "O5.png")),
    O_SIX(6, new Picture( 710, 45, "O6.png")),

    X_ONE(1, new Picture( 210, 675, "X1.png")),
    X_TWO(2, new Picture( 310, 675, "X2.png")),
    X_THREE(3, new Picture( 410, 675, "X3.png")),
    X_FOUR(4, new Picture( 510, 675, "X4.png")),
    X_FIVE(5, new Picture( 610, 675, "X5.png")),
    X_SIX(6, new Picture( 710, 675, "X6.png"));

    private int value;
    private Picture picture;

    Piece(int value, Picture picture) {
        this.value = value;
        this.setPicture(picture);
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public int getValue() {
        return value;
    }
}