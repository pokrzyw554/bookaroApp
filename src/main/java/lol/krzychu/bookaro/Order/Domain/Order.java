package lol.krzychu.bookaro.Order.Domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Order {
    Long id;

    List<OrderItem> items;
    Recipient recipient;
    @Builder.Default
    OrderStatus status = OrderStatus.NEW;
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
