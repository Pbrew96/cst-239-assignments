package test;

import app.Health;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Health class.
 */
public class HealthTest {

    /**
     * Tests toString method.
     */
    @Test
    public void testToString() {
        Health health = new Health("Potion", "Heals", 5.0, 10, 25, "Small");

        String result = health.toString();

        assertTrue(result.contains("Potion"));
        assertTrue(result.contains("Heals"));
        assertTrue(result.contains("5.0"));
        assertTrue(result.contains("10"));
        assertTrue(result.contains("25"));
        assertTrue(result.contains("Small"));
    }
}