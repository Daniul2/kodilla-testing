package collections_2;

import java.util.*;

class Book {
    private String title;
    private String author;
    private int releaseYear;

    public Book(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, releaseYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book5 book = (Book5) o;
        return releaseYear == book.releaseYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }
}

public class Main {
    public static void main(String[] args) {

        Set<Book5> books = new HashSet<>();

        books.add(new Book5("The Witcher: The Last Wish", "Andrzej Sapkowski", 1993));
        books.add(new Book5("Clean Code", "Robert C. Martin", 2008));
        books.add(new Book5("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book5("Dune", "Frank Herbert", 1965));
        books.add(new Book5("Project Hail Mary", "Andy Weir", 2021));
        books.add(new Book5("Clean Code", "Robert C. Martin", 2008));

        System.out.println("Books published before 2010:\n");

        for (Book5 book : books) {
            if (book.getReleaseYear() < 2010) {
                System.out.println(book.getTitle() + " (" + book.getReleaseYear() + ")");
            }
        }
    }
}
