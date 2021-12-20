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

    public int getNcol() {
        return ncol;
    }

    public Cell[][] getArray() {
        return cellArray;
    }

    public void setCell(int nrow, int ncol, String contentInput) {
        //if(this.cellArray[nrow][ncol]==null) {
            //this.cellArray[nrow][ncol] = new Cell("");
            if (contentInput.charAt(0) == '=') {
                System.out.println("Creating a CellFormula");
                this.cellArray[nrow][ncol] = new CellFormula(contentInput);
            } else {
                try {
                    int val = Integer.parseInt(contentInput); // String.valueOf(Integer.parseInt(contentInput));
                    this.cellArray[nrow][ncol] = new CellNumerical(contentInput);
                    System.out.println("Creating a CellNumerical");
                } catch (NumberFormatException e) {
                    System.out.println("Creating a CellText");
                    this.cellArray[nrow][ncol] = new CellText(contentInput);
                }
            }
        }
        //this.cellArray[nrow][ncol].setContent(contentInput);
    //}

    public Cell getCell(int nrow, int ncol){
        return this.cellArray[nrow][ncol];
    }

    /*public void refreshCellValue(int nrow,int ncol){
        this.cellArray[nrow][ncol].refreshValue();
    }*/

    public void displaySheet(){
        // refresh the values of every cell
        this.refreshAllCellsValues();
        // iterate over every cell and print their value
        System.out.println("Method to display the spreadsheet, with the value of every cell");
    }

    public void refreshAllCellsValues(){
        // iterate over every cell and refresh their value
        System.out.println("Method to refresh the values of every cell of the spreadsheet");
    }

}
