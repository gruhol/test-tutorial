package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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

    @ParameterizedTest
    @ValueSource(ints = {5, 10 ,15, 18})
    void mealPricesShouldBeLowerThan20(int price) {
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createMealWithNameAndPrice")
    void BurgerShouldHaveCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThan(10));
    }

    private static Stream<Arguments> createMealWithNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheseburger", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNamesShouldEndWithCake(String name) {
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));
    }

    private static Stream<String> createCakeNames() {
        List<String> cokeNames = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
        return cokeNames.stream();
    }
 }