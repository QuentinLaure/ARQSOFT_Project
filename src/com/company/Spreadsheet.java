package com.company;
import java.io.*;
import java.util.*;

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
                System.out.println("Creating a CellFormula at position ("+nrow+","+ncol+")");
                this.cellArray[nrow][ncol] = new CellFormula(contentInput);
            } else {
                try {
                    int val = Integer.parseInt(contentInput); // String.valueOf(Integer.parseInt(contentInput));
                    this.cellArray[nrow][ncol] = new CellNumerical(contentInput);
                    System.out.println("Creating a CellNumerical at position ("+nrow+","+ncol+")");
                } catch (NumberFormatException e) {
                    System.out.println("Creating a CellText at position ("+nrow+","+ncol+")");
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
        System.out.println("Method to display the spreadsheet 1, with the value of every cell");
            // Loop through all rows
            for (int i = 0; i < this.cellArray.length; i++){
                System.out.println("\n");
                // Loop through all elements of current row
                for (int j = 0; j < this.cellArray[i].length; j++)
                    { if(this.cellArray[i][j]==null)
                        System.out.print("null"+ " ");
                        else
                        System.out.print(this.cellArray[i][j].value + " ");
                    }

            }

     //   this.refreshAllCellsValues();
        // iterate over every cell and print their value

    }


    public static ArrayList<ArrayList<String>> importSpreadsheet() throws Exception {

                //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("/home/ubuntu18/Documents/testCSV.csv"));
        ArrayList<ArrayList<String>> arrayImported = new ArrayList<ArrayList<String>>();
        //arrayImported.set(0,new ArrayList<>());

        while (sc.hasNext())  //returns a boolean value
                {

                    String[] temporal= sc.nextLine().split(";",-1); // -1 consider null on split
                    // https://stackoverflow.com/questions/14602062/java-string-split-removed-empty-values

                    ArrayList test = new ArrayList<String>(Arrays.asList(temporal)) ;
                    arrayImported.add(test);
                    System.out.println( test);
                    System.out.println("temporal[0]" + temporal[0]);

                    //System.out.println(sc.next());  //find and returns the next complete token from this scanner

                }

                sc.close();  //closes the scanner
        System.out.println("imported arrayImported 0"+ arrayImported.get(0));
        System.out.println("imported arrayImported 0 0"+ arrayImported.get(0).get(0));

    return arrayImported;
    }

    public void exportSpreadSheet()
    {
        System.out.println("exporting spreadshet");
        try {
           // int[][] matrix = new int[3][3];

            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ubuntu18/Documents/exportedCSV.csv"));


            //int num = 1;

            for (int i = 0; i < this.cellArray.length; i++){
                StringBuilder sb = new StringBuilder();
                StringJoiner joiner = new StringJoiner(";");
                for (int j = 0; j < this.cellArray[i].length; j++){
                    if(cellArray[i][j]!=null)
                        joiner.add(this.cellArray[i][j].value);
                    else
                        joiner.add("");
                    //sb.append(cellArray[i][j].value);
                   // sb.append(";");

                }
               // for (String chain:chaining) {
                //
                //    joiner.add(chain);
               // }
                System.out.println("joiner.toString()"+ joiner.toString());
                writer.write(joiner.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    public void refreshAllCellsValues(){
        // iterate over every cell and refresh their value
        System.out.println("Method to refresh the values of every cell of the spreadsheet");
    }

}
