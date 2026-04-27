package test;

import app.Armor;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Armor class.
 */
public class ArmorTest {

    /**
     * Tests toString method.
     */
    @Test
    public void testToString() {
        Armor armor = new Armor("Helmet", "Protects head", 20.0, 3, 10, "Light");

        String result = armor.toString();

        assertTrue(result.contains("Helmet"));
        assertTrue(result.contains("Protects head"));
        assertTrue(result.contains("20.0"));
        assertTrue(result.contains("3"));
        assertTrue(result.contains("10"));
        assertTrue(result.contains("Light"));
    }
}