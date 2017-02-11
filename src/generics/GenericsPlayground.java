/**
 * Experiments with wildcard generics.
 * @author Zhuo Lu
 *
 * Read more:
 * - http://docs.oracle.com/javase/8/docs/technotes/guides/language/generics.html
 * - http://web.cs.iastate.edu/~smkautz/cs228f10/examples/generics/GenericSortingExample.java
 * - http://web.cs.iastate.edu/~smkautz/cs228f10/examples/generics/generics_notes.pdf
 *   - In which is clarification on preference of using `Comparable<? super T>` rather than `Comparable<T>`.
 */

package generics;

class GenericsPlayground {

    static class Vehicle implements Comparable<Vehicle> {

        /** Weight of the vehicle */
        int weight;

        @Override
        public int compareTo(Vehicle o) {
            return weight - o.weight;
        }

        Vehicle() {
            this(10);
        }

        Vehicle(int w) {
            weight = w;
        }
    }

    static class Car extends Vehicle {

        Car(int w) {
            super(w);
        }
    }

    static void displayVehicle(Vehicle o) {
        System.out.println("Vehicle: " + o.weight);
    }

    static void displayVehicle(Car o) {
        System.out.println("Car: " + o.weight);
    }

    static <T extends Object & Comparable<T>> T heavier(T o1, T o2) {
        return o1.compareTo(o2) >= 0 ? o1 : o2;
    }

    static <T extends Object & Comparable<? super T>> T heavierAlt(T o1, T o2) {
        return o1.compareTo(o2) >= 0 ? o1 : o2;
    }

    public static void main(String[] args) {
        testSuite1();
        testSuite2();
    }

    static void testSuite1() {
        // Test suite 1-a
        System.out.println("\nTest suite 1-a\n");
        displayVehicle(heavier(new Vehicle(10), new Vehicle(20)));
        // Output: Vehicle: 20

        // Test suite 1-b
        System.out.println("\nTest suite 1-b\n");
        displayVehicle(heavier(new Vehicle(10), new Car(20)));
        // Output: Vehicle: 20

        // Test suite 1-c
        System.out.println("\nTest suite 1-c\n");
        displayVehicle(heavier(new Car(10), new Vehicle(20)));
        // Output: Vehicle: 20

        // Test suite 1-d
        System.out.println("\nTest suite 1-d\n");
        displayVehicle(heavier(new Car(10), new Car(20)));
        // Output: Vehicle: 20
    }

    static void testSuite2() {
        // Test suite 2-a
        System.out.println("\nTest suite 2-a\n");
        displayVehicle(heavierAlt(new Vehicle(10), new Vehicle(20)));
        // Output: Vehicle: 20

        // Test suite 2-b
        System.out.println("\nTest suite 2-b\n");
        displayVehicle(heavierAlt(new Vehicle(10), new Car(20)));
        // Output: Vehicle: 20

        // Test suite 2-c
        System.out.println("\nTest suite 2-c\n");
        displayVehicle(heavierAlt(new Car(10), new Vehicle(20)));
        // Output: Vehicle: 20

        // Test suite 2-d
        System.out.println("\nTest suite 2-d\n");
        displayVehicle(heavierAlt(new Car(10), new Car(20)));
        // Output: Car: 20
        // Note the difference to test suite 1-d where the output is "Vehicle: 20".
        // The `Comparable<? super T>` of `heavierAlt()` allows the return type to return `Car` although Comparable is only implemented on `Vehicle`.
    }
}
