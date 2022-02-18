package org.academiadecodigo.bootcamp67.Grid;

public interface Grid {

    int PADDING = 10;
    int CELL_SIZE = 10;

    double rowToY(double rows);
    double columnToX(double cols);
    double yToRow(double y);
    double xToCol(double x);

}
