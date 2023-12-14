package by.bsu.rfict.WarehouseAccountingSystem.mapper;

import by.bsu.rfict.WarehouseAccountingSystem.dto.OrderDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Order;
import by.bsu.rfict.WarehouseAccountingSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OrderMapper {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemMapper itemMapper;

    public Order toOrder(OrderDto orderDto) {
        List<Item> itemList = itemMapper.toItemList(orderDto);
        return Order.builder()
                .order_date(LocalDate.now())
                .itemList(itemList)
                .weight(orderService.calcWeight(itemList))
                .cost(orderService.calcCost(itemList))
                .description(orderDto.getDescription())
                .storage_period(7)
                .build();
    }
    public OrderDto toOrderDto(Order order) {
        return OrderDto.builder()
                .itemDtoList(itemMapper.toItemDtoList(order.getItemList()))
                .description(order.getDescription())
                .build();
    }
}