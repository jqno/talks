package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;
import static org.junit.Assert.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;

public class S08 {
    public static void main(String...args) {










        /*
         * Liskov Substitution Principle:
         *
         * - if Banana is a subtype of Fruit,
         * - then objects of type Fruit may be replaced with objects of type Banana
         * - and nothing will break.
         */

















        /*
         * This is the basis for all of Object-Oriented Programming
         *
         *
         *  S
         *  O
         *  L iskov Substitution Principle
         *  I
         *  D
         *
         */


















        /*
         * This is the same Point as in the previous slide.
         */
        class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public final int hashCode() {
                return 53 * (53 + x) + y;
            }

            @Override
            public String toString() {
                return String.format("%s: %s,%s", getClass().getSimpleName(), x, y);
            }

            @Override
            public final boolean equals(Object obj) {
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Point other = (Point)obj;
                return x == other.x && y == other.y;
            }
        }




















        /*
         * Now let's pretend that we're Hibernate.
         */
        class Point$$Proxy extends Point {
            public Point$$Proxy(int x, int y) {
                super(x, y);
            }
        }


        Point p = new Point(1, 2);
        Point q = new Point$$Proxy(1, 2);
        assertEquals(p, q);

        stopHere();


        EqualsVerifier.forClass(Point$$Proxy.class)
                .verify();

        stopHere();



















        /*
         * This is a violation of the LSP.
         *
         *
         * You should always use 'instanceof' instead of 'getClass'.
         */


        /*
            @Override
            public final boolean equals(Object obj) {
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point other = (Point)obj;
                return x == other.x && y == other.y;
            }
        */




















        /*
         * "There is no way to extend an instantiable class and add a value component
         * while preserving the equals contract."
         * -- Joshua Bloch, Effective Java
         *
         *
         *    :(  :(  :(
         */




















    }
}
