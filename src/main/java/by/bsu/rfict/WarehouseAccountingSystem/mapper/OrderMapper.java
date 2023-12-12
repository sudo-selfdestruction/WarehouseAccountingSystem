package by.bsu.rfict.WarehouseAccountingSystem.mapper;

import by.bsu.rfict.WarehouseAccountingSystem.dto.OrderDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Order;
import by.bsu.rfict.WarehouseAccountingSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static by.bsu.rfict.WarehouseAccountingSystem.mapper.ItemMapper.toItemList;

@Component
public class OrderMapper {
    @Autowired
    private OrderService orderService;

    public Order toOrder(OrderDto orderDto) {
        List<Item> itemList = toItemList(orderDto);
        return Order.builder()
                .order_date(LocalDate.now())
                .itemList(itemList)
                .weight(orderService.calcWeight(itemList))
                .cost(orderService.calcCost(itemList))
                .description(orderDto.getDescription())
                .build();
    } 
}