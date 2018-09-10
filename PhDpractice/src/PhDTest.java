import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PhDTest {

    @Test
    void testConstructor1() {

        PhD Franklin = new PhD("Franklin", 2018, 6);

        assertEquals("Franklin", Franklin.name());
        assertEquals(2018, Franklin.year());
        assertEquals(6, Franklin.month());
        assertEquals(null, Franklin.advisor1());
        assertEquals(null, Franklin.advisor2());
        assertEquals(0, Franklin.numAdvisees());
        assertThrows(AssertionError.class, () -> {new PhD("", 2018, 6);});
        assertThrows(AssertionError.class, () -> {new PhD("Franklin", 2018, 13);});

    }

    @Test
    void testGroupB() {

        PhD Micheal = new PhD("Micheal", 2000, 3);
        PhD Trevor = new PhD("Trevor", 2009, 11);
        PhD Franklin = new PhD("Franklin", 2018, 6);
        Trevor.addAdvisor1(Micheal);
        Franklin.addAdvisor1(Micheal);
        Franklin.addAdvisor2(Trevor);

        assertEquals(null, Micheal.advisor1());
        assertEquals(null, Micheal.advisor2());
        assertEquals(Micheal, Trevor.advisor1());
        assertEquals(null, Trevor.advisor2());
        assertEquals(Micheal, Franklin.advisor1());
        assertEquals(Trevor, Franklin.advisor2());
        assertThrows(AssertionError.class, () -> {Trevor.addAdvisor2(null);});
        assertThrows(AssertionError.class, () -> {Trevor.addAdvisor2(Micheal);});
        assertThrows(AssertionError.class, () -> {Micheal.addAdvisor1(null);});
        assertThrows(AssertionError.class, () -> {Micheal.addAdvisor2(Franklin);});
        assertThrows(AssertionError.class, () -> {Trevor.addAdvisor1(Franklin);});

    }

    @Test
    void testGroupC() {

        PhD Micheal = new PhD("Micheal", 2000, 3);
        PhD Trevor = new PhD("Trevor", 2009, 11);
        PhD Franklin = new PhD("Franklin", 2018, 6, Micheal);
        PhD Niko = new PhD("Niko", 2019, 12, Micheal, Trevor);

        assertEquals("Franklin", Franklin.name());
        assertEquals(2018, Franklin.year());
        assertEquals(6, Franklin.month());
        assertEquals(Micheal, Franklin.advisor1());
        assertEquals(null, Franklin.advisor2());
        assertEquals(0, Franklin.numAdvisees());
        assertEquals("Niko", Niko.name());
        assertEquals(2019, Niko.year());
        assertEquals(12, Niko.month());
        assertEquals(Micheal, Niko.advisor1());
        assertEquals(Trevor, Niko.advisor2());
        assertEquals(0, Niko.numAdvisees());
        assertEquals(2, Micheal.numAdvisees());
        assertEquals(1, Trevor.numAdvisees());
        assertThrows(AssertionError.class, () -> {new PhD ("", 2013, 10, Micheal);});
        assertThrows(AssertionError.class, () -> {new PhD ("Tommy", 2013, 13, Micheal);});
        assertThrows(AssertionError.class, () -> {new PhD ("Tommy", 2013, 10, null);});
        assertThrows(AssertionError.class, () -> {new PhD ("", 2013, 10, Micheal, Trevor);});
        assertThrows(AssertionError.class, () -> {new PhD ("Tommy", 2013, 13, Micheal, Trevor);});
        assertThrows(AssertionError.class, () -> {new PhD ("Tommy", 2013, 10, null, Trevor);});
        assertThrows(AssertionError.class, () -> {new PhD ("Tommy", 2013, 13, Micheal, null);});
        assertThrows(AssertionError.class, () -> {new PhD ("Tommy", 2013, 13, Micheal, Micheal);});

    }

    @Test
    void testGroupD() {

        PhD feb18 = new PhD("feb18", 2018, 2);
        PhD feb18p = new PhD("feb18p", 2018, 2);
        PhD jan18 = new PhD("jan18", 2018, 1);
        PhD mar18 = new PhD("mar18", 2018, 3);
        PhD feb17 = new PhD("feb17", 2017, 2);
        PhD jan17 = new PhD("jan17", 2017, 1);
        PhD mar17 = new PhD("mar17", 2017, 3);
        PhD feb19 = new PhD("feb19", 2019, 2);
        PhD jan19 = new PhD("jan19", 2019, 1);
        PhD mar19 = new PhD("mar19", 2019, 3);

        assertEquals(false, feb18.gotBefore(null));
        assertEquals(false, feb18.gotBefore(feb18p));
        assertEquals(false, feb18.gotBefore(jan18));
        assertEquals(true, feb18.gotBefore(mar18));
        assertEquals(false, feb18.gotBefore(feb17));
        assertEquals(false, feb18.gotBefore(jan17));
        assertEquals(false, feb18.gotBefore(mar17));
        assertEquals(true, feb18.gotBefore(feb19));
        assertEquals(true, feb18.gotBefore(jan19));
        assertEquals(true, feb18.gotBefore(mar19));

        PhD Micheal = new PhD("Micheal", 2000, 3);
        PhD Trevor = new PhD("Trevor", 2009, 11);
        PhD Luis = new PhD("Luis", 2010, 3);
        PhD Franklin = new PhD("Franklin", 2018, 6, Micheal, Trevor);
        PhD Niko = new PhD("Niko", 2019, 12, Micheal, Luis);
        PhD Tommy = new PhD("Tommy", 2018, 3, Luis, Micheal);
        PhD Carl = new PhD("Carl", 2018, 4, Trevor, Luis);
        PhD Loc = new PhD("Loc", 2018, 5, Luis, Trevor);

        assertEquals(false, Franklin.isSiblingOf(Franklin));
        assertEquals(false, Micheal.isSiblingOf(Trevor));
        assertEquals(true, Franklin.isSiblingOf(Niko));
        assertEquals(true, Franklin.isSiblingOf(Tommy));
        assertEquals(true, Franklin.isSiblingOf(Carl));
        assertEquals(true, Franklin.isSiblingOf(Loc));

    }

}