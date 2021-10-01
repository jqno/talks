package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;

public class S07 {
    public static void main(String...args) {










        /*
         * Oh, I know... let's use getClass() instead of instanceof!
         *
         * It's IntelliJ's default for a reason!
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

            // 👇 GENERATED (not accepting subclasses) 👇
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x && y == point.y;
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

            // 👇 GENERATED (not accepting subclasses) 👇
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                ColorPoint that = (ColorPoint) o;
                return color == that.color;
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
