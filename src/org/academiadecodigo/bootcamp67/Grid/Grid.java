package org.academiadecodigo.bootcamp67.Grid;

import org.academiadecodigo.bootcamp67.Position;

public interface Grid {

    int PADDING = 10;
    int CELL_SIZE = 10;

    public double rowToY(double rows);

    public double columnToX(double cols);

    public double yToRow(double y);

    public double xToCol(double x);

    // GETTERS & SETTERS
    public double getCols();

    public double getRows();

    public double getY();

    public double getX();

    public void setCols(int cols);

    public void setRows(int rows);

    public Position getPos();
}
