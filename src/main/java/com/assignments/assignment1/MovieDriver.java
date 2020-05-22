package com.assignments.assignment1;

public class MovieDriver {
    public static void main(String[] args) {
        try {
            Movie lotr1 = new Movie("LOTR: The Fellowship of the Ring", "Peter Jackson", 2);
            Movie lotr2 = new Movie("LOTR: The Two Towers", "Peter Jackson", 2);
            Movie lotr3 = new Movie("LOTR: The Return of the King", "Peter Jackson", 2);

            Movie sw4 = new Movie("Star Wars: Episode IV - A New Hope", "George Lucas", 2);
            Movie sw5 = new Movie("Star Wars: Episode V - The Empire Strikes Back", "Irvin Kershner",
                    2);
            Movie sw6 = new Movie("Star Wars: Episode VI - Return of the Jedi", "Richard Marquand",
                    2);

            Distributor d1 = new Distributor("New Line Cinema",
                    "4000 Warner Blvd, Burbank, California , United States", "(818) 954-6000");

            Distributor d2 = new Distributor("20th Century Studios",
                    "Fox Studio Lot Building 88, 10201 West Pico Boulevard," +
                            "Century City, Los Angeles, California, United States", "1 (888) 223-4369");

            d1.addMovie(lotr1);
            d1.addMovie(lotr2);
            d1.addMovie(lotr3);
            d1.addMovie(sw4);
            d1.addMovie(sw5);
            d1.addMovie(sw6);

            d2.addMovie(sw4);
            d2.addMovie(sw5);
            d2.addMovie(sw6);

            System.out.println(d1.toString()+"\n");
            System.out.println(d2.toString());

        } catch (InstantiationException ex) {
            System.out.println("Error creating movie object, genre parameter out of range!");
        } catch (Exception ex) {
            System.out.println("Unknown error occurred!");
        }

    }
}
