package com.exercises.week5;

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

    public static int listLength(IntNode head){
        IntNode cursor = head;
        int answer = 0;
        while (cursor != null){
            answer++;
            cursor = cursor.link;
        }
        return answer;
    }

}
