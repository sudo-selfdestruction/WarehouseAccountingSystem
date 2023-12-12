package by.bsu.rfict.WarehouseAccountingSystem.dto;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
    private String name;
    private String description;
    private String manufacturingCountry;
    private int cost;
    private double weight;

    public static ItemDto createItemDtoFromItem(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getName());
        itemDto.setDescription(item.getDescription());
        itemDto.setManufacturingCountry(item.getManufacturingCountry());
        itemDto.setCost(item.getCost());
        itemDto.setWeight(item.getWeight());

        return itemDto;
    }
}
