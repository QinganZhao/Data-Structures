import org.junit.Test;

/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b);
    }

    @Test
    public void testFlik() {
        Integer a = 128;
        Integer b = 128;
        org.junit.Assert.assertTrue(isSameNumber(a, b));
    }
}
