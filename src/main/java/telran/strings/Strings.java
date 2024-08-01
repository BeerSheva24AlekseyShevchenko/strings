package telran.strings;

import java.util.Arrays;

final public class Strings {
    private Strings() {}

    static final String keyWords[] = { "abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "false",
                "final", "finally", "float", "for", "goto", "if", "implements",
                "import", "instanceof", "int", "interface", "long", "native",
                "new", "null", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch",
                "synchronized", "this", "throw", "throws", "transient", "true",
                "try", "void", "volatile", "while" };

    public static String javaVariable() {
        return "((?!_$)[a-zA-Z$_][\\w$]*)";
    }

    public static String ipV4Octet() {
        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }

    public static String ipV4Address() {
        String octetRegex = ipV4Octet();

        return String.format("%s(\\.%s){3}", octetRegex, octetRegex, octetRegex, octetRegex);
    }

    public static String stringWithJavaNames(String names) {
        String[] items = names.split("\\s+");
        int index = getJavaNameIndex(items, -1);
        String res = index >= 0 ? items[index] : "";
    
        while ((index = getJavaNameIndex(items, index)) > 0) {
            res += " " + items[index];
        }

        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while (i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        return string.matches(javaVariable()) && Arrays.binarySearch(keyWords, string) < 0;
    }

    public static boolean isArithmeticExpression(String expr) {
        boolean isValid = isValidBracketsDirectory(expr);

        String[] operands = expr.split("[+*/-]", -1);
        if (operands.length < 2) isValid = false;

        int i = 0;
        while(isValid && i < operands.length) {
            String operand = operands[i]
                .replaceAll("^[(\\s]*", "")
                .replaceAll("[)\\s]*$", "");
            isValid = isArithmeticOperand(operand);
            i++;
        }

        return isValid;
    }

    public static boolean isArithmeticOperand(String... str) {
        boolean res = true;
        int i = 0;
        while (res && i < str.length) {
            res = isPositiveNumber(str[i]) || isJavaName(str[i]);
            i++;
        }

        return res;
    }

    public static boolean isPositiveNumber(String str) {
        return str.matches("^\\d+(\\.\\d+)?$");
    }

    public static boolean isValidBracketsDirectory(String str) {
        char[] characters = str.toCharArray();
        int i = 0;
        int count = 0;

        while (count >= 0 && i < characters.length) {
            if (characters[i] == '(') count++;
            if (characters[i] == ')') count--;
            i++;
        }

        return count == 0;
    }
}
