import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {

    @Test
    public void testEveryStatementKriterium() {
        try {
            SILab2.checkCart(null, "1234567812345678");
            fail("Требаше да фрли исклучок за null листа.");
        } catch (RuntimeException ex) {
            assertEquals("allItems list can't be null!", ex.getMessage());
        }

        try {
            List<Item> items = Collections.singletonList(new Item(null, 1, 100, 0.0));
            SILab2.checkCart(items, "1234567812345678");
            fail("Требаше да фрли исклучок за невалиден предмет (име).");
        } catch (RuntimeException ex) {
            assertEquals("Invalid item!", ex.getMessage());
        }

        List<Item> mix = Arrays.asList(
                new Item("A", 1, 301, 0.1),
                new Item("B", 1, 100, 0.0)
        );

        double rezultat = SILab2.checkCart(mix, "1234567812345678");
        assertEquals(340.9, rezultat, 0.0001);

        try {
            List<Item> okItems = Collections.singletonList(new Item("X", 1, 100, 0.0));
            SILab2.checkCart(okItems, "123");
            fail("Требаше да фрли исклучок за невалиден број на картичка (должина).");
        } catch (RuntimeException ex) {
            assertEquals("Invalid card number!", ex.getMessage());
        }

        try {
            List<Item> okItems = Collections.singletonList(new Item("X", 1, 100, 0.0));
            SILab2.checkCart(okItems, "123456781234567A");
            fail("Требаше да фрли исклучок за невалиден карактер во број на картичка.");
        } catch (RuntimeException ex) {
            assertEquals("Invalid character in card number!", ex.getMessage());
        }
    }

    @Test
    public void testMultipleConditionKriterium() {
        String validCard = "1234567812345678";

        assertEquals(100.0, SILab2.checkCart(
                Collections.singletonList(new Item("I", 1, 100, 0.0)), validCard), 0.0001);

        assertEquals(271.0, SILab2.checkCart(
                Collections.singletonList(new Item("I", 1, 301, 0.0)), validCard), 0.0001);

        assertEquals(60.0, SILab2.checkCart(
                Collections.singletonList(new Item("I", 1, 100, 0.1)), validCard), 0.0001);

        assertEquals(1070.0, SILab2.checkCart(
                Collections.singletonList(new Item("I", 11, 100, 0.0)), validCard), 0.0001);

        assertEquals(240.9, SILab2.checkCart(
                Collections.singletonList(new Item("I", 1, 301, 0.1)), validCard), 0.0001);

        assertEquals(3281.0, SILab2.checkCart(
                Collections.singletonList(new Item("I", 11, 301, 0.0)), validCard), 0.0001);

        assertEquals(960.0, SILab2.checkCart(
                Collections.singletonList(new Item("I", 11, 100, 0.1)), validCard), 0.0001);

        assertEquals(2949.9, SILab2.checkCart(
                Collections.singletonList(new Item("I", 11, 301, 0.1)), validCard), 0.0001);
    }
}
