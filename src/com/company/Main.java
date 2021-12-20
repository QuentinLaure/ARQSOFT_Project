package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {

        Spreadsheet spreadsheet_obj = new Spreadsheet(3,3);

        spreadsheet_obj.setCell(0,0,"yui");
        System.out.println(spreadsheet_obj.getCell(0,0).getContent());
        System.out.println(spreadsheet_obj.getCell(0,0).getValue());
        spreadsheet_obj.setCell(0,1,"dos");
        spreadsheet_obj.setCell(0,2,"tres");
        spreadsheet_obj.setCell(1,1,"11");
        spreadsheet_obj.setCell(0,0,"New Try value");
        spreadsheet_obj.setCell(0,2,"3");
        spreadsheet_obj.setCell(2,2,"7");
        System.out.println(spreadsheet_obj.getCell(0,0).getContent());
        System.out.println(spreadsheet_obj.getCell(0,0).getValue());

        spreadsheet_obj.displaySheet();
        spreadsheet_obj.exportSpreadSheet();

        // spreadsheet importing
        ArrayList<ArrayList<String>> importedSPreadSheet = Spreadsheet.importSpreadsheet();
        int row = importedSPreadSheet.size();
        int col = importedSPreadSheet.get(0).size();
       // Collections.(importedSPreadSheet.stream().count()
        System.out.println("row and col" +row+" "+col);
        System.out.println("0 2 value " + importedSPreadSheet.get(0).get(2));
        //int i=0,j=0;
        String vacio = "";
        Spreadsheet spreadImported = new Spreadsheet( row, col);
        for (int i=0; i<row;i++)
            for (int j=0; j<col;j++)
            {  if(importedSPreadSheet.get(i).get(j)!=vacio)
                     {spreadImported.setCell(i,j,importedSPreadSheet.get(i).get(j));}
            }

        spreadImported.displaySheet();
//        spreadsheet_obj.refreshCellValue(0,0);
//        System.out.println(spreadsheet_obj.getCell(0,0).getValue());

    }
}
