/*package com.microshop.order_service.service;

import com.microshop.order_service.model.Order;
import com.microshop.order_service.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderServiceTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testCreateOrder() {
        Order order = Order.builder()
                .userId("U100")
                .productId("P200")
                .quantity(3)
                .totalPrice(1500.0)
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .build();

        Order saved = orderRepository.save(order);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getUserId()).isEqualTo("U100");
    }
}
*/