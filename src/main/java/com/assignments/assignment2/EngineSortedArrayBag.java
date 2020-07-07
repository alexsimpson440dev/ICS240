package com.assignments.assignment2;

import java.util.ArrayList;
import java.util.Arrays;

public class EngineSortedArrayBag {
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
        if(this.numEngines == this.engineArray.length) {
            this.engineArray = Arrays.copyOf(this.engineArray, this.engineArray.length+10);
        }
        sort(engine);
        // increase number of engines in bag
        this.numEngines++;
    }

    private void sort(Engine engine) {
        // first in array, just add
        if(this.numEngines == 0) {
            this.engineArray[this.numEngines] = engine;
        }
        // second in the array, only check against first
        else if(this.numEngines == 1) {
            if(this.engineArray[0].compareTo(engine) <= 0) {
                this.engineArray[numEngines] = engine;
            } else {
                Engine[] newEngineArray = new Engine[this.engineArray.length];
                newEngineArray[0] = engine;
                newEngineArray[1] = this.engineArray[0];
                this.engineArray = newEngineArray;
            }
        }

        // if there are 2 or more items in the array
        else {
            int addIndex = this.numEngines;
            for(int i = 0; i < this.numEngines; i++) {
                if(this.engineArray[i].compareTo(engine) >= 0) {
                    addIndex = i;
                    break;
                }
            }

            Engine[] newEngineArray = new Engine[this.engineArray.length];
            int initialArrayCounter = 0;
            for(int i = 0; i < this.engineArray.length; i++) {
                // only iterates the initial counter when pulled from that counter.
                if(i != addIndex) {
                    newEngineArray[i] = this.engineArray[initialArrayCounter];
                    initialArrayCounter++;
                } else {
                    newEngineArray[i] = engine;
                }
            }

            this.engineArray = newEngineArray;
        }
    }
}
