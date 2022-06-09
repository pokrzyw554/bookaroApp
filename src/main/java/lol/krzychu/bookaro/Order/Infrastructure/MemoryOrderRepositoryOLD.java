package lol.krzychu.bookaro.Order.Infrastructure;

import lol.krzychu.bookaro.Order.Domain.Order;
import lol.krzychu.bookaro.Order.Domain.OrderRepository;

import java.util.List;

public class MemoryOrderRepositoryOLD implements OrderRepository {
    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
