package telran.strings;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

public class RegexpTest {
    @Test()
    void testFirstName() {
        String regex = javaVariable();

        assertTrue("variableName".matches(regex));
        assertTrue("_variable_Name_".matches(regex));
        assertTrue("$variable$Name$".matches(regex));
        assertTrue("variable1Name1".matches(regex));
        assertTrue("int2".matches(regex));
        assertTrue("Ffloat".matches(regex));

        assertFalse("1variableName".matches(regex));
        assertFalse("variable-Name".matches(regex));
        assertFalse("variable Name".matches(regex));
        assertFalse("variable.Name".matches(regex));
        assertFalse("variableName!".matches(regex));
        assertFalse("int".matches(regex));
        assertFalse("float".matches(regex));
        assertFalse("for".matches(regex));
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
}
