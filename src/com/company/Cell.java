package com.company;

public class Cell {
    protected String column;
    protected int row;
    protected Content content;
    protected String contentValue;

    public String getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public Cell(String column, int row, String contentValue){
        this.column = column;
        this.row = row;
        this.contentValue = contentValue;
    }
}

