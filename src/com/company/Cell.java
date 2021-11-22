package com.company;

public class Cell {
    protected Content content;

    public Cell(Content content){
        this.content = content;
    }

    public void setContent(String content){
        this.content.setValue(content);
    }

    public String getContent(){
        return this.content.getValue();
    }
}

