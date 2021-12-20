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

    public void refreshValue(){
        //System.out.println("We refresh value from Content");
        if (this.content == null) {
            System.out.println("Cell Type : Null");
            this.value = "Null";
        } else if (this.content.charAt(0) == '=') {
            System.out.println("Cell Type : String");
            this.value = this.content;
        } else {
            try {
                this.value = String.valueOf(Integer.parseInt(this.content));
                System.out.println("Cell Type : Int");
            } catch (NumberFormatException e) {
                System.out.println("Cell Type : String");
                this.value = this.content;

            }
        }
    }
}

