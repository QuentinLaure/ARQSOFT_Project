package com.company;

import java.util.ArrayList;
import java.util.Collections;

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
//        spreadsheet_obj.setCell(1,2,"3");
        spreadsheet_obj.setCell(2,0,"test");
        System.out.println(spreadsheet_obj.getCell(0,0).getContent());
        System.out.println(spreadsheet_obj.getCell(0,0).getValue());

//        spreadsheet_obj.displaySheet();
//        spreadsheet_obj.exportSpreadSheet();

        //// spreadsheet importing
//        ArrayList<ArrayList<String>> importedSPreadSheet = Spreadsheet.importSpreadsheet();
//        int row = importedSPreadSheet.size();
//        int col = importedSPreadSheet.get(0).size();
       /////// Collections.(importedSPreadSheet.stream().count()

//        Spreadsheet spreadImported = new Spreadsheet( row, col);
//        for (int i=0; i<row;i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.println(importedSPreadSheet.get(i).get(j));
//                if (!importedSPreadSheet.get(i).get(j).trim().isEmpty()) {
//                    spreadImported.setCell(i, j, importedSPreadSheet.get(i).get(j));
//                }
//            }
//        }

        spreadsheet_obj.setCell(1,2,"=B1+(10+B2)*2");
        System.out.println(spreadsheet_obj.getCell(1,2).getContent());
        System.out.println("value : "+spreadsheet_obj.getCell(1,2).getValue());

//        spreadImported.displaySheet();
//        spreadsheet_obj.refreshCellValue(0,0);
//        System.out.println(spreadsheet_obj.getCell(0,0).getValue());

    }
}
