package inheritance;

class Fruit {

    void whatIsThis(Fruit o) {
        System.out.println("Fruit: Fruit");
    }
}

class Apple extends Fruit {

    @Override
    void whatIsThis(Fruit o) {
        System.out.println("Apple: Fruit");
    }

    void whatIsThis(Apple o) {
        System.out.println("Apple: Apple");
    }
}

class OverridingAndOverloading {

    public static void main(String[] args) {
        testSuite1();
    }

    static void testSuite1() {
        Apple a = new Apple();
        Fruit f = a;

        a.whatIsThis(a);
        // Output: Apple: Apple
        f.whatIsThis(a);
        // Output: Apple: Fruit
    }
}
