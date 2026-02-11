package collections_2;

import java.util.ArrayDeque;
import java.util.Deque;

class Book2{
    private String title;
    private String author;
    private int year;

    public Book2(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" - " + author + " (" + year + ")";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        Deque<Book5>bookStack = new ArrayDeque<>();

        bookStack.push(new Book5("The Witcher", "Andrzej Sapkowski", 1993));
        bookStack.push(new Book5("Clean Code", "Robert C. Martin", 2008));
        bookStack.push(new Book5("The Hobbit", "J.R.R. Tolkien", 1937));
        bookStack.push(new Book5("1984", "George Orwell", 1949));
        bookStack.push(new Book5("Brave New World", "Aldous Huxley", 1932));

        System.out.println("Stack created. Current size: " + bookStack.size());

        Book5 lastRemovedBook = null;

        System.out.println("\nRemoving books from the stack...");

        while (!bookStack.isEmpty()){
            lastRemovedBook = bookStack.poll();
            System.out.println("Removed: " + lastRemovedBook);
        }
        System.out.println("\nAll books removed. Current size: " + bookStack.size());
        System.out.println("The last book removed from the stack was:\n" + lastRemovedBook);

    }
}
