/** NetId: nnnnn, nnnnn. Time spent: hh hours, mm minutes.
 * An instance maintains info about the PhD of a person.
 */


public class PhD {

    private String name; // name of the PhD, the length of which is greater than 1
    private int year; // year the PhD awarded, and can be any integer
    private int month; // month the PhD awarded, and should be an integer in range 1-12
    private PhD advisor1; // the first advisor of this person -- null if unknown
    private PhD advisor2; // the second advisor of this person -- null if unkown of the person has less than 2 advisors
    private int numAdvisees; // number of PhD advisees of this person, and should be a non-negative integer


    // Group A

    /** Constructor: an instance for a person with name n, PhD year y, and PhD month m.
     * The advisors are unknown, and there are 0 advisees.
     * Precondition: n has at least 2 chars, and m is in 1..12.
     */

    public PhD(String n, int y, int m) {

        assert n.length() > 0;
        assert m >= 1 && m <= 12;
        name = n;
        year = y;
        month = m;
        advisor1 = null;
        advisor2 = null;
        numAdvisees = 0;

    }

    // Return the name of this person.

    public String name() {
        return name;
    }

    // Return the year this person got their PhD.

    public int year() {
        return year;
    }

    // Return the month this person got their PhD.

    public int month() {
        return month;
    }

    // Return the first advisor of this PhD (null if unknown).

    public PhD advisor1() {
        return advisor1;
    }

    // Return the second advisor of this PhD (null if unknown or non-existent).

    public PhD advisor2() {
        return advisor2;
    }

    // Return the number of PhD advisees of this person.

    public int numAdvisees() {
        return numAdvisees;
    }


    // Group B

    /** Add p as the first advisor of this person.
     * Precondition: the first advisor is unknown and p is not null.
     */

    public void addAdvisor1(PhD p) {

        assert p != null;
        assert advisor1 == null;
        advisor1 = p;
        p.numAdvisees += 1;

    }

    /** Add p as the second advisor of this PhD.
     * Precondition: The first advisor is known, the second advisor is unknown, p is
     * not null, and p is different from the first advisor
     */

    public void addAdvisor2(PhD p) {

        assert p != null;
        assert p != advisor1;
        assert advisor1 != null;
        assert advisor2 == null;
        advisor2 = p;
        p.numAdvisees += 1;

    }

    // Group C

    /** Constructor: a PhD with name n, PhD year y, PhD month m, first advisor
     * adv1, and no second advisor.
     * Precondition: n has at least 2 chars, m is in 1..12, and adv1 is not null.
     */

    public PhD(String n, int y, int m, PhD adv1) {

        assert n.length() >= 1;
        assert m >= 1 && m <= 12;
        assert adv1 != null;
        name = n;
        year = y;
        month = m;
        advisor1 = adv1;
        advisor2 = null;
        numAdvisees = 0;
        adv1.numAdvisees += 1;

    }

    /** Constructor: a PhD with name n, PhD year y, PhD month m, first advisor
     * adv1, and second advisor adv2.
     * Precondition: n has at least 2 chars, m is in 1..12,
     * adv1 and adv2 are not null, and adv1 and adv2 are different.
     */

    public PhD(String n, int y, int m, PhD adv1, PhD adv2) {

        assert n.length() >= 1;
        assert m >= 1 && m <= 12;
        assert adv1 != null;
        assert adv2 != null;
        assert adv1 != adv2;
        name = n;
        year = y;
        month = m;
        advisor1 = adv1;
        advisor2 = adv2;
        numAdvisees = 0;
        adv1.numAdvisees += 1;
        adv2.numAdvisees += 1;

    }

    // Group D

    /** Return value of: p is not null and this PhD got the PhD
     * before p.
     */

    public boolean gotBefore(PhD p) {
        return p != null && (this.year < p.year || (this.year == p.year && this.month < p.month));
    }

    /** Return value of: this PhD is an intellectual sibling of p.
     * Precondition: p is not null.
     */

    public boolean isSiblingOf(PhD p) {

        assert p != null;
        boolean case1 = (this.advisor1 != null || p.advisor1 != null) && this.advisor1 == p.advisor1;
        boolean case2 = (this.advisor1 != null || p.advisor2 != null) && this.advisor1 == p.advisor2;
        boolean case3 = (this.advisor2 != null || p.advisor1 != null) && this.advisor2 == p.advisor1;
        boolean case4 = (this.advisor2 != null || p.advisor2 != null) && this.advisor2 == p.advisor2;
        return (case1 || case2 || case3 || case4) && !this.equals(p);

    }

}

