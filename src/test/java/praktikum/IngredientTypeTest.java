package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IngredientTypeTest {

    @Test
    @DisplayName("Перечисление IngredientType должно содержать значения SAUCE и FILLING")
    void valuesContainsSauceAndFilling() {
        IngredientType[] values = IngredientType.values();

        assertTrue(List.of(values).contains(IngredientType.SAUCE));
        assertTrue(List.of(values).contains(IngredientType.FILLING));
    }

    @Test
    @DisplayName("Проверка метода valueOf() на корректность возвращения значений")
    void valueOfReturnsCorrectEnum() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}