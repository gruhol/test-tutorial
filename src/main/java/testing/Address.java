package testing;

public class Address {
    public String street;
    public String number;

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }
}
