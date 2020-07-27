package com.assignments.assignment2;

public class EngineNode {
    private Engine data;
    private EngineNode link;

    public EngineNode(Engine data, EngineNode link) {
        this.data = data;
        this.link = link;
    }

    public void addNodeAfter(Engine element){
        this.link = new EngineNode(element, this.link);
    }

    public void removeNodeAfter(){
        this.link = this.link.link;
    }

    public static void display(EngineNode list){
        EngineNode cursor = list;
        while (cursor != null){
            System.out.println(cursor.getData());
            cursor = cursor.getLink();
        }
    }

    public static EngineNode listPosition(EngineNode head, int position){
        EngineNode cursor = head;
        int index = 1;

        while (cursor != null && index < position){
            index++;
            cursor = cursor.getLink();
        }
        return cursor;
    }

    public static int listLength(EngineNode head){
        EngineNode cursor = head;
        int answer = 0;

        while (cursor != null){
            answer++;
            cursor = cursor.link;
        }
        return answer;
    }

    public static EngineNode listSearch(EngineNode head, Engine target){
        EngineNode cursor = head;

        while (cursor != null){
            if (cursor.getData() == target)
                return cursor;
            cursor = cursor.getLink();
        }
        return null;
    }

    public Engine getData() {
        return data;
    }

    public void setData(Engine data) {
        this.data = data;
    }

    public EngineNode getLink() {
        return link;
    }

    public void setLink(EngineNode link) {
        this.link = link;
    }
}
