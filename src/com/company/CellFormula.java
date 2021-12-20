package com.company;

public class CellFormula extends Cell{

    public CellFormula(String contentInput) {
        super(contentInput);
    }

    public String getContent(){
        return "content of CellFormula : "+this.content;
    }

}
