package testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
    }

    @Test
    void accountShouldBeActiveAAfterActivation() {
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        assertNull(address);

    }

    @Test
    void defaultDeliveryAddressShouldBeNollAfterBeingSet() {
        //given
        Address address = new Address("Krakowska", "5");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();
        //then
        assertNotNull(defaultAddress);

    }

    @Test
    @RepeatedTest(5)
    void newAccountWithNotNullAddressShouldBeActive() {
        //given
        Address address = new Address("Pulawska", "55");
        //when
        Account account = new Account(address);
        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }

}