package lol.krzychu.bookaro.Order.Domain;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    List<Order> findAll();
}
