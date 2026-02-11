package collections_2;

import java.util.Random;
public class Exercise3 {
    public static void main(String[] args) {
        int sumA = 1000;
        int sumB = 0;
        int iteration = 0;

        Random random = new Random();
        while (sumA > sumB){
            iteration++;


            sumA += random.nextInt(10);
            sumB += random.nextInt(50);

            System.out.println("Iteration #" + iteration + " -> sumA: " + sumA + " | sumB: " + sumB);

        }

        System.out.println("\nRace finished!");
        System.out.println("Final state: sumA = " + sumA + ", sumB = " + sumB);

        runAdditionalTask();

    }
    public static void runAdditionalTask() {
        System.out.println("Numbers divisible by 3 (0-100)");
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
