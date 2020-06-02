package com.exercises.week3;

/**
 * @author Thanaa Ghanem
 *
 *         Invariant of this bag implementation:
 *
 *         1- The number of items contained in the bag is stored in an instance
 *         variable called manyItems 2- The bag entries are stored in an
 *         instance array variable called data, from position data[0] to
 *         position data[manyItems-1]
 *
 */
public class IntArrayBag{

    private int[] data;
    private int manyItems;

    /**
     * instianties a bag with a defualt size of 10
     */
    public IntArrayBag() {
        this.data = new int[10];
        this.manyItems = 0;
    }

    /**
     * instantiates a bag with a given capacity
     *
     * @param capacity
     *            -- required bag's capacity
     */
    public IntArrayBag(int capacity) {
        this.data = new int[capacity];
        this.manyItems = 0;
    }

    /**
     * @param element
     *            -- value to be added to the bag
     */
    public void add(int element) {
        data[manyItems] = element;
        manyItems++;

    }

    /**
     * removes only one occurrence of element
     *
     * @param element
     *            -- value to be removed
     * @return true or false based on whether an element is removed or not.
     */
    public boolean remove(int element) {

        boolean found = false;

        for (int i = 0; i < manyItems; i++)
            if (data[i] == element) {
                data[i] = data[manyItems - 1];
                this.manyItems--;
                found = true;
                break;
            }

        return found;
    }

    /**
     *
     * @return the number of elements in the bag.
     */
    public int size() {
        return this.manyItems;
    }

    /**
     *
     * @param index
     *            --
     * @return bag element that is located at index
     */
    public int grab(int index) {

        int output = -1;
        if (index < this.manyItems)
            output = this.data[index];

        return output;
    }

    /**
     *
     * @param target
     *            -- value to count
     * @return how many times target exist in the bag
     */
    public int countOccurances(int target) {

        int count = 0;

        for (int i = 0; i < this.manyItems; i++)
            if (data[i] == target)
                count++;

        return count;
    }

    // data[] - manyitems
    public int max() {
        if(manyItems > 0) {
            int temp = data[0];

            // data.length : manyItems
            for(int i = 1; i < manyItems; i++) {
                if(data[i] > temp) {
                    temp = data[i];
                }
            }
            return temp;
        } else {
            return -1;
        }
    }

    /**
     * returns a string representation of the bag
     */
    public String toString() {

        String output = "[";

        for (int i = 0; i < this.manyItems; i++)
            output += this.data[i] + ",";

        output += "]";

        return output;
    }

    /**
     * Instance version of sumEven()
     * @return returns either a -1 if the bag is empty or the sum of all evens in the bag
     *
     */
    public int sumEven() {
        return sumEven(this);
    }

    /**
     *
     * @param intArrayBag object
     * @return returns an int of the evenSum or -1 if the bag is empty
     */
    public static int sumEven(IntArrayBag intArrayBag) {
        int evenSum = 0;

        if(intArrayBag.manyItems == 0) {
            return -1;
        }

        for(int i = 0; i < intArrayBag.manyItems; i++) {
            if(intArrayBag.data[i] % 2 == 0) {
                evenSum += intArrayBag.data[i];
            }
        }

        return evenSum;
    }

    /**
     *
     * @param otherBag another IntArrayBag object
     * @return boolean: true if both have the same exact values in the bag, false otherwise
     */
    public boolean equalsTo(IntArrayBag otherBag) {
        if(this.manyItems == otherBag.manyItems) {
            for(int i = 0; i < this.manyItems; i++) {
                if(this.data[i] != otherBag.data[i]) {
                    return false;
                }
            }
            // if the for loop makes it through then all are the same
            return true;
        }
        // default if both manyItems do not have the same count
        return false;
    }


}
