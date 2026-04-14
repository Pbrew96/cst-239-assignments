package app;

/**
 * This class represents a health item.
 * It extends SalableProduct and adds healing value and type.
 */
public class Health extends SalableProduct
{
    private int healAmount;
    private String healthType;

    /**
     * Constructor for Health.
     */
    public Health(String name, String description, double price, int quantity, int healAmount, String healthType)
    {
        super(name, description, price, quantity);
        this.healAmount = healAmount;
        this.healthType = healthType;
    }

    /**
     * Returns health item details as a string.
     */
    @Override
    public String toString()
    {
        return super.toString() + " | Heal: " + healAmount + " | Type: " + healthType;
    }
}
