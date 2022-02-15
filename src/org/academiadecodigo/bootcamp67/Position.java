package org.academiadecodigo.bootcamp67;

import java.util.Objects;

public class Position {

    private double col;
    private double row;

    public Position(double col, double row) {
        this.col = col;
        this.row = row;
    }

    public double getCol() {
        return col;
    }

    public double getRow() {
        return row;
    }

    public boolean sameCoordinates(double x, double y) {
        return this.col == x && this.row == y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return col == position.col && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
}

