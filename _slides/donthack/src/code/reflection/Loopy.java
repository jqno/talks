//JAVA_OPTIONS --add-opens java.base/java.lang=ALL-UNNAMED

public class Loopy {
    public static void main(String... args) throws Exception {

        var valueField = Integer.class.getDeclaredField("value");
        valueField.setAccessible(true);

        valueField.set(5, 4);

        for (Integer i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
