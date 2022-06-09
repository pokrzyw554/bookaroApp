package lol.krzychu.bookaro.Order.Domain;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    Long id;
    List<OrderItem> items;
    Recipient recipient;
    OrderStatus status;
    LocalDateTime createdAt;

    BigDecimal totalPrice()
    {
        return items.stream()
                .map(item -> item.getBook().getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setCreateAt(LocalDateTime now) {

    }
}
