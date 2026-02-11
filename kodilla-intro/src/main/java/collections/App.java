package collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        calculateAverageWithoutExtremes();
        System.out.println("----------");
        printBooksFromYear2000();
    }

    private static void calculateAverageWithoutExtremes() {
        List<Integer> grades = new ArrayList<>();

        grades.add(3);
        grades.add(3);
        grades.add(4);
        grades.add(4);
        grades.add(4);
        grades.add(5);
        grades.add(5);
        grades.add(5);
        grades.add(6);

        System.out.println("Grades: " + grades);

        if (grades.size() < 3) {
            System.out.println("Not enough grades to calculate average.");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            if (grade < min) {
                min = grade;
            }
            if (grade > max) {
                max = grade;
            }
        }

        System.out.println("Min grade: " + min);
        System.out.println("Max grade: " + max);

        int sum = 0;
        boolean minSkipped = false;
        boolean maxSkipped = false;

        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);

            if (!minSkipped && grade == min) {
                minSkipped = true;
                continue;
            }

            if (!maxSkipped && grade == max) {
                maxSkipped = true;
                continue;
            }

            sum += grade;
        }

        int count = grades.size() - 2;
        double average = (double) sum / count;

        System.out.println("Average without extreme grades: " + average);
    }

    private static void printBooksFromYear2000() {
        LinkedList<Book> books = new LinkedList<>();

        books.add(new Book("The Great Gatsby", 1925));
        books.add(new Book("Harry Potter and the Philosopher's Stone", 1997));
        books.add(new Book("Clean Code", 2008));
        books.add(new Book("Effective Java", 2001));
        books.add(new Book("The Witcher: The Last Wish", 1993));
        books.add(new Book("Java Fundamentals", 2014));

        System.out.println("Books published in or after 2000:");

        for (Book book : books) {
            if (book.getYear() >= 2000) {
                System.out.println(book);
            }
        }
    }
}

class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" (" + year + ")";
    }
}
