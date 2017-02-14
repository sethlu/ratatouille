/**
 * @author Zhuo Lu
 */

package inheritance;

class Machine {

    /**
     * Static method that the Machine
     */
    static void identify() {
        System.out.println("Machine");
    }
}

class Robot extends Machine {

    static void identify() {
        System.out.println("Robot");
    }
}

class SteamMachine extends Machine {

}

public class StaticPlayground {

    public static void main(String[] main) {
        testSuite1();
        testSuite2();
        testSuite3();
        testSuite4();
        testSuite5();
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

    static void testSuite4() {
        Machine m = new SteamMachine();
        m.identify();
    }

    static void testSuite5() {
        SteamMachine m = new SteamMachine();
        m.identify();
    }
}
