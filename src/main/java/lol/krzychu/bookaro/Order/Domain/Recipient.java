package lol.krzychu.bookaro.Order.Domain;

import lombok.Value;

@Value
public class Recipient {
    String name;
    String phone;
    String street;
    String city;
    String zipCode;
    String email;
}
