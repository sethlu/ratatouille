/**
 * @author Zhuo Lu
 */

package inheritance;

class Balloon {

    void floatToTheTop(int count) {
        if (count == 0) {
            System.out.println("Balloon: Stop floating");
        } else {
            System.out.println("Balloon: Continues");
            // floatToTheTop(count - 1);
            this.floatToTheTop(count - 1);
        }
    }
}

class HeliumBalloon extends Balloon {

    @Override
    void floatToTheTop(int count) {
        if (count == 0) {
            System.out.println("HeliumBalloon: Stop floating");
        } else {
            System.out.println("HeliumBalloon: Continues");
            // floatToTheTop(count - 1);
            super.floatToTheTop(count - 1);
        }
    }

    void floatUp(int count) {
        if (count == 0) {
            System.out.println("HeliumBalloon: Stop floating");
        } else {
            System.out.println("HeliumBalloon: Continues");
            // floatUp(count - 1);
            this.floatUp(count - 1);
        }
    }
}

class GiganticHeliumBalloon extends HeliumBalloon {

    @Override
    void floatToTheTop(int count) {
        if (count == 0) {
            System.out.println("GiganticHeliumBalloon: Stop floating");
        } else {
            System.out.println("GiganticHeliumBalloon: Continues");
            // floatToTheTop(count - 1);
            super.floatToTheTop(count - 1);
        }
    }

    @Override
    void floatUp(int count) {
        if (count == 0) {
            System.out.println("GiganticHeliumBalloon: Stop floating");
        } else {
            System.out.println("GiganticHeliumBalloon: Continues");
            super.floatUp(count - 1);
        }
    }
}

public class SuperConfusing {

    public static void main(String[] args) {
        testSuite1();
    }

    static void testSuite1() {
        // Test suite 1
        System.out.println("\nTest suite 1\n");

        GiganticHeliumBalloon f = new GiganticHeliumBalloon();

        System.out.println("Floating up...\n");
        f.floatUp(8);

        System.out.println("\nFloating all the way up...\n");
        f.floatToTheTop(8);
    }
}
