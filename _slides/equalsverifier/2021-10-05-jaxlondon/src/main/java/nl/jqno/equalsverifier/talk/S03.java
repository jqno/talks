package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import nl.jqno.equalsverifier.talk.helper.EqualsVerifier;

public class S03 {
    public static void main(String...args) {










        /*
         * Let's start with Point again. This time, it has a hashCode.
         *
         * Also, it has explicit getters and setters.
         */
        class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() { return x; }
            public int getY() { return y; }
            public void setX(int x) { this.x = x; }
            public void setY(int y) { this.y = y; }

            @Override
            public int hashCode() {
                return 53 * (53 + x) + y;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point other = (Point)obj;
                return x == other.x && y == other.y;
            }
        }




















        /*
         * Why do we care about mutability?
         *
         * Well...
         */
        var p = new Point(0, 1);
        var set = new HashSet<Point>();
        set.add(p);


        /*
         * ...an object should always be findable in a collection...
         */
        assertTrue(set.contains(p));

        stopHere();


        /*
         * ...even if it changes!
         */
        p.setX(1337);

        assertTrue(set.contains(p));  //  <-- Fails... PROBABLY.

        stopHere();




















        /*
         * So, the object can no longer be found using contains().
         *
         * Does that mean it's gone?
         */
        p.setX(1337);

        boolean found = false;
        for (var maybe : set) {
            if (maybe.equals(p)) {
                found = true;
            }
        }
        assertTrue(found);

        stopHere();



















        /*
         * EqualsVerifier isn't happy with this, either.
         */
        EqualsVerifier.forClass(Point.class)
            .verify();

        stopHere();


















        /*
         * So... how do we fix this?
         *
         * Solution 1: use immutable id fields, like a database.
         *  - you will lose semantic equality.
         *  - what if the object is new and still has id -1?
         *
         * Solution 2: use immutable data classes.
         */




















        /*
         * Here's an immutable Point.
         *
         * Note the use of the 'final' keyword.
         */
        class ImmutablePoint {
            private final int x;
            private final int y;

            public ImmutablePoint(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + x) + y;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof ImmutablePoint)) {
                    return false;
                }
                ImmutablePoint other = (ImmutablePoint)obj;
                return x == other.x && y == other.y;
            }
        }




















        /*
         * And an EqualsVerifier test.
         */
        EqualsVerifier.forClass(ImmutablePoint.class)
            .verify();

        stopHere();



















        /*
         * Consistency
         */





    }
}
