package exercises.week1;

public class Book {
    private String title;
    private int yearOfPublish;
    private String[] pages;

    public Book() {

    }

    public Book(String title, int yearOfPublish, String[] pages) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String[] getPages() {
        return pages;
    }

    public void setPages(String[] pages) {
        this.pages = pages;
    }

    public String toString() {
        return "Title: " + this.title + "\nYear: " + yearOfPublish + "\n";
    }
}
