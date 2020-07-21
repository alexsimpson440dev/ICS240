package com.assignments.assignment2

import spock.lang.Specification

class EngineSortedArrayBagSpecification extends Specification {

    def setup() {
        EngineSortedArrayBag bag1 = new EngineSortedArrayBag()
    }

    def "test bag creation empty constructor"() {
        when:
            EngineSortedArrayBag bag1 = setup()
        then:
            bag1.size() == 0
            bag1.getEngineArray().length == 10
    }

    def "test bag creation with capacity"() {
        when:
            EngineSortedArrayBag bag1 = new EngineSortedArrayBag(1)
        then:
            bag1.getEngineArray().length == 1
    }

    def "test add engine to bag"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4G63", 122)
        then:
            bag1.size() == 1
            bag1.getEngineArray()[0] == new Engine("4G63", 122)
    }

    def "test add engine to bag but reached cap"() {
        when:
            EngineSortedArrayBag bag1 = new EngineSortedArrayBag(1)
            bag1.add("4G63", 122)
            bag1.add("4G63T", 122)
        then:
            bag1.getEngineArray().length == 11
    }

    def "test toString"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4G63", 122)
        then:
            bag1.toString() == "Engine Code\t\tDisplacement\n-----------------------------\n" + bag1.getEngineArray()[0]
    }

    def "test indexOf"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4g63", 122)
        then:
            // first engine should return 0
            bag1.indexOf(new Engine("4g63", 122)) == 0
            // second engine is not in array, so return -1
            bag1.indexOf(new Engine("abc123", 121)) == -1
    }

    def "test remove"() {
        when:
        EngineSortedArrayBag bag1 = setup()
        bag1.add("4g63", 122)
        then:
        // remove only engine results in true
        bag1.remove(new Engine("4g63", 122))
        // try remove again and it should return false
        !bag1.remove(new Engine("4g63", 122))
    }

    def "test remove with multiple items"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4g63", 122)
            bag1.add("4g63", 122)
            bag1.add("4g63t", 122)
            bag1.add("4g63", 122)
        then:
            // remove only engine results in true
            bag1.remove(new Engine("4g63t", 122))
    }

    def "test occurrences"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4g63", 122)
            bag1.add("4g63", 122)
        then:
            bag1.countOccurrences("4g63") == 2
    }

    def "test grab"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4g63", 122)
        then:
            bag1.grab(0) == new Engine("4g63", 122)
    }

    def "test grab failure"() {
        when:
            EngineSortedArrayBag bag1 = setup()
        then:
            bag1.grab(0) == null
    }

    def "test total"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4g63", 122)
        then:
            bag1.total() == 122
    }

    def "test replace success"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            Engine oldEngine = new Engine("4g63", 122)
            Engine newEngine = new Engine("LS1", 346)
            bag1.add("4g63", 122)
        then:
            bag1.replace(oldEngine, newEngine)
            bag1.getEngineArray()[0].equals(newEngine)
    }

    def "test replace failure because null"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            Engine oldEngine = new Engine("4g63", 122)
            bag1.add("4g63", 122)
        then:
            !bag1.replace(oldEngine, null)
            bag1.getEngineArray()[0].equals(oldEngine)
    }

    def "test replace failure because null 2"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            Engine oldEngine = new Engine("4g63", 122)
            Engine newEngine = new Engine("LS1", 346)
            bag1.add("4g63", 122)
        then:
            !bag1.replace(null, newEngine)
            bag1.getEngineArray()[0].equals(oldEngine)
    }

    def "test replace failure because cannot remove or old is not in array"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            Engine oldEngine = new Engine("4g63t", 122)
            Engine newEngine = new Engine("LS1", 346)
            bag1.add("4g63", 122)
        then:
            !bag1.replace(oldEngine, newEngine)
            bag1.getEngineArray()[0].equals(new Engine("4g63", 122))
    }

    def "test sameContents"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4g63", 122)

            EngineSortedArrayBag bag2 = setup()
            bag2.add("4g63", 122)

            EngineSortedArrayBag bag3 = setup()
            bag3.add("4g63", 122)
            bag3.add("4g63", 122)

            EngineSortedArrayBag bag4 = setup()
            bag4.add("abc123", 1)
            bag4.add("123abc", 2)
            bag4.add("123abc", 2)

            EngineSortedArrayBag bag5 = setup()
            bag5.add("abc123", 1)
            bag5.add("123abc", 2)
        then:
            bag1.sameContents(bag1) // equals method
            bag1.sameContents(bag2) // same bag contents
            bag1.sameContents(bag3) // same bag contents but multiple in compared to bag
            bag4.sameContents(bag5) // same bag contents but multiple in comparing to bag
    }

    def "test sameContents failures"() {
        when:
            EngineSortedArrayBag bag1 = setup()
            bag1.add("4g63", 122)

            EngineSortedArrayBag bag2 = setup()

            EngineSortedArrayBag bag3 = setup()
            bag3.add("4g63t", 122)
        then:
            !bag1.sameContents(bag2) // empty bag2
            !bag1.sameContents(null) // null bag
            !bag1.sameContents(bag3) // different bag
    }
}
