package com.assignments.assignment1
import spock.lang.*

class MovieSpecification extends Specification {

    def setup() {
        return new Movie("Name", "Director Name", 2)
    }

    def "Create Movie"() {
        when:
            Movie movie = setup()
        then:
            movie.name == "Name"
            movie.directorName == "Director Name"
            movie.genre == 2
    }

    def "Failed to Create Movie"() {
        when:
            new Movie("Name", "Director Name", 4)
        then:
            thrown(InstantiationException)
    }

    def "Add earnings"() {
        when:
            Movie movie = setup()
            movie.addToEarnings(100.00)
        then:
            movie.getEarnings() == 100.00
    }

    /*
    *  The equals methods for spock and groovy can be changed to ==
    *  What I assume is happening here is that Polymorphism Dynamic Method Dispatch is choosing the method to use
    *  I think that is the term we learned in 141 but cannot remember, this is just what I was able to find from
    *  a google search
    */
    def "equals success"() {
        when:
            Movie x = setup()
            Movie y = setup()
            Movie z = setup()
        then:
            // reflexive
            x == x

            // symmetric
            x == y
            y == x

            // transitive & consistent
            x == y
            y == z
            x == z
    }

    def "equals failure"() {
        when:
            Movie x = setup()
            Movie y = new Movie("Name", "Director Name", 1)
            Object z = new Object()

        then:
            x != y
            x != y
            y != x
            x != null
            y != null
            x != z
    }

    def "toString/setter/getter tests"() {
        when:
            Movie movie = setup()
            movie.setName("new name")
            movie.setDirectorName("new")
            movie.setGenre(1)
        then:
            movie.toString() == "Movie Name: " + movie.getName() +
                    "\nDirector: " + movie.getDirectorName() +
                    "\nGenre: " + movie.getGenre()
    }
}
