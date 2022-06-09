package lol.krzychu.bookaro.Order.Application;

import lol.krzychu.bookaro.Order.Domain.Order;
import lol.krzychu.bookaro.Order.Domain.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QueryOrderService implements QueryOrderUseCase {
    private final OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
}
