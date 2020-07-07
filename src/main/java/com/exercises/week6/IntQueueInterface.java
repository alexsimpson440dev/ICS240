package com.exercises.week6;

public interface IntQueueInterface{

    /**
     * Accessor method to determine the number of items in this queue.
     * @return the number of items in this queue
     * **/
    public int size();

    /**adds a new item to this queue.
     *  @param item - the item to be inserted into this queue
     **/
    public void add(int item);

    /** Get the front item and remove it from this queue.
     * @return The return value is the front item of this queue
     **/
    public int remove();

    /**Determine whether this queue is empty.
     * @return true if this queue is empty and false otherwise.
     */
    public boolean isEmpty();

    /** convert the queue to a printable string
     * @return	a string representing the queue
     **/
    public String toString();

}


