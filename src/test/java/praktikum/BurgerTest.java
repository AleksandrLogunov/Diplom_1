package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @BeforeEach
    void setUp() {
        burger = new Burger();

        bun = mock(Bun.class);
        sauce = mock(Ingredient.class);
        filling = mock(Ingredient.class);

        when(bun.getName()).thenReturn("Mock Bun");
        when(bun.getPrice()).thenReturn(100f);

        when(sauce.getName()).thenReturn("Mock Sauce");
        when(sauce.getPrice()).thenReturn(50f);
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);

        when(filling.getName()).thenReturn("Mock Filling");
        when(filling.getPrice()).thenReturn(70f);
        when(filling.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    @DisplayName("Расчёт общей цены бургера")
    void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float expected = 100 * 2 + 50 + 70;

        assertEquals(expected, burger.getPrice(), 0.01);
    }

    @Test
    @DisplayName("Перемещение ингредиентов внутри списка")
    void testMoveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(filling, ingredients.get(0));
        assertEquals(sauce, ingredients.get(1));
    }

    @Test
    @DisplayName("Удаление ингредиента по индексу")
    void testRemoveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.removeIngredient(1);

        assertEquals(1, burger.ingredients.size());
        assertEquals(sauce, burger.ingredients.get(0));
    }
    @Test
    @DisplayName("Бургер без ингредиентов")
    void testBurgerWithoutIngredients() {
        burger.setBuns(bun);

        float expected = 100 * 2;
        assertEquals(expected, burger.getPrice(), 0.01);

        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Mock Bun"));
        assertFalse(receipt.contains("=" + " sauce "));
    }

    @Test
    @DisplayName("Чек содержит информацию о бургере и имеет правильный формат")
    void testReceiptOutputCorrectFormat() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String expectedReceipt = String.format(
                        "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n%n" +
                                "Price: %f%n",
                bun.getName(),
                sauce.getType().toString().toLowerCase(), sauce.getName(),
                filling.getType().toString().toLowerCase(), filling.getName(),
                bun.getName(),
                burger.getPrice()
        );
        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt, "Формат и содержимое чека не соответствуют ожидаемому.");
    }
}