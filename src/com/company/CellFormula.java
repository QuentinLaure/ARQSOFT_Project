package com.company;

public class CellFormula extends Cell{

    public CellFormula(String contentInput) {
        super(contentInput);
    }

    public String getContent(){
        return "content of CellFormula : "+this.content;
    }

    public String getValue(){
        //System.out.println("obtained value on cell formula get Value is "+ Algorithm.evaluate(this.content));

        if (Algorithm.evaluate(this.content)!=null)
            return String.valueOf(Algorithm.evaluate(this.content));
        else
            return "#VALUE!";
    }

    public String getCellValue(char rowLetter, int column){
        int row = Spreadsheet.fromAlphabeticalToRow(rowLetter);
        return Spreadsheet.getCell(row,column).getValue();
    }

}
