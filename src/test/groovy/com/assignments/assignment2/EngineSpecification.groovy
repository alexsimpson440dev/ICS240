package com.assignments.assignment2

import com.assignments.assignment1.Distributor
import spock.lang.Specification

class EngineSpecification extends Specification {

    def setup() {
        Engine engine = new Engine('4G63', 122)
    }

    def "test Creating and Engine"() {
        when:
            Engine engine = setup()
        then:
            engine.getEngineCode() == '4G63'
            engine.getDisplacement() == 122
    }

    def "test toString"() {
        when:
            Engine engine = setup()
        then:
            engine.toString() == '\t4G63\t\t\t122 CI'
    }

    def "equals success"() {
        when:
            Engine x = setup()
            Engine y = setup()
            Engine z = setup()

        then:
            // reflexive
            x.equals(x)

            // symmetric
            x.equals(y)
            y.equals(x)

            // transitive & consistent
            x.equals(y)
            y.equals(z)
            x.equals(z)
    }

    def "equals failure"() {
        when:
            Engine x = setup()
            Engine y = new Engine("4G63T", 122)
            Object z = new Object()

        then:
            !x.equals(y)
            !x.equals(y)
            !y.equals(x)
            !x.equals(null)
            !y.equals(null)
            !x.equals(z)
    }

    def "compareTo same object"() {
        when:
            Engine engine1 = setup()
            Engine engine2 = setup()
        then:
            engine1.compareTo(engine2) == 0
    }

    def "compareTo null object"() {
        when:
            Engine engine = setup()
            engine.compareTo(null)
        then:
            thrown(NullPointerException)
    }

    def "compareTo same engineCode but different displacement"() {
        when:
            Engine engine1 = setup()
            Engine engine2 = setup()
            engine2.setDisplacement(123)
        then:
            engine1.compareTo(engine2) == -1
            engine2.compareTo(engine1) == 1
    }

    def "compareTo engineCode and displacement are different"() {
        when:
            Engine engine1 = setup()
            Engine engine2 = setup()
            engine2.setDisplacement(123)
            engine2.setEngineCode("4G63T")
        then:
            engine1.compareTo(engine2) == -1
            engine2.compareTo(engine1) == 1
    }

    def "compareTo engineCode and displacement are different 2"() {
        when:
        Engine engine1 = setup()
        Engine engine2 = setup()
        engine2.setDisplacement(123)
        engine2.setEngineCode("4G80T")
        then:
        engine1.compareTo(engine2) == -1
        engine2.compareTo(engine1) == 1
    }

    def "compareTo engineCode and displacement are different 3"() {
        when:
        Engine engine1 = setup()
        Engine engine2 = setup()
        engine2.setDisplacement(123)
        engine2.setEngineCode("4G8")
        then:
        engine1.compareTo(engine2) == -1
        engine2.compareTo(engine1) == 1
    }

    def "compareTo engineCode and displacement are different 4"() {
        when:
        Engine engine1 = setup()
        Engine engine2 = setup()
        engine1.setEngineCode("85")
        engine2.setDisplacement(123)
        engine2.setEngineCode("84")
        then:
        engine1.compareTo(engine2) == 1
        engine2.compareTo(engine1) == -1
    }
}
