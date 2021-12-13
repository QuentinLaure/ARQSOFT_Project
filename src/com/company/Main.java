package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("HELLO");
        Spreadsheet spreadsheet_obj = new Spreadsheet(5,5);

        spreadsheet_obj.setCell(0,0,"=firstTest");

        System.out.println(spreadsheet_obj.getCell(0,0).getContent());
        spreadsheet_obj.refreshCell(0,0);
        System.out.println(spreadsheet_obj.getCell(0,0).getValue());


        
    }
}