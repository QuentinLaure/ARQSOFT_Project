package com.company;

public class Content {

    String contentInput;
    String contentValue;

    public Content(String contentInput){
        this.contentInput = contentInput;
        contentValue = "DEFAULT VALUE FOR CONTENT";
    }

    public String getInput(){
        return contentInput;
    }

    public void setInput(String contentInput){
        this.contentInput = contentInput;
    }

    public String getValue(){
        return contentValue;
    }

    public void setValue(String contentValue){
        this.contentValue = "DEFAULT 2 VALUE FOR CONTENT";
    }

    public void refreshValue() {
        //System.out.println("We refresh value from Content");
        if (this.contentInput == null) {
            System.out.println("Cell Type : Null");
            this.contentValue = "Null";
        } else if (this.contentInput.charAt(0) == '=') {
            System.out.println("Cell Type : String");
            this.contentValue = this.contentInput;
        } else {
            try {
                this.contentValue = String.valueOf(Integer.parseInt(this.contentInput));
                System.out.println("Cell Type : Int");
            } catch (NumberFormatException e) {
                System.out.println("Cell Type : String");
                this.contentValue = this.contentInput;

            }
        }
    }

}
