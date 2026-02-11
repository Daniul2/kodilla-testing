package collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {

    public static void main(String[] args) {
        System.out.println("--- Main Task: Student Grades Map ---");

        HashMap<String, List<Integer>> studentGrades = new HashMap<>();

        addGrade(studentGrades, "Anna Kowalska", 5);
        addGrade(studentGrades, "Anna Kowalska", 4);
        addGrade(studentGrades, "Anna Kowalska", 5);
        addGrade(studentGrades, "Jan Nowak", 3);
        addGrade(studentGrades, "Jan Nowak", 3);
        addGrade(studentGrades, "Piotr Zieliński", 4);
        addGrade(studentGrades, "Piotr Zieliński", 5);
        addGrade(studentGrades, "Piotr Zieliński", 6);
        addGrade(studentGrades, "Katarzyna Wójcik", 2);
        addGrade(studentGrades, "Katarzyna Wójcik", 3);
        addGrade(studentGrades, "Katarzyna Wójcik", 2);
        addGrade(studentGrades, "Michał Dąbrowski", 5);

        System.out.println("\n--- Student Averages ---");
        for (Map.Entry<String, List<Integer>> entry : studentGrades.entrySet()) {
            String studentName = entry.getKey();
            List<Integer> grades = entry.getValue();

            if (grades.isEmpty()) {
                System.out.println(studentName + ": No grades.");
                continue;
            }

            double sum = 0;
            for (Integer grade : grades) {
                sum += grade;
            }
            double average = sum / grades.size();

            System.out.printf("%s: %.2f (Grades: %s)%n", studentName, average, grades);
        }

        System.out.println("\n--- Additional Task: Swap without Helper ---");

        int a = 5;
        int b = 7;

        System.out.println("Before swap: a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swap:   a = " + a + ", b = " + b);

        int x = 10;
        int y = 0;

        System.out.println("\nBefore swap: x = " + x + ", y = " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap:   x = " + x + ", y = " + y);
    }

    private static void addGrade(HashMap<String, List<Integer>> studentGrades, String studentName, int grade) {
        studentGrades.computeIfAbsent(studentName, k -> new ArrayList<>()).add(grade);
    }
}
