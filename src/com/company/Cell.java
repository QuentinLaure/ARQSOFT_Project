package com.company;

public class Cell {
    protected String column;
    protected int row;
    protected Content content;

    public String getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Cell(String column, int row){
        this.column = column;
        this.row = row;
    }

    public void setContent(Content content){
        this.content = content;
    }
}

