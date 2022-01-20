package com.company;
import java.io.*;
import java.util.*;

public class Spreadsheet {

    protected int nrow;
    protected int ncol;
    protected static Cell[][] cellArray;

    public Spreadsheet(int nrow, int ncol){
        this.nrow = nrow;
        this.ncol = ncol;
        this.cellArray = new Cell[this.nrow][this.ncol];
    }

    public void setCell(int nrow, int ncol, String contentInput) {
//        System.out.println("Creating a Cell at position ("+nrow+","+ncol+") whose content is "+contentInput);
        if(contentInput == null){
            System.out.println("ERROR NULL WHILE CELL INITIALIZATION");
        }
            if (contentInput.charAt(0) == '=') {
//                System.out.println("Creating a CellFormula at position ("+nrow+","+ncol+")");
                cellArray[nrow][ncol] = new CellFormula(contentInput);
            } else {
                try {
                    int val = Integer.parseInt(contentInput); // if this does not raise a NumberFormatExpression, then it was a int
                    cellArray[nrow][ncol] = new CellNumerical(contentInput);
//                    System.out.println("Creating a CellNumerical at position ("+nrow+","+ncol+")");
                } catch (NumberFormatException e) {
//                    System.out.println("Creating a CellText at position ("+nrow+","+ncol+")");
                    cellArray[nrow][ncol] = new CellText(contentInput);
                }
            }
        }

    public static Cell getCell(int nrow, int ncol){
        return cellArray[nrow][ncol];
    }

    public void displaySheet(){
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

    }


    public static ArrayList<ArrayList<String>> importSpreadsheet(String path) throws Exception {
        System.out.println("We start importing the spreadsheet");
        //parsing a CSV file into Scanner class constructor

        Scanner sc = new Scanner(new File(path));

        ArrayList<ArrayList<String>> arrayImported = new ArrayList<ArrayList<String>>();
        //arrayImported.set(0,new ArrayList<>());

        while (sc.hasNext()){  //returns a boolean value
            String[] temporal= sc.nextLine().split(";",-1); // -1 consider null on split
            // https://stackoverflow.com/questions/14602062/java-string-split-removed-empty-values

            ArrayList test = new ArrayList<String>(Arrays.asList(temporal)) ;
            arrayImported.add(test);
            System.out.println( test);
            System.out.println("temporal[0] " + temporal[0]);
            if(temporal[0].trim().isEmpty()){
                System.out.println("WE HAVE AN EMPTY LINE");
            }
            //System.out.println(sc.next());  //find and returns the next complete token from this scanner
        }

        sc.close();  //closes the scanner
        System.out.println("imported arrayImported 0"+ arrayImported.get(0));
        System.out.println("imported arrayImported 0 0"+ arrayImported.get(0).get(0));

    return arrayImported;
    }

    public void exportSpreadSheet(String path) {
        System.out.println("exporting spreadshet");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            for (int i = 0; i < this.cellArray.length; i++){
                StringBuilder sb = new StringBuilder();
                StringJoiner joiner = new StringJoiner(";");
                for (int j = 0; j < this.cellArray[i].length; j++){
                    if(cellArray[i][j]!=null)
                        joiner.add(this.cellArray[i][j].value);
                    else
                        joiner.add("");


                }
                writer.write(joiner.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
