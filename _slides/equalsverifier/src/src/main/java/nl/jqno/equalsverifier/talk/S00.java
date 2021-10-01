package nl.jqno.equalsverifier.talk;

public class S00 {










    /*
     * Not all equals() methods are created equal
     *
     *
     *                    -or-
     *
     * How to write a good equals method in Java
     *
     *
     *
     *
     *                           -by- Jan Ouwens
     *                                @jqno
     */




















    /*
     * In this talk:
     *
     * - common pitfalls;
     *
     * - how to avoid them;
     *
     * - how to test them.
     */




















    /*
     * Our running example.
     */
    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }



    public enum Color {
        RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
    }
















    /*
     * the stopHere() method
     */
    public static void stopHere() {
        System.out.println("👍");
        System.exit(0);
    }


















    /*
     *
     * - Reflexivity       Apple == Apple
     *
     * - Symmetry          if Apple == Orange, then Orange == Apple
     *
     * - Transitivity      if Apple == Banana and Banana == Orange, then Apple == Orange
     *
     * - Consistency       if Apple == Orange now, then Apple == Orange always
     *
     * - Non-nullity       Apple == null is never true
     */














    /**
     * How do you test this -- effectively?
     */




}
