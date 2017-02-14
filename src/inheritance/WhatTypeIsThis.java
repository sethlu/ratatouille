/**
 * @author Zhuo Lu
 */

package inheritance;

class RandomBox {

    void selfIdentify() {
        System.out.println("RandomBox selfIdentify");
        WhatTypeIsThis.inspect(this);
    }
}

class TreasureBox extends RandomBox {

    void selfIdentify() {
        System.out.println("TreasureBox selfIdentify");
        WhatTypeIsThis.inspect(this);
    }
}

public class WhatTypeIsThis {

    static void inspect(RandomBox o) {
        System.out.println("It's just a random box!");
    }

    static void inspect(TreasureBox o) {
        System.out.println("It's a treasure chest!");
    }

    public static void main(String[] args) {
        testSuite1();
    }

    static void testSuite1() {
        TreasureBox b1 = new TreasureBox();
        RandomBox b2 = new TreasureBox();
        RandomBox b3 = new RandomBox();

        b1.selfIdentify();
        b2.selfIdentify();
        b3.selfIdentify();
    }

}
