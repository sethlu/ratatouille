/**
 * An example with field hiding in Java: That subclass may hide superclass's fields.
 * @author Zhuo Lu
 */

package inheritance;

class Insect {

    /**
     * The age of an insect in integer.
     */
    public int age = 0;
}

class Beetle extends Insect {

}

class LadyBug extends Beetle {

    /**
     * Lady bugs are special. They have doubly-typed ages.
     */
    public double age = 0.0;
}

public class FieldHiding {

    public static void main(String[] args) {
        testSuite1();
    }

    static void testSuite1() {
        // Test suite 1
        System.out.println("\nTest suite 1\n");

        // Create lady bugs differently statically typed...

        LadyBug l1 = new LadyBug();
        Beetle l2 = new LadyBug();
        Insect l3 = new LadyBug();

        // Inspect the initial age of them all

        System.out.print("LadyBug: ");
        System.out.println(l1.age);
        // Output: 0.0 // Note it is a double!

        System.out.print("Beetle: ");
        System.out.println(l2.age);
        // Output: 0   // Note the difference

        System.out.print("Insect: ");
        System.out.println(l3.age);
        // Output: 0
    }
}
