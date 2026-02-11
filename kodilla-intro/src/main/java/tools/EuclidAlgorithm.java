package tools;
public class EuclidAlgorithm {
    public static void main(String[] args) {
        int a = 168;
        int b = 64;

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }

        System.out.println("The GCD is: " + a);
    }
}
