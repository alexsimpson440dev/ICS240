package com.exercises.week4;

public class IntNode {

    private int data;
    private IntNode link;

    public IntNode(int initialData, IntNode initialLink){
        this.data = initialData;
        this.link = initialLink;
    }

    public int getData() { return this.data;}
    public void setData(int data) { this.data = data;}

    public IntNode getLink() {return this.link; }
    public void setLink(IntNode link) { this.link = link; }

}
