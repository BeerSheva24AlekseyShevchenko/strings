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
            "^(?!(%s)$)[A-z$_][0-9A-z$_]*$",
            String.join("|", keywords)
        );
    }
}
