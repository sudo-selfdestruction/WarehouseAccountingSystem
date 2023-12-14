package by.bsu.rfict.WarehouseAccountingSystem.mapper;

import by.bsu.rfict.WarehouseAccountingSystem.dto.ItemDto;
import by.bsu.rfict.WarehouseAccountingSystem.dto.OrderDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import by.bsu.rfict.WarehouseAccountingSystem.service.ItemService;
import by.bsu.rfict.WarehouseAccountingSystem.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ItemMapper {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;

    public Item toItem(ItemDto itemDto) {
        return itemService.findByName(itemDto.getName());
    }

    public List<Item> toItemList(OrderDto orderDto) {
        List<Item> itemList = new ArrayList<Item>();
        for (ItemDto itemDto: orderDto.getItemDtoList()) {
            itemList.add(itemService.findByName(itemDto.getName()));
        }
        return itemList;
    }
}
