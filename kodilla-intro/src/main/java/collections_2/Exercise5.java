package collections_2;

import java.util.*;

class Book5 {
    private String author;
    private String title;

    public Book5(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book5 book = (Book5) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }
}

public class Exercise5 {
    public static void main(String[] args) {

        System.out.println("--- PART 1---");
        List<Book5> bookList = new LinkedList<>();
        int listSize = 250000;

        for (int i = 0; i < listSize; i++) {
            bookList.add(new Book5("Author " + i, "Title " + i));
        }
        System.out.println("LinkedList initialized with " + bookList.size() + " books.");

        Book5 firstBook = bookList.get(0);
        long start = System.nanoTime();
        bookList.remove(firstBook);
        long end = System.nanoTime();
        System.out.println("Searching and removing first element took: " + (end - start) + " ns");

        Book5 lastBook = bookList.get(bookList.size() - 1);
        start = System.nanoTime();
        bookList.remove(lastBook);
        end = System.nanoTime();
        System.out.println("Searching and removing last element took: " + (end - start) + " ns");

        start = System.nanoTime();
        bookList.add(0, new Book5("New Author", "New Title"));
        end = System.nanoTime();
        System.out.println("Inserting at the beginning took: " + (end - start) + " ns");

        start = System.nanoTime();
        bookList.add(new Book5("Last Author", "Last Title"));
        end = System.nanoTime();
        System.out.println("Inserting at the end took: " + (end - start) + " ns");


        System.out.println("\n--- PART 2 ---");
        Map<String, Book5> bookMap = new HashMap<>();
        int mapSize = 100000;

        for (int i = 0; i < mapSize; i++) {
            bookMap.put("Key" + i, new Book5("Author " + i, "Title " + i));
        }
        System.out.println("HashMap initialized with " + bookMap.size() + " elements.");

        String searchKey = "Key" + (mapSize / 2);
        start = System.nanoTime();
        Book5 foundBook = bookMap.get(searchKey);
        end = System.nanoTime();
        System.out.println("Searching by key took: " + (end - start) + " ns");

        start = System.nanoTime();
        bookMap.put("NewKey", new Book5("Fresh Author", "Fresh Title"));
        end = System.nanoTime();
        System.out.println("Adding new element to Map took: " + (end - start) + " ns");

        start = System.nanoTime();
        bookMap.remove("NewKey");
        end = System.nanoTime();
        System.out.println("Removing element by key took: " + (end - start) + " ns");
    }
}

