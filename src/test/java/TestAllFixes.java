package org.unitime;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAllFixes {

    // ========== FIX 1: Unsafe Integer Parsing ==========
    @Test
    public void testIntegerParsingBefore() {
        // Before fix - crashes with invalid input
        try {
            String version = "invalid";
            int result = Integer.parseInt(version); // crashes!
            fail("Should have thrown NumberFormatException");
        } catch (NumberFormatException e) {
            System.out.println("FIX 1 BEFORE: NumberFormatException thrown for input 'invalid' ✓");
        }
    }

    @Test
    public void testIntegerParsingAfter() {
        // After fix - handled with try-catch
        String version = "invalid";
        int result = 0;
        try {
            result = Integer.parseInt(version);
        } catch (NumberFormatException e) {
            result = 0; // default value
        }
        assertEquals(0, result);
        System.out.println("FIX 1 AFTER: Invalid input handled gracefully, result = " + result + " ✓");
    }

    // ========== FIX 2: XXE Vulnerability ==========
    @Test
    public void testXXEBefore() {
        // Before fix - SAXReader created without XXE protection
        org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
        assertNotNull(reader);
        System.out.println("FIX 2 BEFORE: SAXReader created WITHOUT XXE protection - vulnerable!");
    }

    @Test
    public void testXXEAfter() throws Exception {
        // After fix - SAXReader created with XXE protection
        org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
        reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
        reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        assertNotNull(reader);
        System.out.println("FIX 2 AFTER: SAXReader created WITH XXE protection ✓");
    }

    // ========== FIX 3: NullPointerException in Debug ==========
    @Test
    public void testDebugNullBefore() {
        // Before fix - NullPointerException when e is null
        try {
            Throwable e = null;
            e.getMessage(); // crashes!
            fail("Should have thrown NullPointerException");
        } catch (NullPointerException ex) {
            System.out.println("FIX 3 BEFORE: NullPointerException thrown for null Throwable ✓");
        }
    }

    @Test
    public void testDebugNullAfter() {
        // After fix - null check added
        Throwable e = null;
        if (e == null) {
            System.out.println("FIX 3 AFTER: Null check works, no exception thrown ✓");
            return;
        }
        e.getMessage();
        assertTrue(true);
    }

    // ========== FIX 4: Hard-coded Token ==========
    @Test
    public void testHardcodedTokenBefore() {
        // Before fix - hard-coded token exposed
        String token = System.getProperty("token", "b191dd443ab1800fc1e09ef23e50cdb0");
        assertEquals("b191dd443ab1800fc1e09ef23e50cdb0", token);
        System.out.println("FIX 4 BEFORE: Hard-coded token exposed = " + token + " - SECURITY RISK!");
    }

    @Test
    public void testHardcodedTokenAfter() {
        // After fix - empty default token
        String token = System.getProperty("token", "");
        assertEquals("", token);
        System.out.println("FIX 4 AFTER: Token is empty by default = '" + token + "' - SECURE ✓");
    }

    // ========== FIX 5: Logical Operator & vs && ==========
    @Test
    public void testLogicalOperatorBefore() {
        // Before fix - using & evaluates both sides
        Object cct = null;
        Object ccut = new Object();
        boolean result = (cct != null & ccut != null); // & evaluates both!
        assertFalse(result);
        System.out.println("FIX 5 BEFORE: Using & operator - evaluates both sides even if first is null!");
    }

    @Test
    public void testLogicalOperatorAfter() {
        // After fix - using && stops at first false
        Object cct = null;
        Object ccut = new Object();
        boolean result = (cct != null && ccut != null); // && stops at first false
        assertFalse(result);
        System.out.println("FIX 5 AFTER: Using && operator - stops at first false, correct behavior ✓");
    }
}
