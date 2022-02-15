package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Piece {

    O_ONE(1, new Picture(230, 45, "blue_x100.png"));
    /*O_TWO(2),
    O_THREE(3),
    O_FOUR(4),
    O_FIVE(5),
    O_SIX(6),
    X_ONE(1),
    X_TWO(2),
    X_THREE(3),
    X_FOUR(4),
    X_FIVE(5),
    X_SIX(6);*/

    private int value;
    private Picture picture;

    Piece(int value, Picture picture) {
        this.value = value;
        this.picture = picture;
    }

    public Picture getPicture() {
        return picture;
    }
}