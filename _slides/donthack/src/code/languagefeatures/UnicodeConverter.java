import java.util.stream.Collectors;

public class UnicodeConverter {
    private static final String PROGRAM = """
            public class UnicodeEscapism {
                public static void main(String... args) {
                    System.out.println("Hello hackers!");
                }
            }
            """;

    public static void main(String... args) {
        var strings = PROGRAM.chars()
                .mapToObj(UnicodeConverter::convertChar)
                .collect(Collectors.toList());

        var output = String.join("", strings);
        System.out.println(output);
    }

    private static String convertChar(int c) {
        if (c == 10) {
            return "\n";
        }
        else {
            return "\\u00" + Integer.toHexString(c);
        }
    }
}
