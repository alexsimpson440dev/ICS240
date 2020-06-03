package com.exercises.week4;

public class IntNodeDriver {

    public static void main(String[] args) {

        IntNode tail = new IntNode(27,null);
        IntNode n2 = new IntNode(222, tail);
        IntNode head = new IntNode(1131, n2);
        IntNode newHead = new IntNode(13222,head);


        System.out.println(newHead);

        int sum = 0;

        IntNode cursor = n2;

        while (cursor!= null){
            sum = sum + cursor.getData();
            cursor = cursor.getLink();
        }

        System.out.println(sum);
        System.out.println(max(newHead));
    }

    public static int max(IntNode cursor) {
        int temp = -1;

        if(cursor != null) {
            temp = cursor.getData();
        } else {
            return temp;
        }

        while(cursor != null) {
            if(cursor.getData() > temp) {
                temp = cursor.getData();
            }
            cursor = cursor.getLink();
        }

        return temp;
    }

}

