package com.company;

public class Cell {
    protected Content content;

    public Cell(String contentInput){
        this.content = new Content(contentInput);
    }

    public void setContent(String contentInput){
        this.content.setInput(contentInput);
    }

    public String getContent(){
        return this.content.getInput();
    }

    public String getValue(){
        return this.content.getValue();
    }

    public void refreshValue(){
        this.content.refreshValue();
    }
}

