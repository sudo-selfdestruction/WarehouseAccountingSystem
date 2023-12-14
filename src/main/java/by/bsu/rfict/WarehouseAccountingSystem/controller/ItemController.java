package by.bsu.rfict.WarehouseAccountingSystem.controller;

import by.bsu.rfict.WarehouseAccountingSystem.dto.ItemDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import by.bsu.rfict.WarehouseAccountingSystem.mapper.ItemMapper;
import by.bsu.rfict.WarehouseAccountingSystem.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemMapper itemMapper;
    @GetMapping("/item/{id}")
    public ItemDto getItem(@PathVariable("id") Item item) {
        ItemDto itemDto = itemMapper.toItemDto(item);
        log.info("getItem - item : {} ", item);
        return itemDto;
    }

    @GetMapping("/item")
    public List<ItemDto> getAllItems() {
        List<Item> itemList = itemService.findAll();
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (Item item : itemList) {
            itemDtoList.add(itemMapper.toItemDto(item));
        }
        log.info("getAllItems - {} items", itemDtoList.size());

        return itemDtoList;
    }
}
