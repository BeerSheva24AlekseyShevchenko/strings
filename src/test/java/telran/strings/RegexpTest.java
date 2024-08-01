package telran.strings;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

public class RegexpTest {
    @Test()
    void testFirstName() {
        String regex = javaVariable();

        assertTrue("v".matches(regex));
        assertTrue("variableName".matches(regex));
        assertTrue("_variable_Name_".matches(regex));
        assertTrue("$variable$Name$".matches(regex));
        assertTrue("variable1Name1".matches(regex));

        assertFalse("1variableName".matches(regex));
        assertFalse("variable-Name".matches(regex));
        assertFalse("variable Name".matches(regex));
        assertFalse("variable.Name".matches(regex));
        assertFalse("variableName!".matches(regex));
        assertFalse("[1".matches(regex));
        assertFalse("_".matches(regex));
        assertFalse("".matches(regex));

    }

    @Test()
    void ipV4OctetTest() {
        String regex = ipV4Octet();

        assertTrue("0".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));

        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("300".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }

    @Test()
    void ipV4AddressTest() {
        String regex = ipV4Address();

        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));

        assertFalse("0.0.0".matches(regex));
        assertFalse("0.0.0+".matches(regex));
        assertFalse("0".matches(regex));
        assertFalse("0. -".matches(regex));
        assertFalse("0.0.0*0".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
    }

    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected, stringWithJavaNames(names));
    }

    @Test
    void isValidBracketsTest() {
        assertTrue(isValidBracketsDirectory(""));
        assertTrue(isValidBracketsDirectory("()"));
        assertTrue(isValidBracketsDirectory("(())"));
        assertTrue(isValidBracketsDirectory("()()"));

        assertFalse(isValidBracketsDirectory("("));
        assertFalse(isValidBracketsDirectory(")("));
        assertFalse(isValidBracketsDirectory("(()"));
    }

    @Test
    void isArithmeticOperandTest() {
        assertTrue(isArithmeticOperand("123"));
        assertTrue(isArithmeticOperand("variable_Name$1"));
    }

    @Test
    void isPositiveNumberTest() {
        assertTrue(isPositiveNumber("12345"));
        assertTrue(isPositiveNumber("123.45"));

        assertFalse(isPositiveNumber("-12345"));
        assertFalse(isPositiveNumber("abc"));
    }

    @Test
    void isArithmeticExpressionTest() {
        assertTrue(isArithmeticExpression("1 + 1"));
        assertTrue(isArithmeticExpression("(1 + 1)"));
        assertTrue(isArithmeticExpression("( 1 ) + 1"));
        assertTrue(isArithmeticExpression("((( 1 + 1 )))"));
        assertTrue(isArithmeticExpression("1 + 2 - 3 * 4 / 5"));
        assertTrue(isArithmeticExpression("( ( 1 + 2 ) + ( 3 + ( 4 + 5 ) + 6 ) ) - 7"));
        assertTrue(isArithmeticExpression("a + b2 - c_3 * d$3 / ee"));
        assertTrue(isArithmeticExpression("( ( a + b ) + ( c + ( d + e ) + f ) ) - j"));

        assertFalse(isArithmeticExpression(""));
        assertFalse(isArithmeticExpression(" "));
        assertFalse(isArithmeticExpression(" + "));
        assertFalse(isArithmeticExpression("++"));
        assertFalse(isArithmeticExpression("1"));
        assertFalse(isArithmeticExpression("-1"));
        assertFalse(isArithmeticExpression("abc"));
        assertFalse(isArithmeticExpression("1 + 1 -"));
        assertFalse(isArithmeticExpression("1 1+1"));
        assertFalse(isArithmeticExpression("()"));
        assertFalse(isArithmeticExpression("(1+1"));
        assertFalse(isArithmeticExpression("(1+1)2(3+3)"));
        assertFalse(isArithmeticExpression("(1+1("));
        assertFalse(isArithmeticExpression("(1)+1)"));
        assertFalse(isArithmeticExpression("int+char"));
        assertFalse(isArithmeticExpression("a b+c"));
    }
}
