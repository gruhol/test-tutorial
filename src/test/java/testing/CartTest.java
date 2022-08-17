package testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test cases for Cart")
class CartTest {

    @DisplayName("Cart is able to process 1000 order in 100ms")
    @Test
    void simulateLargeOrder() {
        // given
        Cart cart = new Cart();
        //when
        //then
        assertTimeout(Duration.ofMillis(10), () -> cart.simulateLargeOrder());
    }

    @Test
    void cartShouldBeNotEmptyAfterAddingOrderToCart() {
        // given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(0),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll("This is group assertions of cars",
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), hasSize(1)),
                () -> assertThat(cart.getOrders(), is(not(empty()))),
                () -> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class))))
        );
    }
}