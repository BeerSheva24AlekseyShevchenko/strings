package telran.strings;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

public class RegexpTest {
    @Test()
    void testFirstName() {
        assertTrue("variableName".matches(javaVariable()));
        assertTrue("_variable_Name_".matches(javaVariable()));
        assertTrue("$variable$Name$".matches(javaVariable()));
        assertTrue("variable1Name1".matches(javaVariable()));
        assertTrue("int2".matches(javaVariable()));
        assertTrue("Ffloat".matches(javaVariable()));

        assertFalse("1variableName".matches(javaVariable()));
        assertFalse("variable-Name".matches(javaVariable()));
        assertFalse("variable Name".matches(javaVariable()));
        assertFalse("variable.Name".matches(javaVariable()));
        assertFalse("variableName!".matches(javaVariable()));
        assertFalse("int".matches(javaVariable()));
        assertFalse("float".matches(javaVariable()));
        assertFalse("for".matches(javaVariable()));
        assertFalse("_".matches(javaVariable()));
        assertFalse("".matches(javaVariable()));

    }

}
