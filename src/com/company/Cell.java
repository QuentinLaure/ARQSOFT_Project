package com.company;

public class Cell {
    protected String content;
    protected String value;

    public Cell(String content){
        this.content = content;
        this.value = "";
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void refreshValue(){
        if(this.content == null) {
            this.value = "Null";
        } else if(this.content.charAt(0) == '=') {
            this.value = "Int";
        } else {
            this.value = "Exceptioon";
        }
    }

    public String getValue(){
        return this.value;
    }
}

