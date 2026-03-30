package app;

/**
 * This class represents an armor product.
 * It extends SalableProduct and adds defense and type.
 */
public class Armor extends SalableProduct
{
    private int defense;
    private String armorType;

    /**
     * Constructor for Armor.
     */
    public Armor(String name, String description, double price, int quantity, int defense, String armorType)
    {
        super(name, description, price, quantity);
        this.defense = defense;
        this.armorType = armorType;
    }

    /**
     * Returns armor details as a string.
     */
    @Override
    public String toString()
    {
        return super.toString() + " | Defense: " + defense + " | Type: " + armorType;
    }
}