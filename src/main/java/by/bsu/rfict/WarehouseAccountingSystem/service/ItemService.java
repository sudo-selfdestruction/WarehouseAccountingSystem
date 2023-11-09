package by.bsu.rfict.WarehouseAccountingSystem.service;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import by.bsu.rfict.WarehouseAccountingSystem.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item findById(Long itemId) {
        Item item = itemRepository.findById(itemId).orElse(null);

        if (item == null) {
            log.info("findById - item with id {} didn't find", itemId);

            return null;
        }
        log.info("findById - item with id {} successfully found", itemId);

        return item;
    }

    public Item findByName(String itemName) {
        Item item = itemRepository.findItemByName(itemName);

        if (item == null) {
            log.info("findById - item with name {} didn't find", itemName);

            return null;
        }
        log.info("findById - item with name {} successfully found", itemName);

        return item;
    }

    public List<Item> findAll() {
        List<Item> itemList = itemRepository.findAll();
        log.info("findAll - found {} items", itemList.size());

        return itemList;
    }

    public Item addItem(Item item) {
        Item newItem = itemRepository.save(item);
        log.info("addItem - item : {} successfully saved", item);

        return newItem;
    }

    public Item updateItem(Item item, Item updatedItem) {
        BeanUtils.copyProperties(updatedItem, item, "id");
        itemRepository.save(item);
        log.info("updateItem - item : {} successfully updated", item);

        return item;
    }

    public void deleteItem(Item item) {
        if (item == null) {
            log.info("deleteItem - item doesn't exist");
        }

        itemRepository.delete(item);
        log.info("deleteItem - item : {} successfully deleted", item);
    }
}
