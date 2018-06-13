public class TestPlanet {

    /**
     *  A test that create two planets and prints out the pairwise force between them.
     */

    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (expected == actual) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    private static void checkForce() {
        System.out.println("Checking force...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
        Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), 133.4, "calcForceExertedBy()", 0.01);
        checkEquals(p1.calcForceExertedBy(p3), 6.67e-11, "calcForceExertedBy()", 0.01);
    }

    public static void main(String[] args){
        checkForce();
    }
}
