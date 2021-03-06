package lol.krzychu.bookaro.Order.Infrastructure;

import lol.krzychu.bookaro.Order.Domain.Order;
import lol.krzychu.bookaro.Order.Domain.OrderRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryOrderRepository implements OrderRepository {
    private final Map<Long, Order> storage = new ConcurrentHashMap<>();
    private final AtomicLong NEXT_ID = new AtomicLong(0L);

    @Override
    public Order save(Order order) {
        if(order.getId() != null)
        {
            storage.put(order.getId(), order);
        }else {
            long nextId = nextId();
            order.setId(nextId);
            order.setCreateAt(LocalDateTime.now());
            storage.put(nextId, order);
        }
        return null;
    }

    private long nextId() {
        return NEXT_ID.getAndIncrement();
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
