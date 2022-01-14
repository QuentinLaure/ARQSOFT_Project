package com.company;

public class CellNumerical extends Cell {

    protected int valueNumerical;

    public CellNumerical(String contentInput) {
        super(contentInput);
        this.value = contentInput;
    }

    public String getContent(){
        return "content of CellNumerical : "+this.content;
    }
}
