package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @ParameterizedTest
    @CsvSource({
            "SAUCE, ketchup, 55.55",
            "FILLING, beef, 111.11"
    })
    void testIngredientCreation(String type, String name, float price) {

        Ingredient ingredient = new Ingredient(IngredientType.valueOf(type), name, price);

        assertEquals(IngredientType.valueOf(type), ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice());
    }
}

