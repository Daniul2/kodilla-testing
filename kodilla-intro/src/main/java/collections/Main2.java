package collections;

public class Main2 {

    public static void main(String[] args) {

        int numberPrimitive = 42;
        Integer numberWrapper = numberPrimitive; // Autoboxing
        System.out.println("int vs Integer:");
        System.out.println("Primitive value: " + numberPrimitive);
        System.out.println("Wrapper value: " + numberWrapper);
        System.out.println("Are they equal? " + (numberPrimitive == numberWrapper));
        System.out.println();

        double doublePrimitive = 3.14;
        Double doubleWrapper = doublePrimitive; // Autoboxing
        System.out.println("double vs Double:");
        System.out.println("Primitive value: " + doublePrimitive);
        System.out.println("Wrapper value: " + doubleWrapper);
        System.out.println("Are they equal? " + (doublePrimitive == doubleWrapper));
        System.out.println();

        boolean boolPrimitive = true;
        Boolean boolWrapper = boolPrimitive; // Autoboxing
        System.out.println("boolean vs Boolean:");
        System.out.println("Primitive value: " + boolPrimitive);
        System.out.println("Wrapper value: " + boolWrapper);
        System.out.println("Are they equal? " + (boolPrimitive == boolWrapper));
        System.out.println();

        System.out.println("Comparison completed successfully!");
    }
}


