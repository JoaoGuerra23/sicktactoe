package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Piece {

    O_ONE(1, "O1.png", new Picture(210, 45, "O1.png")),
    O_TWO(2, "O2.png", new Picture( 310, 45, "O2.png")),
    O_THREE(3, "O3.png", new Picture( 410, 45, "O3.png")),
    O_FOUR(4, "O4.png", new Picture( 510, 45, "O4.png")),
    O_FIVE(5, "O5.png", new Picture( 610, 45, "O5.png")),
    O_SIX(6, "O6.png", new Picture( 710, 45, "O6.png")),

    X_ONE(1, "X1.png", new Picture( 210, 675, "X1.png")),
    X_TWO(2, "X2.png", new Picture( 310, 675, "X2.png")),
    X_THREE(3, "X3.png", new Picture( 410, 675, "X3.png")),
    X_FOUR(4, "X4.png", new Picture( 510, 675, "X4.png")),
    X_FIVE(5, "X5.png", new Picture( 610, 675, "X5.png")),
    X_SIX(6, "X6.png", new Picture( 710, 675, "X6.png"));

    private final int value;
    private String imageFile;
    private Picture picture;

    Piece(int value, String imageFile, Picture picture) {
        this.value = value;
        this.imageFile = imageFile;
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

    public String getImageFile() {
        return imageFile;
    }
}