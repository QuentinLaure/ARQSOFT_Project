package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Spreadsheet spreadsheet_obj = new Spreadsheet(3,3);

        spreadsheet_obj.setCell(0,0,"uno");
        System.out.println(spreadsheet_obj.getCell(0,0).getContent());
        System.out.println(spreadsheet_obj.getCell(0,0).getValue());
        spreadsheet_obj.setCell(0,1,"dos");
        spreadsheet_obj.setCell(0,2,"tres");
        spreadsheet_obj.setCell(1,0,"45");
        spreadsheet_obj.setCell(1,1,"3");
        spreadsheet_obj.setCell(2,0,"test");
        System.out.println(spreadsheet_obj.getCell(0,0).getContent());
        System.out.println(spreadsheet_obj.getCell(0,0).getValue());

        spreadsheet_obj.setCell(1,2,"=B1+(10+B2)*2");
        System.out.println(spreadsheet_obj.getCell(1,2).getContent());
        System.out.println("value : "+spreadsheet_obj.getCell(1,2).getValue());


        String path = "E:\\JAVA\\spreadsheet.csv"; // "/home/ubuntu18/Documents/spreadsheet.csv"

        spreadsheet_obj.displaySheet();
        spreadsheet_obj.exportSpreadSheet(path);

        ArrayList<ArrayList<String>> importedSpreadSheet = Spreadsheet.importSpreadsheet(path);
        int row = importedSpreadSheet.size();
        int col = importedSpreadSheet.get(0).size();

        Spreadsheet spreadImported = new Spreadsheet( row, col);
        for (int i=0; i<row;i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(importedSpreadSheet.get(i).get(j));
                if (!importedSpreadSheet.get(i).get(j).trim().isEmpty()) {
                    spreadImported.setCell(i, j, importedSpreadSheet.get(i).get(j));
                }
            }
        }

        spreadImported.displaySheet();

    }
}
