package com.assignments.assignment2;

import java.util.Arrays;
import java.util.Iterator;

public class EngineSortedArrayBag implements Iterable<Engine> {
    private int numEngines = 0;
    private Engine[] engineArray;

    public EngineSortedArrayBag() {
        this.engineArray = new Engine[10];
    }

    public EngineSortedArrayBag(int capacity) {
        this.engineArray = new Engine[capacity];
    }

    public Engine[] getEngineArray() {
        return engineArray;
    }

    public void add(String engineCode, int displacement) {
        Engine engine = new Engine(engineCode, displacement);
        // check engineArray size and update to new size if needed
        // copies array to new array doing a bitwise right shift (close to initial size) (idea from ArrayList.java)
        if (this.numEngines == this.engineArray.length) {
            this.engineArray = Arrays.copyOf(this.engineArray, this.engineArray.length + 10);
        }
        sort(engine);
        // increase number of engines in bag
        this.numEngines++;
    }

    public int size() {
        return this.numEngines;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder("Engine Code\t\tDisplacement\n" +
                "-----------------------------");

        for (int i = 0; i < this.size(); i++) {
            message.append("\n");
            message.append(this.engineArray[i].toString());
        }
        return message.toString();
    }

    public int indexOf(Engine engine) {
        for (int i = 0; i < this.size(); i++) {
            if (this.engineArray[i].equals(engine)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Engine engine) {
        int index = this.indexOf(engine);
        if (index == -1) {
            return false;
        } else {
            this.numEngines--;
            this.deletedSort(index);

            return true;
        }
    }

    public int countOccurrences(String engineCode) {
        int occurrences = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.engineArray[i].getEngineCode().equalsIgnoreCase(engineCode)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public Engine grab(int index) {
        if (index > this.size() - 1) {
            return null;
        } else {
            return this.engineArray[index];
        }
    }

    public int total() {
        int sum = 0;
        for (int i = 0; i < this.size(); i++) {
            sum += this.engineArray[i].getDisplacement();
        }
        return sum;
    }

    public boolean replace(Engine oldEngine, Engine newEngine) {
        // first delete the old if possible
        if (oldEngine != null && newEngine != null && this.remove(oldEngine)) {
            // add new, assuring proper sort
            this.add(newEngine.getEngineCode(), newEngine.getDisplacement());

            return true;
        }
        return false;
    }

    // compare the input bag to the current bag
    public boolean sameContents(EngineSortedArrayBag bag) {
        if(this.equals(bag)) {
            return true;
        }

        if(bag == null || bag.size() == 0) {
            return false;
        }

        for(int i = 0; i < bag.size(); i++) {
            if(this.indexOf(bag.engineArray[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    private void sort(Engine engine) {
        // first in array, just add
        if (this.numEngines == 0) {
            this.engineArray[this.numEngines] = engine;
        } else if (this.numEngines == 1) { // second in the array, only check against first
            if (this.engineArray[0].compareTo(engine) <= 0) {
                this.engineArray[numEngines] = engine;
            } else {
                Engine[] newEngineArray = new Engine[this.engineArray.length];
                newEngineArray[0] = engine;
                newEngineArray[1] = this.engineArray[0];
                this.engineArray = newEngineArray;
            }
        } else { // if there are 2 or more items in the array
            int addIndex = this.numEngines;
            for (int i = 0; i < this.numEngines; i++) {
                if (this.engineArray[i].compareTo(engine) >= 0) {
                    addIndex = i;
                    break;
                }
            }

            Engine[] newEngineArray = new Engine[this.engineArray.length];
            int initialArrayCounter = 0;
            for (int i = 0; i < this.engineArray.length; i++) {
                // only iterates the initial counter when pulled from that counter.
                if (i != addIndex) {
                    newEngineArray[i] = this.engineArray[initialArrayCounter];
                    initialArrayCounter++;
                } else {
                    newEngineArray[i] = engine;
                }
            }
            this.engineArray = newEngineArray;
        }
    }

    private void deletedSort(int deletedIndex) {
        Engine previousEngine = null;
        // shift everything up to removed index
        for (int i = deletedIndex; i > 0; i--) {
            previousEngine = this.engineArray[i - 1];
            this.engineArray[i] = previousEngine;
        }

        // shift everything back to index 0
        Engine currentEngine = this.engineArray[this.size()];
        for (int i = this.size(); i > 0; i--) {
            previousEngine = this.engineArray[i - 1];
            this.engineArray[i - 1] = currentEngine;
            currentEngine = previousEngine;
        }
        // replace the last index with null as it is still an engine object that was shifted
        this.engineArray[this.size()] = null;
    }

    public Iterator<Engine> iterator() {
        return new EngineArrayBagIterator();
    }

    public class EngineArrayBagIterator implements Iterator<Engine> {

        private int cursor = 0;

        public boolean hasNext() {
            return cursor < size();
        }

        public Engine next() {
            return engineArray[cursor++];
        }
    }
}
