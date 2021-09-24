package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;

public class S07 {
    public static void main(String...args) {










        /*
         * Oh, I know... let's use getClass() instead of instanceof!
         */
        class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + x) + y;
            }

            @Override
            public boolean equals(Object obj) {
                /*
                 * Don't forget the null check!
                 */
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Point other = (Point)obj;
                return x == other.x && y == other.y;
            }
        }




















        /*
         * This is the previously asymmetric ColorPoint.
         */
        class ColorPoint extends Point {
            private final Color color;

            public ColorPoint(int x, int y, Color color) {
                super(x, y);
                this.color = color;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + super.hashCode()) + color.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ColorPoint other = (ColorPoint)obj;
                return color.equals(other.color) && super.equals(obj);
            }
        }




















        EqualsVerifier.forClass(Point.class)
            .usingGetClass()
            .verify();
    
        stopHere();

        EqualsVerifier.forClass(ColorPoint.class)
            .usingGetClass()
            .verify();

        stopHere();



















        /*
         * But... what's that "usingGetClass" thingy doing there?
         *
         * It says we're breaking the Liskov Substitution Principle.
         */




















    }
}
