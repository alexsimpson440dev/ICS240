package com.assignments.assignment1;

public class Movie {
    private String name;
    private String directorName;
    private double earnings;
    private int genre;

    /**
     *
     * @param name - name of the movie
     * @param directorName - directors name
     * @param genre - genre of the movie (0 - comedy, 1 - action, 2 - fiction)
     * @throws InstantiationException - exception when class is instantiated with genre value out of bounds
     */
    public Movie(String name, String directorName, int genre) throws InstantiationException {
        if(genre < 0 || genre >= 3) {
            throw new InstantiationException();
        }
        this.name = name;
        this.directorName = directorName;
        this.genre = genre;
    }

    public void addToEarnings(double amount) {
        this.earnings += amount;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        // Makes sure obj is of Movie class before casting
        if(this.getClass() != obj.getClass()) {
            return false;
        }

        Movie movie = (Movie) obj;
        return this.name.equalsIgnoreCase(movie.name) && this.directorName.equalsIgnoreCase(movie.directorName) &&
                this.genre == movie.genre;
    }

    @Override
    public String toString() {
        return "Movie Name: " + this.name +
                "\nDirector: " + this.directorName +
                "\nGenre: " + this.genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public double getEarnings() {
        return earnings;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
}
