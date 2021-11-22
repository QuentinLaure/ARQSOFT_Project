package com.company;
import java.util.Arrays;

public class Spreadsheet {

    protected int nrow;
    protected int ncol;
    protected Cell[][] cellArray;

    public Spreadsheet(int nrow, int ncol){
        this.nrow = nrow;
        this.ncol = ncol;
        this.cellArray = new Cell[this.nrow][this.ncol];
        Content a = new Content("Test");
        this.cellArray[0][0] = new Cell(a);
        //Arrays.fill(this.cellArray, "Default");
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
        System.out.println(this.cellArray.length);
        System.out.println(this.cellArray[0].length);
        this.cellArray[nrow][ncol].setContent(value);
    }

    public Cell getCell(int nrow, int ncol){
        return this.cellArray[nrow][ncol];
    }

}
