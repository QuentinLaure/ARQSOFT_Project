package com.company;

public class Spreadsheet {

    protected int nrow;
    protected int ncol;
    protected Cell[][] cellArray;

    public Spreadsheet(int nrow, int ncol){
        this.nrow = nrow;
        this.ncol = ncol;
        this.cellArray = new Cell[this.nrow][this.ncol];
    }

    public int getNrow() {
        return nrow;
    }

    public void setNrow(int nrow) {
        this.nrow = nrow;
    }

    public int getNcol() {
        return ncol;
    }

    public void setNcol(int ncol) {
        this.ncol = ncol;
    }

    public Cell[][] getArray() {
        return cellArray;
    }

    public void setCell(int nrow, int ncol, String value) {
        if(this.cellArray[nrow][ncol]==null) {
            this.cellArray[nrow][ncol] = new Cell("");
        }
        this.cellArray[nrow][ncol].setContent(value);
    }

    public Cell getCell(int nrow, int ncol){
        return this.cellArray[nrow][ncol];
    }

    public void refreshCell(int nrow,int ncol){
        this.cellArray[nrow][ncol].refreshValue();
    }

}
