/**
 * Binding playground demonstrating the static and dynamic binding in Java.
 * @author Zhuo Lu
 *
 * Notes:
 *
 * - When a method is invoked (§15.12), the number of actual arguments (and any explicit type arguments) and the
 *   compile-time types of the arguments are used, at compile time, to determine the signature of the method that will
 *   be invoked (§15.12.2). If the method that is to be invoked is an instance method, the actual method to be invoked
 *   will be determined at run time, using dynamic method lookup (§15.12.4). [2]
 * - Overriding: The implementation to be executed is decided at run-time and decision is made according to the object
 *               used for call. Note that signatures of both methods must be same. [1]
 * - Overloading: This feature allows different methods to have same name, but different signatures, especially number
 *                of input parameters and type of input parameters. [1]
 * - Hiding: Parent class methods that are static are not part of a child class.
 *
 * Related readings:
 *
 * 1. GeeksforGeeks: http://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/
 * 2. Java Language Specification Overloading: http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.9
 *
 */

package static_dynamic_binding;

class BindingPlayground {

    static class Animal {
        void speak() {
            System.out.println("Animal speaks");
        }
    }

    static class Cat extends Animal {
        @Override
        void speak() {
            System.out.println("Cat meows");
        }
    }

    static class Tiger extends Cat {
        @Override
        void speak() {
            System.out.println("Tiger roars");
        }
    }

    static void speak(Animal ref) {
        System.out.println("Animal speaks");
    }

    static void speak(Cat ref) {
        System.out.println("Cat meows");
    }

    static void speak(Tiger ref) {
        System.out.println("Tiger roars");
    }

    void speakNonStatic(Animal ref) {
        System.out.println("Animal speaks");
    }

    void speakNonStatic(Cat ref) {
        System.out.println("Cat meows");
    }

    void speakNonStatic(Tiger ref) {
        System.out.println("Tiger roars");
    }

    public static void main(String[] args) {
        BindingPlayground playground = new BindingPlayground();
        Animal animalRef;
        Cat catRef;
        Tiger tigerRef;

        // Test suite 1

        animalRef = new Animal();
        // catRef = new Animal(); // NB: Cannot do this
        // tigerRef = new Animal(); // NB Cannot do this

        System.out.println("\nTest suite 1-a\n");
        animalRef.speak();

        System.out.println("\nTest suite 1-b\n");
        speak(animalRef);

        System.out.println("\nTest suite 1-c\n");
        playground.speakNonStatic(animalRef);

        // Test suite 2

        animalRef = new Cat();
        catRef = new Cat();
        // tigerRef = new Cat(); // NB: Cannot do this

        System.out.println("\nTest suite 2-a\n");
        animalRef.speak();
        catRef.speak();

        System.out.println("\nTest suite 2-b\n");
        speak(animalRef);
        speak(catRef);

        System.out.println("\nTest suite 2-c\n");
        playground.speakNonStatic(animalRef);
        playground.speakNonStatic(catRef);

        // Test suite 3

        animalRef = new Tiger();
        catRef = new Tiger();
        tigerRef = new Tiger();

        System.out.println("\nTest suite 3-a\n");
        animalRef.speak();
        catRef.speak();
        tigerRef.speak();

        System.out.println("\nTest suite 3-b\n");
        speak(animalRef);
        speak(catRef);
        speak(tigerRef);

        System.out.println("\nTest suite 3-c\n");
        playground.speakNonStatic(animalRef);
        playground.speakNonStatic(catRef);
        playground.speakNonStatic(tigerRef);

        // Test suite 4

        System.out.println("\nTest suite 4-a\n");
        speak(new Animal());
        speak(new Cat());
        speak(new Tiger());

        System.out.println("\nTest suite 4-b\n");
        playground.speakNonStatic(new Animal());
        playground.speakNonStatic(new Cat());
        playground.speakNonStatic(new Tiger());

    }
}
