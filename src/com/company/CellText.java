package com.company;

public class CellText extends Cell{

    public CellText(String contentInput) {
        super(contentInput);
        this.value = contentInput;
    }

    public String getContent(){
        return "content of CellText : "+this.content;
    }

}
