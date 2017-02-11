/**
 * Experiments with inheritance around interfaces and classes.
 * @author Zhuo Lu
 *
 * See:
 *
 * - src/static_dynamic_binding/BindingPlayground
 *   - A few examples on the static and dynamic binding in Java may be found there.
 * - http://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
 *   - Good clarification on that package-private members from a super class could be inherited into a subclass under a same package--doesn't have to be protected to do so.
 * - https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 *   - Useful clarification on overriding and hiding with respect to subclass/superclass instance/static methods towards the end of the pagegit .
 */

package inheritance;

class InheritancePlayground {

    interface Alarm {

        /** Alarm the surroundings */
        void alarm();
    }

    interface Light {

        /** Shine! */
        void shine();
    }

    static class Robot {

        // Test suite 1

        /** Model of the robot series */
        static String model = "M001";

        /** The name of the class */
        String className = "Robot";

        /** The color of the robot */
        String color = "grey";

        // Test suite 2-a

        void setUniversalModel(String m) {
            model = m;
        }

        // Test suite 3

        private String nickName = "Roooooooooob";

        /**
         *
         * Note: Only class method has access to private member
         */
        void setNickName(String name) {
            nickName = name;
        }

        String nickName() {
            return nickName;
        }
    }

    static class SoundEnabledRobot extends Robot implements Alarm {

        // Test suite 1

        /**
         * Model of this robot series
         * Note: The static member from the parent class cannot be overridden!!
         * @see InheritancePlayground#main test suite 2
         */
        static String model = "M002";

        String className = "SoundEnabledRobot";

        /** Not just able to make noise, its color looks good too */
        String color = "yellow";

        @Override
        public void alarm() {
            System.out.println(className + " now making noise!!!");
        }

        // Test 2-b

        void setUniversalModelAlt(String m) {
            model = m;
        }
    }

    public static void main(String[] args) {
        testSuite1();
        testSuite2();
        testSuite3();
    }

    static void testSuite1() {
        Robot r = new Robot();
        SoundEnabledRobot ser = new SoundEnabledRobot();

        // Test suite 1
        System.out.println("\nTest suite 1\n");

        // r.alarm(); // This will not compile as `alarm()` couldn't be resolved in the class `Robot`, the static type
        ser.alarm();
    }

    static void testSuite2() {
        SoundEnabledRobot ser = new SoundEnabledRobot();

        // Test suite 2-a

        System.out.println("\nTest suite 2-a\n");

        System.out.println("Before setting universal model on ser:\n");
        System.out.println("Robot.model: " + Robot.model);
        // Output: Robot.model: M001
        System.out.println("SoundEnabledRobot.model: " + SoundEnabledRobot.model);
        // Output: SoundEnabledRobot.model: M002

        ser.setUniversalModel("M003");

        System.out.println("\nAfter setting universal model on ser:\n");
        System.out.println("Robot.model: " + Robot.model);
        // Output: Robot.model: M003
        System.out.println("SoundEnabledRobot.model: " + SoundEnabledRobot.model);
        // Output: SoundEnabledRobot.model: M002

        // Test suite 2-b

        System.out.println("\nTest suite 2-b\n");

        System.out.println("Before setting universal model on ser:\n");
        System.out.println("Robot.model: " + Robot.model);
        // Output: Robot.model: M003
        System.out.println("SoundEnabledRobot.model: " + SoundEnabledRobot.model);
        // Output: SoundEnabledRobot.model: M002

        ser.setUniversalModelAlt("M004"); // Note the difference

        System.out.println("\nAfter setting universal model on ser:\n");
        System.out.println("Robot.model: " + Robot.model);
        // Output: Robot.model: M003
        System.out.println("SoundEnabledRobot.model: " + SoundEnabledRobot.model);
        // Output: SoundEnabledRobot.model: M004
    }

    static void testSuite3() {
        Robot r = new Robot();
        SoundEnabledRobot ser = new SoundEnabledRobot();

        // Test suite 3
        System.out.println("\nTest suite 3\n");

        System.out.println("Before setting nickname of instance: " + ser.nickName());
        // Output: Before setting nickname of instance: Roooooooooob
        ser.setNickName("Rob");
        System.out.println("After setting nickname of instance: " + ser.nickName());
        // Output: Before setting nickname of instance: Rob
        // Note: Though the `nickName` is private in the `Robot` class, thus not inherited in `SoundEnabledRobot`, the setter/getter defined in the `Robot` class provides access to set and get the privately accessible value.
    }
}
