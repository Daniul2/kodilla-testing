package collections;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[20];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 2 + 1;
        }

        int sum = 0;

        System.out.println("Elements of the array:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element [" + i + "] = " + numbers[i]);
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;

        System.out.println("-------------------------");
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average value: " + average);
    }
}
