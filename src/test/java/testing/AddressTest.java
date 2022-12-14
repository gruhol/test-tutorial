package testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @ParameterizedTest
    @CsvSource({"Fabryczna, 10", "Armin krajowej, 50"})
    void givenAddressesShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(number, notNullValue());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void givenAddressesFromFileShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(number, notNullValue());
    }
}