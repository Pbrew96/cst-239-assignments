package app;

/**
 * This class represents a weapon product.
 * It extends SalableProduct and adds damage and type.
 */
public class Weapon extends SalableProduct
{
    private int damage;
    private String weaponType;

    /**
     * Constructor for Weapon.
     */
    public Weapon(String name, String description, double price, int quantity, int damage, String weaponType)
    {
        super(name, description, price, quantity);
        this.damage = damage;
        this.weaponType = weaponType;
    }

    /**
     * Returns weapon details as a string.
     */
    @Override
    public String toString()
    {
        return super.toString() + " | Damage: " + damage + " | Type: " + weaponType;
    }
}