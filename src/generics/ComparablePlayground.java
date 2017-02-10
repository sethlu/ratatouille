/**
 * Trying Comparable interface featuring inference, wildcard generics, etc.
 * @author Zhuo Lu
 */

import java.util.Collection;
import java.util.LinkedList;

class ComparablePlayground {

    static class Animal implements Comparable<Animal> {
        /** Weight of an animal */
        int weight;

        /** Color of an animal */
        String color;

        Animal(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        @Override
        public int compareTo(Animal o) {
            return this.weight - o.weight;
        }
    }

    static class Lion extends Animal {

        Lion(int weight) {
            // If using `Animal` instead of super, it cannot be resolved as a method
            super(weight, "yellow");
        }
    }

    static class Elephant extends Animal {

        Elephant(int weight) {
            // If using `Animal` instead of super, it cannot be resolved as a method
            super(weight, "grey");
        }
    }

    static void displayAnimal(Animal a) {
        System.out.println("Color: " + a.color + "; weight: " + a.weight);
    }

    static void displayStaticAnimalType(Animal a) {
        System.out.println("Animal");
    }

    static void displayStaticAnimalType(Lion a) {
        System.out.println("Lion");
    }

    static void displayStaticAnimalType(Elephant a) {
        System.out.println("Elephant");
    }

    private static <T extends Animal> void displayBox(Collection<T> as) {
        System.out.println("-----------");
        for (T a : as) {
            displayAnimal(a);
        }
        System.out.println("-----------");
    }

    /**
     * Compares the two comparable objects and returns the greater, if two not the same, or the first.
     *
     * Notes:
     * - `extends Object` is necessary to make the return type a subtype of `Object` rather than of a `Comparable`.
     *   - If removed, the return value needs to be casted to an `Animal` or be a `Comparable`.
     *   - We don't use `extends Animal` here because `Comparable<? super T>` sets a lower bound.
     * - `Comparable<? super T>` is necessary to have the generic type `T` be a `Comparable`, which may be implemented to compare supertypes.
     *   For example, the Animal class implementing Comparable, Lion and Element may use `compareTo()` method for comparison of supertypes.
     *   - If removed, `compareTo()` method call wouldn't be ensured exist.
     *   - T, also the return type of the method, is a shared superclass of `o1` and of `o2`.
     *     E.g. If `o1` is a statically `Lion` typed and `o2` the same, then T is `Lion`.
     *          If `o1` is a statically `Elephant` typed and `o2` `Elephant`, the T is `Animal`.
     * - This method should work will all Comparable-interfaced Object instances.
     *
     */
    static <T extends Object & Comparable<? super T>> T more(T o1, T o2) {
        return o1.compareTo(o2) >= 0 ? o1 : o2;
    }

    /**
     * Moves animals from a linked list to another.
     */
    static <T extends Animal> void moveAnimals(LinkedList<? extends T> from, LinkedList<? super T> to) {
        while (from.size() > 0) {
            to.addLast(from.removeFirst());
        }
    }

    public static void main(String[] args) {
        Lion l1 = new Lion(10);
        Lion l2 = new Lion(30);
        Elephant e1 = new Elephant(100);

        // Test suite 1

        System.out.println("\nTest suite 1\n");
        displayStaticAnimalType(more(l1, e1));
        // Output: Animal
        displayAnimal(more(l1, e1));
        // Output: Color: grey; weight: 100

        // Test suite 2

        System.out.println("\nTest suite 2\n");
        displayStaticAnimalType(more(l1, l2));
        // Output: Lion
        displayAnimal(more(l1, l2));
        // Color: yellow; weight: 30

        // Test suite 3

        System.out.println("\nTest suite 3\n");

        LinkedList<Animal> boxA = new LinkedList<>();
        LinkedList<Animal> boxB = new LinkedList<>();

        boxA.addLast(l1);
        boxA.addLast(l2);
        boxA.addLast(e1);

        System.out.println("Before moving:\nBox A:");
        displayBox(boxA);
        // Output: -----------
        //         Color: yellow; weight: 10
        //         Color: yellow; weight: 30
        //         Color: grey; weight: 100
        //         -----------
        System.out.println("Box B:");
        displayBox(boxB);
        // Output: -----------
        //         -----------

        moveAnimals(boxA, boxB);

        System.out.println("\nAfter moving:\nBox A:");
        displayBox(boxA);
        // Output: -----------
        //         -----------
        System.out.println("Box B:");
        displayBox(boxB);
        // Output: -----------
        //         Color: yellow; weight: 10
        //         Color: yellow; weight: 30
        //         Color: grey; wei

    }
}