package com.assignments.assignment1

import spock.lang.Specification

class DistributorSpecification extends Specification {

    def setup() {
        return new Distributor("distributor", "123", "1234567890")
    }

    def "Test Create Distributor"() {
        when:
            Distributor distributor = setup()

        then:
            distributor.name == "distributor"
            distributor.address == "123"
            distributor.phone == "1234567890"
    }

    def "Test Add Movies (5 good and 1 bad)"() {
        when:
            Distributor distributor = setup()
            Movie movie = new Movie("name", "dirName", 2)

        then:
            distributor.addMovie(movie)
            distributor.addMovie(movie)
            distributor.addMovie(movie)
            distributor.addMovie(movie)
            distributor.addMovie(movie)
            !distributor.addMovie(movie)
    }

    def "Test Add Movies Overloaded method (5 good and 1 bad)"() {
        when:
            Distributor distributor = setup()

        then:
            distributor.addMovie("name", "dirName", 2, 100)
            distributor.addMovie("name", "dirName", 2, 100)
            distributor.addMovie("name", "dirName", 2, 100)
            distributor.addMovie("name", "dirName", 2, 100)
            distributor.addMovie("name", "dirName", 2, 100)
            !distributor.addMovie("name", "dirName", 2, 100)
    }

    def "Test catch instantiation error add movie overloaded method"() {
        when:
            Distributor distributor = setup()

        then:
            !distributor.addMovie("name", "dirname", 4, 100)
    }

    def "Test getting number of movies"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 1)

        then:
            distributor.totalNumMovies() == 1
    }

    def "Test findTotalEarnings"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 100)
            distributor.addMovie("name", "dirname", 2, 200)

        then:
            distributor.findTotalEarnings() == 300
    }

    def "Test comedyEarnings"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 100)
            distributor.addMovie("name", "dirname", 0, 200)

        then:
            distributor.comedyEarnings() == 200
    }

    def "Test addEarnings"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 100)
            distributor.addMovie("name2", "dirname", 0, 200)

            distributor.addEarnings("name", 100)
            distributor.addEarnings("name2", 100)

        then:
            // success
            distributor.addEarnings("name", 100)
            distributor.addEarnings("name2", 100)

            // failure
            !distributor.addEarnings("noname", 1)
    }

    def "Test getNumGenre"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 100)
            distributor.addMovie("name2", "dirname", 0, 200)
            distributor.addMovie("name2", "dirname", 0, 200)

        then:
            // good
            distributor.getNumGenre(0) == 2
            distributor.getNumGenre(1) == 0
            distributor.getNumGenre(2) == 1

            // bad
            distributor.getNumGenre(-1) == -1
            distributor.getNumGenre(3) == -1
    }

    def "Test calculateTax"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 100)

        then:
            Distributor.calculateTax(0.1, distributor) == 10
    }

    def "Test calculateTax Exception"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 100)
            Distributor.calculateTax(1.5, distributor)

        then:
            thrown(IllegalArgumentException)
    }

    /*
    *  The equals methods for spock and groovy can be changed to ==
    *  What I assume is happening here is that Polymorphism Dynamic Method Dispatch is choosing the method to use
    *  I think that is the term we learned in 141 but cannot remember, this is just what I was able to find from
    *  a google search
    */
    def "equals success"() {
        when:
            Distributor x = setup()
            Distributor y = setup()
            Distributor z = setup()

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
            Distributor x = setup()
            Distributor y = new Distributor("distributor2", "321", "0987654321")
            Object z = new Object()

        then:
            x != y
            x != y
            y != x
            x != null
            y != null
            x != z
    }

    def "Test toString"() {
        when:
            Distributor distributor = setup()
            distributor.addMovie("name", "dirname", 2, 100)

        then:
            distributor.toString() == "Name: distributor\n" +
                    "Address: 123\n" +
                    "Phone Number: 1234567890\n" +
                    "Number of Movies: 1\n" +
                    "---Movies---\n" +
                    "Movie Name: name\n" +
                    "Director: dirname\n" +
                    "Genre: 2\n" +
                    "Total Earnings: 100.0"
    }

    def "Test getters and setters"() {
        when:
            Distributor distributor = setup()
            distributor.setName("new name")
            distributor.setAddress("new address")
            distributor.setPhone("new phone")

        then:
            distributor.getName() == "new name"
            distributor.getAddress() == "new address"
            distributor.getPhone() == "new phone"
    }
}
