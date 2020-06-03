package com.assignments.assignment1;

import java.util.Arrays;

public class Distributor {
    private String name;
    private String address;
    private String phone;
    private Movie[] movies;
    private int numberOfMovies;

    public Distributor(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.movies = new Movie[5];
    }

    public boolean addMovie(Movie movie) {
        if(this.numberOfMovies >= movies.length) {
            return false;
        }

        this.movies[numberOfMovies] = movie;
        numberOfMovies++;
        return true;
    }

    // overloaded method to create a new movie and add it
    public boolean addMovie(String name, String directorName, int genre, double earnings) {
        Movie movie;
        try {
            movie = new Movie(name, directorName, genre);
        } catch (InstantiationException ex) {
            return false;
        }
        movie.addToEarnings(earnings);

        return this.addMovie(movie);
    }

    public int totalNumMovies() {
        return this.numberOfMovies;
    }

    // total earnings of all movies for distributor
    public double findTotalEarnings() {
        double totalEarnings = 0;
        for(int i = 0; i < numberOfMovies; i++) {
            totalEarnings += movies[i].getEarnings();
        }
        return totalEarnings;
    }

    public double comedyEarnings() {
        double totalEarnings = 0;
        for(int i = 0; i < numberOfMovies; i++) {
            if(movies[i].getGenre() == 0) {
                totalEarnings += movies[i].getEarnings();
            }
        }
        return totalEarnings;
    }

    public boolean addEarnings(String name, double earnings) {
        for(int i = 0; i < numberOfMovies; i++) {
            if(movies[i].getName().equalsIgnoreCase(name)) {
                movies[i].addToEarnings(earnings);
                return true;
            }
        }
        return false;
    }

    public int getNumGenre(int genre) {
        if(genre >= 3 || genre < 0) {
            return -1;
        } else {
            int genreCount = 0;
            for(int i = 0; i < numberOfMovies; i++) {
                if(movies[i].getGenre() == genre) {
                    genreCount++;
                }
            }
            return genreCount;
        }
    }

    /**
     *
     * @param taxRate - Tax rate in decimal form. E.g: use .15 for 15%
     * @param distributor - a distributor object
     * @return - the amount in tax as a double
     * @exception IllegalArgumentException - thrown when tax rate is greater than 1 or 100%
     */
    public static double calculateTax(double taxRate, Distributor distributor) {
        if(taxRate > 1.00) {
            throw(new IllegalArgumentException());
        }
        return distributor.findTotalEarnings() * taxRate;
    }

    @Override
    public boolean equals(Object obj) {
        // Makes sure obj is of Movie class before casting
        if(this.getClass() != obj.getClass()) {
            return false;
        }

        Distributor distributor = (Distributor) obj;
        return this.name.equalsIgnoreCase(distributor.name);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String part1 = "Name: " + this.name + "\nAddress: " + this.address + "\nPhone Number: " + this.phone +
                "\nNumber of Movies: " + this.numberOfMovies + "\n---Movies---";
        String part2 = "\nTotal Earnings: " + this.findTotalEarnings();

        stringBuilder.append(part1);
        Movie[] movies = this.getMovies();
        for(int i = 0; i < movies.length; i++) {
            stringBuilder.append("\n");
            stringBuilder.append(movies[i]);
        }
        stringBuilder.append(part2);

        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Movie[] getMovies() {
        return Arrays.copyOf(movies, numberOfMovies);
    }
}
