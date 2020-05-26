package com.exercises.week2;

public class Point {

    // instance variables
    private double x;
    private double y;

    // constructors

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // getters and setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {

        String output;

        output = "(" + this.x;
        output += "," + this.y + ")";

        return output;
    }

    // a method to rotate the point 90 degrees
    // in clockwise direction.
    // For a 90-degree clockwise rotation, the new x is
    // the original y and the new y is -1 times the original x.

    public void rotate90() {

        double temp = this.x;
        this.x = this.y;
        this.y = -1 * temp;
    }

    // shift

    public void shift(double xAmount, double yAmount) {

        this.x = this.x + xAmount;
        this.y = this.y + yAmount;
    }

    // equals
    public boolean equals(Object other) {
        boolean output = false;
        if (other instanceof Point) {
            Point otherPoint = (Point) other;
            if (this.x == otherPoint.x && this.y == otherPoint.y)
                output = true;
        } else
            output = false;
        return output;
    }

    public static double distance(Point p1, Point p2) {

        double output = 0;

        double diff1 = (p1.getX() - p2.getX()) * (p1.getX() - p2.getX());
        double diff2 = (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
        double sum = diff1 + diff2;
        output = Math.sqrt(sum);

        return output;

    }

    public static Point midPoint(Point p1, Point p2) {
        double midX = p1.x / 2 + p2.x / 2;
        double midY = p1.y / 2 + p2.y / 2;


        Point output = new Point(midX, midY);
        return output;

    }

}

