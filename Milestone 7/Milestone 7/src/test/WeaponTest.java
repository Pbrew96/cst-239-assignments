package test;

import app.Weapon;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Weapon class.
 */
public class WeaponTest {

    /**
     * Tests toString method.
     */
    @Test
    public void testToString() {
        Weapon weapon = new Weapon("Sword", "Sharp blade", 10.0, 5, 15, "Melee");

        String result = weapon.toString();

        assertTrue(result.contains("Sword"));
        assertTrue(result.contains("Sharp blade"));
        assertTrue(result.contains("10.0"));
        assertTrue(result.contains("5"));
        assertTrue(result.contains("15"));
        assertTrue(result.contains("Melee"));
    }

    /**
     * Tests compareTo method.
     */
    @Test
    public void testCompareTo() {
        Weapon w1 = new Weapon("Axe", "Heavy", 10.0, 1, 20, "Melee");
        Weapon w2 = new Weapon("Sword", "Sharp", 10.0, 1, 15, "Melee");

        assertTrue(w1.compareTo(w2) < 0);
    }

    /**
     * Tests compareTo equal case.
     */
    @Test
    public void testCompareToEqual() {
        Weapon w1 = new Weapon("Bow", "Ranged", 8.0, 1, 10, "Ranged");
        Weapon w2 = new Weapon("Bow", "Ranged", 8.0, 1, 10, "Ranged");

        assertEquals(0, w1.compareTo(w2));
    }
}