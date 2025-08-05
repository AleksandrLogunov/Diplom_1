package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    @Test
    @DisplayName("Проверка получения имени булочки")
    void getNameReturnsCorrectName() {
        Bun bun = new Bun("Black bun", 100);
        assertEquals("Black bun", bun.getName());
    }

    @Test
    @DisplayName("Проверка получения цены булочки")
    void getPriceReturnsCorrectPrice() {
        Bun bun = new Bun("White bun", 200);
        assertEquals(200, bun.getPrice());
    }
}
