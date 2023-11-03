package by.bsu.rfict.WarehouseAccountingSystem.service;

import by.bsu.rfict.WarehouseAccountingSystem.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
}
