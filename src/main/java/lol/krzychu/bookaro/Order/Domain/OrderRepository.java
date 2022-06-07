package lol.krzychu.bookaro.Order.Domain;

import java.util.List;

public interface OrderRepository {
    Order saveOrder(Order order);
    List<Order> findAll();
}
