package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class runs all JUnit test classes together.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    SalableProductTest.class,
    WeaponTest.class,
    ArmorTest.class,
    HealthTest.class,
    InventoryManagerTest.class,
    ShoppingCartTest.class,
    StoreFrontTest.class,
    FileServiceTest.class
})
public class AllTests {
}