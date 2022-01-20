package com.company;

public class CellFormula extends Cell{

    public CellFormula(String contentInput) {
        super(contentInput);
        this.refreshValue();
    }

    public String getContent(){
        return "content of CellFormula : "+this.content;
    }
    public void refreshValue(){
        if (Algorithm.evaluate(this.content)!=null){
            this.value = String.valueOf(Algorithm.evaluate(this.content));
        } else {
            this.value = "#VALUE!";
        }
    }
}
