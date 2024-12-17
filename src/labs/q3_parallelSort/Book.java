package labs.q3_parallelSort;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String publisher;
    private int year;

    public Book(String title, String author, String publisher, int year) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.year, other.year); // Yıla göre sıralama
    }

    @Override
    public String toString() {
        return title + " - " + author + " (" + year + ")";
    }
}
