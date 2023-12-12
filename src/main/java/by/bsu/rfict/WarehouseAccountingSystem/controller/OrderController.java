package by.bsu.rfict.WarehouseAccountingSystem.controller;

import by.bsu.rfict.WarehouseAccountingSystem.dto.OrderDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Order;
import by.bsu.rfict.WarehouseAccountingSystem.mapper.OrderMapper;
import by.bsu.rfict.WarehouseAccountingSystem.service.ItemService;
import by.bsu.rfict.WarehouseAccountingSystem.service.OrderService;
import by.bsu.rfict.WarehouseAccountingSystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderMapper orderMapper;
    @PostMapping("/customer/make-order")
    public Order makeOrder (@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderMapper.toOrder(orderDto));
    }
}
