/**
 * Experiments with inheritance around interfaces and classes.
 * @author Zhuo Lu
 *
 * See:
 *
 * static-dynamic-binding/BindingPlayground
 * - A few examples on the static and dynamic binding in Java may be found there.
 */

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

        /** Model of the robot series */
        static String model = "M001";

        /** The name of the class */
        String className = "Robot";

        /** The color of the robot */
        String color = "grey";

        public void setUniversalModel(String m) {
            model = m;
        }
    }

    static class SoundEnabledRobot extends Robot implements Alarm {

        /**
         * Model of this robot series
         * Note: The static member from the parent class cannot be overridden!!
         * @see InheritancePlayground#main test suite 2
         */
        static String model = "M002";

        String className = "SoundEnabledRobot";

        /** Not just able to make noise, its color looks good too */
        String color = "yellow";

        public void alarm() {
            System.out.println(className + " now making noise!!!");
        }

        public void setUniversalModelAlt(String m) {
            model = m;
        }
    }

    public static void main(String[] args) {
        Robot r = new Robot();
        SoundEnabledRobot ser = new SoundEnabledRobot();

        // Test suite 1

        System.out.println("\nTest suite 1\n");

        // r.alarm(); // This will not compile as `alarm()` couldn't be resolved in the class `Robot`, the static type
        ser.alarm();

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
}
