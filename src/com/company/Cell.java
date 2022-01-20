package com.company;

public class Cell {
    protected String content;
    protected String value;

    public Cell(String contentInput){
        this.content = contentInput;
        this.value = "DEFAULT VALUE FOR CONTENT";
    }

    public void setContent(String contentInput){
        this.content = contentInput;
    }

    public String getContent(){
        return this.content;
    }

    public String getValue(){
        return this.value;
    }

}

