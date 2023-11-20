package by.bsu.rfict.WarehouseAccountingSystem.mapper;

import by.bsu.rfict.WarehouseAccountingSystem.dto.OrderDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Order;
import by.bsu.rfict.WarehouseAccountingSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrderMapper {
    @Autowired
    OrderService orderService;
    public Order toOrder(OrderDto orderDto) {
        return Order.builder()
                .order_date(LocalDate.now())
                .weight(orderService.calcWeight(orderDto))
                .cost(orderService.calcCost(orderDto))
                .build();
    } 
}