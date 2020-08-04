package com.assignments.assignment2

import spock.lang.Specification

class EngineNodeSpecification extends Specification {
    def setup() {
        Engine e1 = new Engine("A", 1)
        EngineNode head = new EngineNode(e1, null)
    }

    def "test addNodeAfter"() {
        when:
            EngineNode head = setup()
        then:
            head.addNodeAfter(new Engine("B", 2))
    }

    def "test removeNodeAfter"() {
        when:
            EngineNode head = setup()
            head.addNodeAfter(new Engine("B", 2))
        then:
            head.removeNodeAfter()
    }

    def "test display"() {
        when:
            EngineNode head = setup()
        then:
            EngineNode.display(head)
    }

    def "test listPosition"() {
        when:
            EngineNode head = setup()
            head.addNodeAfter(new Engine("b", 2))
        then:
            EngineNode.listPosition(head, 2) == head.getLink()
    }

    def "test list length"() {
        when:
            EngineNode head = setup()
        then:
            EngineNode.listLength(head) == 1
    }

    def "test listSearch"() {
        when:
            EngineNode head = setup()
            head.addNodeAfter(new Engine("b", 2))
        then:
            EngineNode.listSearch(head, head.getLink().getData()) == head.getLink()
    }

    def "test listSearch error/null"() {
        when:
            EngineNode head = setup()
            head.setData(new Engine("b", 5))
            head.setLink(null)
            head.addNodeAfter(new Engine("b", 2))
        then:
            EngineNode.listSearch(head, new Engine("4", 5)) == null
    }
}
