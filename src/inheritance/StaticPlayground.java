/**
 * @author Zhuo Lu
 */

package inheritance;

public class StaticPlayground {

    /**
     *
     */
    static class Machine {

        static void identify() {
            System.out.println("Machine");
        }
    }

    /**
     *
     */
    static class Robot extends Machine {

        static void identify() {
            System.out.println("Robot");
        }
    }

    public static void main(String[] main) {
        testSuite1();
        testSuite2();
        testSuite3();
    }

    static void testSuite1() {
        Machine m = new Machine();
        m.identify();
    }

    static void testSuite2() {
        Machine m = new Robot();
        m.identify();
    }

    static void testSuite3() {
        Robot r = new Robot();
        r.identify();
    }
}
