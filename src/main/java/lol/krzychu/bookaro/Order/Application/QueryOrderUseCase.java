package lol.krzychu.bookaro.Order.Application;

import lol.krzychu.bookaro.Order.Domain.Order;

import java.util.List;

public interface QueryOrderUseCase {
    List<Order> findAll();
}
