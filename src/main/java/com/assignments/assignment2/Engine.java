package com.assignments.assignment2;

public class Engine implements Comparable<Engine> {
    private String engineCode;
    private int displacement;

    public Engine(String engineCode, int displacement) {
        this.engineCode = engineCode;
        this.displacement = displacement;
    }

    @Override
    public String toString() {
        return "Engine Code: " + this.engineCode + "\tDisplacement: " + this.displacement;
    }

    @Override
    public boolean equals(Object obj) {
        // compared to itself
        if(this == obj) {
            return true;
        }

        // null check and class check
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // cast and check parameters
        Engine engine = (Engine) obj;
        return this.engineCode.equalsIgnoreCase(engine.engineCode) && this.displacement == engine.displacement;
    }

    @Override
    public int compareTo(Engine engine) {
        // throw exception for null engine (cant compare)
        if(engine == null) {
            throw new NullPointerException();
        }

        if(this.equals(engine)) {
            return 0;
        } else if(this.engineCode.equalsIgnoreCase(engine.engineCode)) {
            // scenario where the codes are the same, check displacement and compare that way
            if(this.displacement < engine.displacement) {
                return -1;
            }
            return 1;
        } else {
            // final scenario where neither are the same
            String longer = this.engineCode;
            String shorter = engine.engineCode;
            int defaultReturn = 1;

            // try catch, check if they are only numbers and if so, do numeric comparison, else compare chars
            try {
                if(Integer.parseInt(longer) > Integer.parseInt(shorter)) {
                    return 1;
                }
                return -1;
            } catch(Exception e) {
                if(this.engineCode.length() < engine.engineCode.length()) {
                    longer = engine.engineCode;
                    shorter = this.engineCode;
                    defaultReturn = -1;
                }

                for(int i = 0; i < shorter.length(); i++) {
                    if(shorter.toLowerCase().charAt(i) > longer.toLowerCase().charAt(i)) {
                        if(shorter.equalsIgnoreCase(this.engineCode)) {
                            return 1;
                        }
                        return -1;
                    }

                    if(shorter.toLowerCase().charAt(i) < longer.toLowerCase().charAt(i)) {
                        if(shorter.equalsIgnoreCase(this.engineCode)) {
                            return -1;
                        }
                        return 1;
                    }
                }
                // default is used when we have the same string aside from length. abcd > abc
                return defaultReturn;
            }
        }
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
}
