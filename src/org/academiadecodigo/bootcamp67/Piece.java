package org.academiadecodigo.bootcamp67;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Piece {

    O_ONE("O", 1, "O1.png", new Picture(210, 45, "O1.png")),
    O_TWO("O", 2, "O2.png", new Picture( 310, 45, "O2.png")),
    O_THREE("O", 3, "O3.png", new Picture( 410, 45, "O3.png")),
    O_FOUR("O", 4, "O4.png", new Picture( 510, 45, "O4.png")),
    O_FIVE("O", 5, "O5.png", new Picture( 610, 45, "O5.png")),
    O_SIX("O", 6, "O6.png", new Picture( 710, 45, "O6.png")),

    X_ONE("X", 1, "X1.png", new Picture( 210, 675, "X1.png")),
    X_TWO("X", 2, "X2.png", new Picture( 310, 675, "X2.png")),
    X_THREE("X", 3, "X3.png", new Picture( 410, 675, "X3.png")),
    X_FOUR("X", 4, "X4.png", new Picture( 510, 675, "X4.png")),
    X_FIVE("X", 5, "X5.png", new Picture( 610, 675, "X5.png")),
    X_SIX("X", 6, "X6.png", new Picture( 710, 675, "X6.png"));

    private final String type;
    private final int value;
    private String imageFile;
    private Picture picture;

    Piece(String type, int value, String imageFile, Picture picture) {
        this.type = type;
        this.value = value;
        this.imageFile = imageFile;
        this.setPicture(picture);
    }

    public Picture getPicture() {
        return picture;
    }

    public String getType() {
        return type;
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