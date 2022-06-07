package lol.krzychu.bookaro.Order.Domain;

import lol.krzychu.bookaro.catalog.domain.Book;
import lombok.Value;

@Value
public class OrderItem {
    //Long id;
    Book book;
    int quantity;
}
