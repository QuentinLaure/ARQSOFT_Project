package com.company;

public class CellFormula extends Cell{

    public CellFormula(String contentInput) {
        super(contentInput);
    }

    public String getContent(){
        return "content of CellFormula : "+this.content;
    }

    public String getValue(){
        return String.valueOf(Algorithm.evaluate(this.content));
    }

    public String getCellValue(char rowLetter, int column){
        int row = Spreadsheet.fromAlphabeticalToRow(rowLetter);
        return Spreadsheet.getCell(row,column).getValue();
    }

}
