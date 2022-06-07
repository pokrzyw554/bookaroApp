package lol.krzychu.bookaro.Order.Infrastructure;

import lol.krzychu.bookaro.Order.Domain.Order;
import lol.krzychu.bookaro.Order.Domain.OrderRepository;

import java.util.List;

public class MemoryOrderRepository  implements OrderRepository {
    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
