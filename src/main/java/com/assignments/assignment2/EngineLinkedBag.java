package com.assignments.assignment2;

public class EngineLinkedBag {
    private EngineNode head;
    private int manyItems;

    public EngineLinkedBag() {
        this.manyItems = 0;
        this.head = null;
    }

    public int size() {
        return this.manyItems;
    }

    public void add(Engine element) {
        this.head = new EngineNode(element, this.head);
        this.manyItems++;
    }

    public void addLast(Engine element) {
        EngineNode cursor = this.head;
        while (cursor.getLink() != null) {
            cursor = cursor.getLink();
        }

        cursor.addNodeAfter(element);
        this.manyItems++;
    }

    public void add(int position, Engine element) {
        if (position > this.manyItems) {
            this.addLast(element);
        } else {
            EngineNode cursor = this.head;
            for (int i = 1; i <= position; i++) {
                if (i == position-1) {
                    // get previous
                    cursor.setLink(new EngineNode(element, cursor.getLink()));
                }
                cursor = cursor.getLink();
            }
            manyItems++;
        }
    }

    public boolean remove(Engine target) {
        EngineNode cursor = this.head;
        boolean removed = false;

        while (cursor != null) {
            if (cursor.getData().equals(target)) {
                cursor.setData(this.head.getData());
                this.head = this.head.getLink();
                this.manyItems--;
                removed = true;
                break;
            }
            cursor = cursor.getLink();
        }
        return removed;
    }

    public boolean remove(int position) {
        if (position > this.manyItems || position < 1) {
            return false;
        } else {
            boolean removed = false;
            EngineNode cursor = this.head;
            for (int i = 1; i <= position; i++) {
                if (i == position) {
                    removed = this.remove(cursor.getData());
                    break;
                }
                cursor = cursor.getLink();
            }
            return removed;
        }
    }

    public void removeLast() {
        EngineNode cursor = this.head;
        if (cursor.getLink() == null) {
            this.head = null;
        } else {
            while (cursor.getLink().getLink() != null) {
                cursor = cursor.getLink();
            }
            cursor.removeNodeAfter();
        }
        this.manyItems--;
    }

    public Engine grab(int position) {
        EngineNode cursor = this.head;
        if (cursor == null) {
            return null;
        } else {
            for (int i = 1; i <= position; i++) {
                if (i == position) {
                    return cursor.getData();
                }
                cursor = cursor.getLink();
            }
            return null;
        }
    }

    public int positionOf(Engine target) {
        EngineNode cursor = this.head;
        if (cursor == null) {
            return -1;
        } else {
            int counter = 1;

            while (cursor.getLink() != null) {
                if (cursor.getData().equals(target)) {
                    return counter;
                }
                counter++;
            }
            return -1;
        }
    }

    public void set(int position, Engine element) {
        EngineNode cursor = this.head;
        if (cursor != null) {
            for (int i = 1; i <= position; i++) {
                if (i == position) {
                    cursor.setData(element);
                }
                cursor = cursor.getLink();
            }
        }
    }

    public int totalValue() {
        int total = 0;
        EngineNode cursor = this.head;

        while (cursor != null) {
            total += cursor.getData().getDisplacement();
            cursor = cursor.getLink();
        }
        return total;
    }

    public Engine getMax() {
        EngineNode cursor = this.head;
        Engine max = cursor.getData();

        while (cursor != null) {
            if (max.compareTo(cursor.getData()) < 0) {
                max = cursor.getData();
            }
            cursor = cursor.getLink();
        }
        return max;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder linkedBag = new StringBuilder();
        EngineNode cursor = this.head;
        if (cursor == null) {
            return linkedBag.append("Empty Bag!").toString();
        } else {
            linkedBag.append("Position 1:").append(cursor.getData()).append("\n");
            int counter = 2;
            while (cursor.getLink() != null) {
                cursor = cursor.getLink();
                linkedBag.append("Position ").append(counter).append(":").append(cursor.getData()).append("\n");
                counter++;
            }
            return linkedBag.toString();
        }
    }
}
