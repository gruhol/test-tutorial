package testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void getPrice() {
    }

    @Test
    void shouldReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(35);
        //when
        int discountedPrice = meal.getDiscountedPrice(7);
        //then
        assertEquals(28, discountedPrice);
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        assertSame(meal1, meal2);
    }

    @Test
    void referencesToDifferentObjectShouldBeNotEqual() {
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);
        assertNotSame(meal1, meal2);
    }

    @Test
    void ExceptionShouldBeThrowIfDiscountIsHigherThanThePrice() {
        //given
        Meal meal = new Meal(8, "Soup");
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(50));
    }
}