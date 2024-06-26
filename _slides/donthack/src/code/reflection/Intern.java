//JAVA_OPTIONS --add-opens java.base/java.lang=ALL-UNNAMED

public class Intern {
    public static void main(String... args) throws Exception {
        var world = "Hello world!";
        var hackers = "Hello hackers!";

        System.out.println(world);
        System.out.println(hackers);

        var valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        var newValue = valueField.get(hackers);
        valueField.set(world, newValue);

        System.out.println("---");
        System.out.println(world);
        System.out.println("Hello world!");
    }
}
