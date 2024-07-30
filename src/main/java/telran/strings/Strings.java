package telran.strings;

final public class Strings {
    private Strings() {}

    static final String keywords[] = {
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float",
        "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
        "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
        "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void",
        "volatile", "while"
    };

    public static String javaVariable() {
        return String.format(
            "^(?!(%s)$)(?!_$)[A-Za-z$_][\\w$]*$",
            String.join("|", keywords)
        );
    }

    public static String ipV4Octet() {
        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }

    public static String ipV4Address() {
        String octetRegex = ipV4Octet();

        return String.format("%s(\\.%s){3}", octetRegex, octetRegex, octetRegex, octetRegex);
    }
}
